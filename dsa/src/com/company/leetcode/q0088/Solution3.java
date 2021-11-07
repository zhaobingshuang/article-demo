package com.company.leetcode.q0088;

import java.util.Arrays;

/**
 * 88. 合并两个有序数组 - 逆向
 *
 * @author 赵丙双
 * @since 2021.10.18
 */
public class Solution3 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p = m + n, p1 = m - 1, p2 = n - 1;
        while (p1 >= 0 || p2 >= 0) {
            if (p1 == -1) {
                nums1[--p] = nums2[p2--];
            } else if (p2 == -1) {
                nums1[--p] = nums1[p1--];
            } else if (nums1[p1] > nums2[p2]) {
                nums1[--p] = nums1[p1--];
            } else if (nums1[p1] < nums2[p2]) {
                nums1[--p] = nums2[p2--];
            } else {
                nums1[--p] = nums1[p1--];
                nums1[--p] = nums2[p2--];
            }
        }
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        int[] arr1 = {1, 2, 3, 0, 0, 0};
        int[] arr2 = {2,5,6};

        solution3.merge(arr1, 3, arr2, 3);
        System.out.println(Arrays.toString(arr1));

    }
}