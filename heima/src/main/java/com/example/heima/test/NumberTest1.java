package com.example.heima.test;

/**
 * xxx
 *
 * @author 赵丙双
 * @date 2021.05.31
 */
public class NumberTest1 {

    public static void main(String[] args) {
        int a = 60, b = 13;
        System.out.println("a 的二进制：" + Integer.toBinaryString(a)); // 111100
        System.out.println("b 的二进制：" + Integer.toBinaryString(b)); // 1101
        System.out.println("60 的二进制：" + Integer.toHexString(60));
        System.out.println("60 的十六进制：" + Integer.toHexString(60));
        System.out.println("60 的八进制：" + Integer.toOctalString(60));

        int c = a & b;
        System.out.println("a & b：" + c + "，二进制是：" + Integer.toBinaryString(c));

        c = a | b;
        System.out.println("a | b：" + c + "，二进制是：" + Integer.toBinaryString(c));

        c = a ^ b;
        System.out.println("a ^ b：" + c + "，二进制是：" + Integer.toBinaryString(c));

        c = ~a;
        System.out.println("~a：" + c + "，二进制是：" + Integer.toBinaryString(c));

        c = a << 2;
        System.out.println("a << 2：" + c + "，二进制是：" + Integer.toBinaryString(c));

        c = a >> 2;
        System.out.println("a >> 2：" + c + "，二进制是：" + Integer.toBinaryString(c));

        c = a >>> 2;
        System.out.println("a >>> 2：" + c + "，二进制是：" + Integer.toBinaryString(c));
    }
}
