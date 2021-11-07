package com.company.leetcode.q0405;

/**
 * 数字转换为十六进制数
 *
 * 32 为有符号数可以用 8 个 16 进制数表示，
 * 不需要考虑负数需要用补码表示的问题，因为计算机本身就是用补码表示负数，
 * 只需要简单的 4 个为一组转换成 16 进制就可以了
 *
 * 注意点：
 * 1、不要有前导 0
 * 2、不要漏掉后缀 0
 *
 * @author 赵丙双
 * @since 2021.10.03
 */
public class Solution {

    private final static String[] DIGITS = {
            "0" , "1" , "2" , "3" , "4" , "5" ,
            "6" , "7" , "8" , "9" , "a" , "b" ,
            "c" , "d" , "e" , "f"
    };

    private final static int FIFTEEN = 0xf;

    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 7; i >= 0; i--) {
            int t = (num >>> (i * 4)) & FIFTEEN;
            // 1、不要有前导 0
            // 2、不要漏掉后缀 0
            if (t != 0 || builder.length() > 0) {
                builder.append(DIGITS[t]);
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.toHex(16));
//        System.out.println(solution.toHex(26));
//        System.out.println(solution.toHex(-1));

        System.out.println(3 >> 1);
        System.out.println(3 << 1);
        System.out.println(3 >>> 1);

        System.out.println(-3 >> 1);
        System.out.println(-3 << 1);
        System.out.println(-3 >>> 1);
    }
}
