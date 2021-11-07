package com.example.heima.date.valuerange;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ValueRange;

/**
 * xxx
 *
 * @author 赵丙双
 * @since 2021.08.15
 */
public class ValueRangeTest {

    public static void main(String[] args) {
        LocalDate localDate1 = LocalDate.of(2031, 2, 1);
        LocalDate localDate2 = LocalDate.of(2031, 3, 1);

        ValueRange range1 = localDate1.range(ChronoField.DAY_OF_MONTH);
        ValueRange range2 = localDate2.range(ChronoField.DAY_OF_MONTH);

        System.out.println(range1);
        System.out.println(range2);

//        range1.getMaximum()

    }

}
