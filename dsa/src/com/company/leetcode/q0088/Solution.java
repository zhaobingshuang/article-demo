package com.company.leetcode.q0088;

/**
 * 88. 合并两个有序数组
 *
 * @author 赵丙双
 * @since 2021.10.18
 */
public class Solution {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] arr = new int[m + n];
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            int n1 = nums1[i];
            int n2 = nums2[j];
            if (n1 < n2) {
                arr[k++] = n1;
                i++;

            } else if (n1 > n2) {
                arr[k++] = n2;
                j++;
            } else {
                arr[k++] = n1;
                arr[k++] = n2;
                i++;
                j++;
            }
        }

        if (i < m) {
            while (i < m) {
                arr[k++] = nums1[i++];
            }
        } else {
            while (j < n) {
                arr[k++] = nums2[j++];
            }
        }

        System.arraycopy(arr, 0, nums1, 0, m + n);
    }
}
