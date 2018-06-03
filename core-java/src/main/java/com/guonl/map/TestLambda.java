package com.guonl.map;


import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by guonl
 * Date 2018/5/24 下午4:27
 * Description:
 */
public class TestLambda {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(3,8,4,7,5);

        List<Map<String,String>> listMap = Lists.newArrayList();

        for (int i = 0; i < 10; i++) {
            Map<String,String> map = new HashMap<>();
            int x = 2;
            map.put("big", String.valueOf(2*x));
            map.put("small",String.valueOf(3*x));
            map.put("mall",String.valueOf(4*x));
            map.put("code",String.valueOf(5*x));
            listMap.add(map);
            x++;
        }





    }


}
