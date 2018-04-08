package com.guonl.nio.nioexample;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class WebServer {
	public static void main(String[] args) {
		try {
			ServerSocketChannel server=ServerSocketChannel.open();
			server.bind(new InetSocketAddress("127.0.0.1", 8888));
			
			SocketChannel client=server.accept();
			System.out.println("ִ��");
			ByteBuffer byteBuffer=ByteBuffer.allocate(128);
			int size=client.read(byteBuffer);
			System.out.println("��ȡ��"+size+"�ֽ�");
			
			byteBuffer.flip();
			String clientworld=new String(byteBuffer.array(),0,size);
			System.out.println(clientworld);
			
			/*System.out.println("λ��"+byteBuffer.position()+"-"+byteBuffer.limit());
			byteBuffer.flip();
			System.out.println("λ��"+byteBuffer.position()+"-"+byteBuffer.limit());
			while(byteBuffer.hasRemaining()) {
				System.out.println(byteBuffer.getChar());
			}*/
			server.close();
			client.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
