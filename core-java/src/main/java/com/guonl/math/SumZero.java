package com.guonl.math;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guonl
 * Date 2018/4/10 下午5:11
 * Description: 给定一个包含n个整数的数组S，是否存在属于S中的三个元素a，b，c，使得a+b+c=0,
 * 请找出所有不重复的三个元素的组合
 * <p>
 * 定义一个数组s = [-1,0,1,2,-1,4]
 * 返回这样一个结果：
 * [
 * [-1,0,1],
 * [-1,-1,2]
 * ]
 */
public class SumZero {

    @Test
    public void test() {
        int[] arr = {-1,0,1,2,-1,4,-2,-3};
        if (arr.length < 3) {
            System.out.println("数组内的元素不够");

        } else {
            List<int[]> list = new ArrayList();
            for (int i = 0; i < arr.length; i++) {
                for (int j = i + 1; j < arr.length; j++) {
                    for (int z = j + 1; z < arr.length; z++) {
                        if (arr[i] + arr[j] + arr[z] == 0) {
                            int[] temp = new int[3];
                            temp[0] = arr[i];
                            temp[1] = arr[j];
                            temp[2] = arr[z];
                            list.add(temp);
                        }
                    }
                }
            }
            for (int i = 0; i < list.size(); i++) {
                for (int j = 0; j < list.get(i).length; j++) {
                    System.out.print(list.get(i)[j] + ",");
                }
                System.out.println();
            }
        }

    }


}
