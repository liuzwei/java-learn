package com.algorithm.center;

import com.algorithm.binarytree.TreeNode;

import java.util.HashSet;

/**
 * 给定一个包含n + 1 个整数的数组nums ，其数字都在[1, n]范围内（包括 1 和 n），可知至少存在一个重复的整数。
 *
 * 假设 nums 只有 一个重复的整数 ，返回这个重复的数 。
 *
 * 你设计的解决方案必须 不修改 数组 nums 且只用常量级 O(1) 的额外空间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/find-the-duplicate-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author liuzhaowei
 * @date 2022/6/16 11:00
 */
public class LeetCode287 {

    /**
     * 快慢指针
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        int fast = 0, slow = 0;
        while (true){
            fast = nums[nums[fast]];
            slow = nums[slow];
            if (fast == slow) {
                break;
            }
        }
        int finder = 0;
        while (true){
            finder = nums[finder];
            slow = nums[slow];
            if (slow == finder) {
                break;
            }
        }
        return finder;
    }

    /**
     * 二分查找法
     *
     * @param nums
     * @return
     */
    public int findDuplicate4(int[] nums) {
        int fast = 0, slow = 0;
        while (true){
            fast = nums[nums[fast]];
            slow = nums[slow];
            if (fast == slow) {
                break;
            }
        }
        int finder = 0;
        while (true){
            finder = nums[finder];
            slow = nums[slow];
            if (slow == finder) {
                break;
            }
        }
        return finder;
    }

    /**
     * 利用二叉树，向二叉树中添加元素，放不下则重复
     * @param nums
     * @return
     */
    public int findDuplicate3(int[] nums) {

        return 0;
    }

    /**
     * 利用hashset的特性，不重复
     * @param nums
     * @return
     */
    public int findDuplicate2(int[] nums) {
        HashSet<Object> set = new HashSet<>();
        for (int i=0; i<nums.length; i++) {
            // 插入前的size
            int beforeSize = set.size();
            // 插入数据
            set.add(nums[i]);
            // 插入后的size
            int afterSize = set.size();
            // 如果size不变，说明数据重复
            if (beforeSize == afterSize) {
                return nums[i];
            }
        }
        return 0;
    }

    /**
     * for双循环暴力破解
     * @param nums
     * @return
     */
    public int findDuplicate1(int[] nums) {
        int index = 0;

        for(int i=0; i<nums.length; i++){
            index = i;
            boolean isRepeat = false;
            for(int j=0; j<nums.length; j++){
                if(i == j) continue;
                if(nums[i] == nums[j]) {
                    isRepeat = true;
                    break;
                }
            }
            if(isRepeat){
                break;
            }
        }
        return nums[index];
    }



    public static void main(String[] args) {
        LeetCode287 leetCode287 = new LeetCode287();
        int[] nums = new int[]{1,2,3,4,5,6,7,8,9,5};
        int duplicate = leetCode287.findDuplicate(nums);
        System.out.println(duplicate);
    }
}
