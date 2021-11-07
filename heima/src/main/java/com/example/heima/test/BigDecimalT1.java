package com.example.heima.test;

import java.math.BigDecimal;
import java.util.concurrent.ConcurrentHashMap;

/**
 * xxx
 *
 * @author 赵丙双
 * @date 2021/4/16
 */
public class BigDecimalT1 {

    public static void main(String[] args) {
//        BigDecimal b1 = new BigDecimal(80);
//        BigDecimal b2 = new BigDecimal(10);
//
//        BigDecimal b3 = b1.divide(b2, 1, BigDecimal.ROUND_HALF_UP);
//        System.out.println(b3);
//        System.out.println(b3.stripTrailingZeros().toPlainString());

        BigDecimal b = new BigDecimal("1.23E+3");
        System.out.println(b.toString());
        System.out.println(b.toPlainString());
        System.out.println(b.toEngineeringString());

        System.out.println();

        BigDecimal b1 = new BigDecimal("1E11");
        System.out.println(b1.toString());
        System.out.println(b1.toPlainString());
        System.out.println(b1.toEngineeringString());

        System.out.println();

        BigDecimal b2 = new BigDecimal("10");
        System.out.println(b2.toString());
        System.out.println(b2.toPlainString());
        System.out.println(b2.toEngineeringString());



    }

}
