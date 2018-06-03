package com.guonl.functionalInterface;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by guonl
 * Date 2018/5/29 下午5:45
 * Description:
 */
public class ParamContext {

    private Map<String,Object> datas=new HashMap<String,Object>();
    public ParamContext(Object...params){
        if(params==null||params.length==0){
            return;
        }
        for(int i=0;i<params.length;){
            datas.put((String) params[i], params[i+1]);
            i+=2;
        }
    }
    @SuppressWarnings("unchecked")
    public <T> T get(String key){
        return (T)datas.get(key);
    }
}
