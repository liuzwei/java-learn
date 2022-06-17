package com.algorithm.center;

import java.util.HashSet;

/**
 * 最大单词长度乘积
 *
 * 给你一个字符串数组words ，找出并返回 length(words[i]) * length(words[j])的最大值，并且这两个单词不含有公共字母。如果不存在这样的两个单词，返回 0 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/maximum-product-of-word-lengths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author liuzhaowei
 * @date 2022/6/17 11:29
 */
public class LeetCode318 {

    /**
     *
     * @param words
     * @return
     */
    public int maxProduct(String[] words) {

        return 0;
    }

    /**
     * 思路
     * 1.两两比对，没有公共字母，算乘积
     * 2.返回最大的
     * @param words
     * @return
     */
    public int maxProduct1(String[] words) {
        int max = 0;
        for (int i=0; i<words.length; i++) {
            String first = words[i];
            for (int j=i+1; j < words.length; j++){
                String second = words[j];
                // 查看两个单词是否存在公共字母
                HashSet<Character> firstSet = new HashSet<>();
                for (char c : first.toCharArray()){
                    firstSet.add(c);
                }
                HashSet<Character> secondSet = new HashSet<>();
                for (char c : second.toCharArray()){
                    secondSet.add(c);
                }
                // 两个集合合并，数量不变小，说明没有公共字母
                int sum = firstSet.size() + secondSet.size();
                firstSet.addAll(secondSet);
                if (sum == firstSet.size()){
                    // 计算乘积
                    if (first.length()*second.length()>max){
                        max = first.length() * second.length();
                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String[] words = new String[]{"eae","ea","aaf","bda","fcf","dc","ac","ce","cefde","dabae"};
        int i = new LeetCode318().maxProduct(words);
        System.out.println(i);
    }
}
