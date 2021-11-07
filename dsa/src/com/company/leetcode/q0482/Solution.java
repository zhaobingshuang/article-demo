package com.company.leetcode.q0482;

/**
 * xxx
 *
 * @author 赵丙双
 * @since 2021.10.04
 */
public class Solution {

    public String licenseKeyFormatting(String s, int k) {
        int length;
        if (s == null || (length = s.length()) == 0) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = length - 1, j = 0; i >= 0 ; i--) {
            char c = s.charAt(i);
            if (c != '-') {
                if (j == k) {
                    sb.append("-");
                    j = 0;
                }
                sb.append(Character.toUpperCase(c));
                j++;
            }

        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.licenseKeyFormatting("5F3Z-2e-9-w", 4));
        System.out.println(solution.licenseKeyFormatting("2-5g-3-J", 2));

    }
}
