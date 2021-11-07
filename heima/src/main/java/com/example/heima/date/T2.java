package com.example.heima.date;

import java.time.Duration;
import java.time.LocalTime;

/**
 * xxx
 *
 * @author 赵丙双
 * @since 2021.07.05
 */
public class T2 {

    public static void main(String[] args) {
        LocalTime t1 = LocalTime.of(0, 0, 0);
        LocalTime t2 = LocalTime.of(0, 0, 1, 9999999);

        Duration duration = Duration.between(t1, t2);
        System.out.println(duration);
        System.out.println(duration.getSeconds());
        System.out.println(duration.getNano());





    }
}
