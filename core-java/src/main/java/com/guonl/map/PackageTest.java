package com.guonl.map;

import com.google.common.collect.Lists;

import java.util.*;

/**
 * Created by guonl
 * Date 2018/5/23 下午10:17
 * Description:
 */
public class PackageTest {

    public static void main(String[] args) {

        TestVo vo1 = new TestVo("11","21");
        TestVo vo2 = new TestVo("11","22");
        TestVo vo3 = new TestVo("12","21");
        TestVo vo4 = new TestVo("12","22");

        List<TestVo> list = Lists.newArrayList();
        list.add(vo1);
        list.add(vo2);
        list.add(vo3);
        list.add(vo4);

        Set<String> set01 = new HashSet<>();
        Set<String> set02 = new HashSet<>();
        for (TestVo testVo : list) {
            set01.add(testVo.getS1());
            set02.add(testVo.getS2());
        }

        List result = Lists.newArrayList();
        for (String s1 : set01) {
            Map<String,Object> map01 = new HashMap<>();
            List list2 = Lists.newArrayList();
            for (String s2 : set02) {
                Map<String,Object> map02 = new HashMap<>();
                List<TestVo> list1 = new ArrayList<>();
                for (TestVo testVo : list) {
                    if(s1.equals(testVo.getS1()) && s2.equals(testVo.getS2())){
                        list1.add(testVo);
                    }
                }
                map02.put("scode",s2);
                map02.put("voList",list1);
                list2.add(map02);
            }
            map01.put("",s1);


        }









    }
}
