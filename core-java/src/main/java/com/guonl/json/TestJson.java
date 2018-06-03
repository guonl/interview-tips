package com.guonl.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;

import java.util.Collection;
import java.util.LinkedHashMap;

/**
 * Created by guonl
 * Date 2018/5/11 上午11:22
 * Description: map的序列化排序问题
 */
public class TestJson {


    /**
     * 序列化与反序列  排序问题
     * fastjson
     */
    public static void main(String[] args) {
        JSONObject map=new JSONObject(true);
        map.put("请假类型","1");
        map.put("单据状态","2");
        map.put("开始时间","3");
        map.put("结束时间","4");
        map.put("请假原因","5");
        System.out.println(map.toString());

        //单嵌套
        // OkhttpUtils.println(map.toString());
        //JSONObject root=JSON.parseObject(map.toString());
        LinkedHashMap<String, Object> root= JSON.parseObject(map.toString(),new TypeReference<LinkedHashMap<String, Object>>(){} );
        //OkhttpUtils.println(JSON.toJSONString(root));
        //JSONObject json=new JSONObject(true);
        //json.putAll(root);
        Collection<Object> lists=root.values();
        for (Object object : lists) {
            //OkhttpUtils.println(object.toString());
        }
        //组合嵌套JSON
        String mapStr="{\"key9\":\"value1\",\"key8\":{\"key28\":\"value21\",\"key27\":\"value22\",\"key23\":\"value23\",\"key24\":\"value24\"},\"key3\":\"value3\",\"key4\":\"value4\",\"key5\":\"value5\",\"key6\":\"value6\"}";
        LinkedHashMap<String, Object> rootStr=JSON.parseObject(mapStr.toString(),new TypeReference<LinkedHashMap<String, Object>>(){} , Feature.OrderedField);
        System.out.println(JSON.toJSONString(rootStr));
        // OkhttpUtils.println(rootStr.toString());
        JSONObject key2=JSON.parseObject(mapStr,Feature.OrderedField).getJSONObject("key8");
        System.out.println(key2.toString());
    }
}
