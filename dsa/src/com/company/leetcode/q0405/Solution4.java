package com.company.leetcode.q0405;

/**
 * xxx
 *
 * @author 赵丙双
 * @since 2021.10.26
 */
public class Solution4 {

    private final static String[] DIGITS = {
            "0" , "1" , "2" , "3" , "4" , "5" ,
            "6" , "7" , "8" , "9" , "a" , "b" ,
            "c" , "d" , "e" , "f"
    };

    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }

        long n = num < 0 ? 0x100000000L + num : num;

        StringBuilder builder = new StringBuilder();
        while (n != 0) {
            int t = (int) (n % 16);
            builder.append(DIGITS[t]);
            n = n / 16;
        }
        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        Solution4 s = new Solution4();
//        System.out.println(s.toHex(26));
        System.out.println(0x100000000L);
        System.out.println(0x100000000L - 1);
        System.out.println(s.toHex(-1));
//        System.out.println(solution3.toHex(-1));
//        System.out.println(solution3.toHex(-9));
//        System.out.println(solution3.toHex(10));


    }

}
