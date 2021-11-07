package com.example.heima.test;

import java.math.BigDecimal;

/**
 * xxx
 *
 * @author 赵丙双
 * @date 2021/4/16
 */
public class BigDecimalT2 {

    public static void main(String[] args) {



BigDecimal b = new BigDecimal("2.5");
System.out.println(b.intValue());
//        System.out.println(b.intValueExact());

System.out.println("---");

BigDecimal b1 = new BigDecimal("2.1");
System.out.println(b1.intValue());
//        System.out.println(b1.intValueExact());

System.out.println("---");

BigDecimal b2 = new BigDecimal("2.8");
System.out.println(b2.intValue());
//        System.out.println(b2.intValueExact());

System.out.println("---");

BigDecimal b3 = new BigDecimal("2.0");
System.out.println(b3.intValue());
System.out.println(b3.intValueExact());
    }

}
