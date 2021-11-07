package com.company.leetcode.q0405;

/**
 * 直接用二进制的与运算
 *
 * @author 赵丙双
 * @since 2021.10.26
 */
public class Solution3 {

    private final static String[] DIGITS = {
            "0" , "1" , "2" , "3" , "4" , "5" ,
            "6" , "7" , "8" , "9" , "a" , "b" ,
            "c" , "d" , "e" , "f"
    };

    private final static int N_15 = 0xf;

    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }

        StringBuilder builder = new StringBuilder();

        for (int i = 7; i >= 0; i--) {
            int tmp = num >>> (i * 4) & N_15;
            if (tmp != 0 || builder.length() > 0) {
                builder.append(DIGITS[tmp]);
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
//        System.out.println(solution3.toHex(26));
        System.out.println(solution3.toHex(-1));
        System.out.println(-1 & 0xffffffff);
        System.out.println(Integer.toBinaryString(-1 & 0xffffffff));
        System.out.println(Integer.toHexString(-1 & 0xffffffff));
//        System.out.println(solution3.toHex(-9));
//        System.out.println(solution3.toHex(10));

        System.out.println(1 >> 1);
        System.out.println(-1 >> 1);
        System.out.println(-1 >>> 1);

        System.out.println(1 << 1);
        System.out.println(-1 << 1);
        System.out.println(Integer.toBinaryString(-1 << 1));

    }

}
