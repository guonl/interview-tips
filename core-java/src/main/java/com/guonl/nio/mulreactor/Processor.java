package com.guonl.nio.mulreactor;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Processor {
	
	private ExecutorService pool=Executors.newFixedThreadPool(2*Runtime.getRuntime().availableProcessors());
	private Selector selector;
	public Processor() {
		try {
			selector=SelectorProvider.provider().openSelector();
			process();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void  addChannel(SocketChannel client) {
		try {
			//�ᱻselect()��������
			client.register(selector, SelectionKey.OP_READ);
			//selector.wakeup();
		} catch (ClosedChannelException e) {
			e.printStackTrace();
		}
	}
	
	public void wakeup() {
		selector.wakeup();
	}
	
	private void process() {
		pool.execute(()->{
			while(true) {
					try {
						//ʹ��select()����һ�����⣬wakeup������������̵߳�register���û��ִ��
						//���������һ��select����״̬��register�����޷�ִ��
						if(selector.select(500)<=0)
							continue;
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					Set<SelectionKey> keys=selector.selectedKeys();
					Iterator<SelectionKey> iterator=keys.iterator();
					while(iterator.hasNext()) {
						SelectionKey key=iterator.next();
						iterator.remove();
						if(key.isReadable()) {
							SocketChannel client=null;
							try {
								ByteBuffer readBuffer=ByteBuffer.allocate(128);
								client=(SocketChannel)key.channel();
								int size=client.read(readBuffer);
								if(size!=-1) {
									readBuffer.flip();
									String clientWord=new String(readBuffer.array(),0,size);
									System.out.println("clientWord:"+clientWord);
									
									if("wenqi".equals(clientWord)) {
										key.attach("welcome admin wenqi!");
										writeProcess(key);
									}else {
										key.attach("welcome client "+clientWord+"!");
										writeProcess(key);
									}
								}else {
									client.close();
									key.cancel();
									System.out.println("client close:"+client);
								}
							}catch(IOException e) {
								try {
									client.close();
									key.cancel();
									System.out.println("client close:"+client);
								}catch(IOException e2) {
									e2.printStackTrace();
								}
							}
						}
					}
			}
		});
	}

	public static void writeProcess(SelectionKey key) {
		try {
			ByteBuffer writeBuffer=ByteBuffer.allocate(128);
			SocketChannel client=(SocketChannel) key.channel();
			String backword=(String) key.attachment();
			System.out.println("writing:"+backword);
			writeBuffer.put(backword.getBytes());
			writeBuffer.flip();
			client.write(writeBuffer);
		}catch(IOException e) {
			e.printStackTrace();
		}
}
}
