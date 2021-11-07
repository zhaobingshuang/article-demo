package com.company.leetcode.q0088;

/**
 * 88. 合并两个有序数组
 *
 * @author 赵丙双
 * @since 2021.10.18
 */
public class Solution2 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] arr = new int[m + n];
        int i = 0, j = 0, k = 0;
        while (i < m || j < n) {
            if (i == m) {
                arr[k++] = nums2[j++];
            } else if (j == n) {
                arr[k++] = nums1[i++];
            } else if (nums1[i] < nums2[j]) {
                arr[k++] = nums1[i++];
            } else if (nums1[i] > nums2[j]) {
                arr[k++] = nums2[j++];
            } else {
                arr[k++] = nums1[i++];
                arr[k++] = nums2[j++];
            }
        }
        System.arraycopy(arr, 0, nums1, 0, m + n);
    }
}
