package com.algorithm.easy;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author liuzhaowei
 * @date 2022/6/22 16:35
 */
public class LeetCode414 {

    /**
     * 第三大的数
     * 思路：
     * 1. 排序
     * 2. 取第三大的数
     * @param nums
     * @return
     */
    public int thirdMax(int[] nums) {
        // 排序
        Arrays.sort(nums);
        // 找第三个大的
        int index = 0;
        for (int i=nums.length-1; i>0; i--) {
            if (nums[i]!=nums[i-1]) {
                index++;
            }
            if (index == 3) {
                return nums[i];
            }
        }
        return nums[nums.length-1];
    }
}
