package com.guonl.functionalInterface;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by guonl
 * Date 2018/5/29 下午5:46
 * Description:
 */
public class ListenCall {

    ConcurrentHashMap<String,GofFunction<ParamContext, ParamContext>> methodMap=new ConcurrentHashMap<String,GofFunction<ParamContext, ParamContext>>();
    ConcurrentHashMap<String,ParamContext> paramMap=new ConcurrentHashMap<String,ParamContext>();

    /**
     * 获取请求编号
     * @return
     */
    public  String getCallId(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
    /**
     * 监听返回值
     * @param method
     * @param callId
     * @param context
     */
    public void listenResult(GofFunction<ParamContext, ParamContext> method,String callId,ParamContext context) {
        methodMap.put(callId, method);
        paramMap.put(callId, context);
    }
    /**
     * 等待处理结果
     * @param result
     * @param callId
     */
    public  void waitForResult(ParamContext result,String callId){
        GofFunction<ParamContext, ParamContext> funtion=methodMap.get(callId);
        if(funtion!=null){
            ParamContext context=paramMap.get(callId);
            if(context==null){
                context=new ParamContext();
            }
            funtion.execute(result,context);
        }

    }
}
