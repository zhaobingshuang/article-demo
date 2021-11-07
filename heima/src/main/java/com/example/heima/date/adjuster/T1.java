package com.example.heima.date.adjuster;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

/**
 * xxx
 *
 * @author 赵丙双
 * @since 2021.08.05
 */
public class T1 {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        System.out.println(now);

        LocalDate firstDayOfMonth = now.with(TemporalAdjusters.firstDayOfMonth());
        LocalDate lastDayOfMonth = now.with(TemporalAdjusters.lastDayOfMonth());
        LocalDate firstDayOfNextMonth = now.with(TemporalAdjusters.firstDayOfNextMonth());
        LocalDate firstDayOfYear = now.with(TemporalAdjusters.firstDayOfYear());
        LocalDate lastDayOfYear = now.with(TemporalAdjusters.lastDayOfYear());
        LocalDate firstDayOfNextYear = now.with(TemporalAdjusters.firstDayOfNextYear());

        LocalDate firstInMonth = now.with(TemporalAdjusters.firstInMonth(DayOfWeek.SUNDAY));
        LocalDate lastInMonth = now.with(TemporalAdjusters.lastInMonth(DayOfWeek.SUNDAY));
        LocalDate dayOfWeekInMonth = now.with(TemporalAdjusters.dayOfWeekInMonth(3, DayOfWeek.SUNDAY));

        LocalDate nextSunday = now.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
        LocalDate nextOrSameSunday = now.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));
        LocalDate nextThursday = now.with(TemporalAdjusters.next(DayOfWeek.THURSDAY));
        LocalDate nextOrSameThursday = now.with(TemporalAdjusters.nextOrSame(DayOfWeek.THURSDAY));


        LocalDate previousSunday = now.with(TemporalAdjusters.previous(DayOfWeek.SUNDAY));
        LocalDate previousOrSameSunday = now.with(TemporalAdjusters.previousOrSame(DayOfWeek.SUNDAY));
        LocalDate previousThursday = now.with(TemporalAdjusters.previous(DayOfWeek.THURSDAY));
        LocalDate previousOrSameThursday = now.with(TemporalAdjusters.previousOrSame(DayOfWeek.THURSDAY));

        System.out.println("firstDayOfMonth：" + firstDayOfMonth);
        System.out.println("lastDayOfMonth：" + lastDayOfMonth);
        System.out.println("firstDayOfNextMonth：" + firstDayOfNextMonth);
        System.out.println("firstDayOfYear：" + firstDayOfYear);
        System.out.println("lastDayOfYear：" + lastDayOfYear);
        System.out.println("firstDayOfNextYear：" + firstDayOfNextYear);

        System.out.println("firstInMonth：" + firstInMonth);
        System.out.println("lastInMonth：" + lastInMonth);
        System.out.println("dayOfWeekInMonth：" + dayOfWeekInMonth);

        System.out.println("nextSunday：" + nextSunday);
        System.out.println("nextOrSameSunday：" + nextOrSameSunday);
        System.out.println("nextThursday：" + nextThursday);
        System.out.println("nextOrSameThursday：" + nextOrSameThursday);

        System.out.println("previousSunday：" + previousSunday);
        System.out.println("previousOrSameSunday：" + previousOrSameSunday);
        System.out.println("previousThursday：" + previousThursday);
        System.out.println("previousOrSameThursday：" + previousOrSameThursday);

    }

}
