package com.yihaoxing.demo.test.leetcode;

/**
 * <p></p>
 *
 * @author yihaoxing
 * @since 2022/9/18 16:01
 */
public class Solution {

    public static void main(String[] args) {
//        String s = "abcabcbb";
//        String s = "bbbbb";
//        String s = "pwwkew";
        String s = "dvdf";
        System.out.println(lengthOfLongestSubstring(s, 0));
    }

    public static int lengthOfLongestSubstring(String s, int max) {
        StringBuilder builder = new StringBuilder();
        int count = 0;
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (builder.indexOf(String.valueOf(c)) >= 0) {
                s = s.substring(1);
                max = Math.max(count, max);
                return lengthOfLongestSubstring(s, max);
            }
            count++;
            builder.append(c);
        }
        return Math.max(count, max);
    }
}
