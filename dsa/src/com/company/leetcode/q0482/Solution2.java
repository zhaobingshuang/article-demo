package com.company.leetcode.q0482;

/**
 * xxx
 *
 * @author 赵丙双
 * @since 2021.10.04
 */
public class Solution2 {

    public String licenseKeyFormatting(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1, j = 0; i >= 0 ; i--) {
            char c = s.charAt(i);
            if (c != '-') {
                sb.append(Character.toUpperCase(c));
                j++;

                if (j == k) {
                    sb.append("-");
                    j = 0;
                }
            }

        }

        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '-') {
            sb.deleteCharAt(sb.length() - 1);
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.licenseKeyFormatting("5F3Z-2e-9-w", 4));
        System.out.println(solution.licenseKeyFormatting("2-5g-3-J", 2));

    }
}
