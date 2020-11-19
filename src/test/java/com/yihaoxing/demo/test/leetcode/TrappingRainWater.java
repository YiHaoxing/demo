package com.yihaoxing.demo.test.leetcode;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author yhx
 * @date 2020/11/13 5:36 下午
 */
@SpringBootTest
public class TrappingRainWater {

    /*
    题目:https://leetcode-cn.com/problems/trapping-rain-water/
     */
    @Test
    public void test() {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(height));
    }

    public int trap(int[] height) {

        int length = height.length;

        int sum = 0;

        for (int i = 1; i < length - 1; i++) {
            int maxLeft = 0;
            int maxRight = 0;

            //找左边比当前值大的最大的值,没有那就是自己.
            for (int j = i; j >= 0; j--) {
                maxLeft = Math.max(maxLeft, height[j]);
            }
            //找右边比当前值大的最大的值,没有那就是自己.
            for (int j = i; j < length; j++) {
                maxRight = Math.max(maxRight, height[j]);
            }


            sum += Math.min(maxLeft, maxRight) - height[i];
        }
        return sum;
    }
}
