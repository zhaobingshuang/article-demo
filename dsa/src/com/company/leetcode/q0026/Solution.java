package com.company.leetcode.q0026;

/**
 * 删除有序数组的重复项
 *
 * @author 赵丙双
 * @since 2021.10.03
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return 1;
        }

        int fast = 1;
        int slow = 1;
        for (; fast < nums.length; fast++) {
            int t = nums[fast];
            if (t != nums[slow - 1]) {
                nums[slow++] = t;
            }
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2};
        Solution solution = new Solution();
        int i = solution.removeDuplicates(arr);
        System.out.println(i);


    }
}
