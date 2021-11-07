package com.company.leetcode.q0704;

/**
 * 二分查找
 *
 * @author 赵丙双
 * @since 2021.10.12
 */
public class Solution {

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {5};
        int target = 5;
        Solution solution = new Solution();
        System.out.println(solution.search(nums, target));
    }
}
