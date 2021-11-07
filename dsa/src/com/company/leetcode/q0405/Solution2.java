package com.company.leetcode.q0405;

/**
 * 数字转换为十六进制数
 *
 * 不断对 16 取余，然后 除以 16
 * 需要考虑负数，负数小先转换为对应的补码所表示的十进制数
 *
 * @author 赵丙双
 * @since 2021.10.03
 */
public class Solution2 {

    private final static String[] DIGITS = {
            "0" , "1" , "2" , "3" , "4" , "5" ,
            "6" , "7" , "8" , "9" , "a" , "b" ,
            "c" , "d" , "e" , "f"
    };

    private final static long INT_MOD = 0x100000000L;

    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }

        // 若为负数，则取补码，负数的补码 = 2^32 - 绝对值 = 2^32 + 本身
        long n = num > 0 ? num : num + INT_MOD;

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            int mod = (int) (n % 16);
            if (n != 0) {
                builder.append(DIGITS[mod]);
                n = n >>> 4;
            } else {
                break;
            }
        }
        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.toHex(16));
        System.out.println(solution.toHex(26));
        System.out.println(solution.toHex(-1));

        System.out.println();
        System.out.println(3 >> 1);
        System.out.println(3 << 1);
        System.out.println(3 >>> 1);

        System.out.println(-3 >> 1);
        System.out.println(-3 << 1);
    }
}
