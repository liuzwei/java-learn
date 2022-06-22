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
     * 2. 取第三大的数，两两比较，只要有找到两个不一样的，即说明存在第三大的值
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
            if (index == 2) {
                return nums[i-1];
            }
        }
        return nums[nums.length-1];
    }
}
