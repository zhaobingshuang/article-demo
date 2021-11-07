package com.example.heima.date.adjuster;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

/**
 * xxx
 *
 * @author 赵丙双
 * @since 2021.08.14
 */
public class TemporalAdjusterTest {

    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
//        System.out.println(now + "：" + now.getDayOfWeek());
        System.out.println(now);

//        firstDayOfMonth(now);
//        lastDayOfMonth(now);

//        firstDayOfNextMonth(now);

//        firstDayOfYear(now);
//        lastDayOfYear(now);

//        firstDayOfNextYear(now);

//        firstInMonth(now, DayOfWeek.MONDAY);
//        lastInMonth(now, DayOfWeek.MONDAY);

//        dayOfWeekInMonth(now, 2, DayOfWeek.SUNDAY);

//        next(now,DayOfWeek.SATURDAY);
//        nextOrSame(now,DayOfWeek.SATURDAY);
//        previous(now,DayOfWeek.SATURDAY);
//        previousOrSame(now,DayOfWeek.SATURDAY);
//        lastDayOfNextMonth(now);
        nextAfterDays(now, DayOfWeek.SUNDAY, 6);
    }

    public static void firstDayOfMonth(Temporal temporal) {
        Temporal firstDayOfMonth = temporal.with(TemporalAdjusters.firstDayOfMonth());
        System.out.println("firstDayOfMonth：" + firstDayOfMonth);
    }

    public static void lastDayOfMonth(Temporal temporal) {
        Temporal lastDayOfMonth = temporal.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println("lastDayOfMonth：" + lastDayOfMonth);
    }

    public static void firstDayOfNextMonth(Temporal temporal) {
        Temporal firstDayOfNextMonth = temporal.with(TemporalAdjusters.firstDayOfNextMonth());
        System.out.println("firstDayOfNextMonth：" + firstDayOfNextMonth);
    }

    public static void firstDayOfYear(Temporal temporal) {
        Temporal firstDayOfYear = temporal.with(TemporalAdjusters.firstDayOfYear());
        System.out.println("firstDayOfYear：" + firstDayOfYear);
    }

    public static void lastDayOfYear(Temporal temporal) {
        Temporal lastDayOfYear = temporal.with(TemporalAdjusters.lastDayOfYear());
        System.out.println("lastDayOfYear：" + lastDayOfYear);
    }

    public static void firstDayOfNextYear(Temporal temporal) {
        Temporal firstDayOfNextYear = temporal.with(TemporalAdjusters.firstDayOfNextYear());
        System.out.println("firstDayOfNextYear：" + firstDayOfNextYear);
    }

    public static void firstInMonth(Temporal temporal, DayOfWeek dayOfWeek) {
        Temporal firstInMonth = temporal.with(TemporalAdjusters.firstInMonth(dayOfWeek));
        System.out.println("firstInMonth：" + dayOfWeek + "："+ firstInMonth);
    }

    public static void lastInMonth(Temporal temporal, DayOfWeek dayOfWeek) {
        Temporal lastInMonth = temporal.with(TemporalAdjusters.lastInMonth(dayOfWeek));
        System.out.println("lastInMonth：" + dayOfWeek + "："+ lastInMonth);
    }

    public static void dayOfWeekInMonth(Temporal temporal, int ordinal, DayOfWeek dayOfWeek) {
        Temporal dayOfWeekInMonth = temporal.with(TemporalAdjusters.dayOfWeekInMonth(ordinal, dayOfWeek));
        System.out.println("dayOfWeekInMonth：" + ordinal + "：" + dayOfWeek + "："+ dayOfWeekInMonth);
    }

    public static void next(Temporal temporal, DayOfWeek dayOfWeek) {
        Temporal next = temporal.with(TemporalAdjusters.next(dayOfWeek));
        System.out.println("next：" + dayOfWeek + "："+ next);
    }

    public static void nextOrSame(Temporal temporal, DayOfWeek dayOfWeek) {
        Temporal nextOrSame = temporal.with(TemporalAdjusters.nextOrSame(dayOfWeek));
        System.out.println("nextOrSame：" + dayOfWeek + "："+ nextOrSame);
    }

    public static void previous(Temporal temporal, DayOfWeek dayOfWeek) {
        Temporal previous = temporal.with(TemporalAdjusters.previous(dayOfWeek));
        System.out.println("previous：" + dayOfWeek + "："+ previous);
    }

    public static void previousOrSame(Temporal temporal, DayOfWeek dayOfWeek) {
        Temporal previousOrSame = temporal.with(TemporalAdjusters.previousOrSame(dayOfWeek));
        System.out.println("previousOrSame：" + dayOfWeek + "："+ previousOrSame);
    }

    static TemporalAdjuster LAST_DAY_OF_NEXT_MONTH = TemporalAdjusters.ofDateAdjuster(
            (temporal) -> temporal.plusMonths(2).with(ChronoField.DAY_OF_MONTH, 1).minusDays(1));

    public static void lastDayOfNextMonth(Temporal temporal) {
        Temporal lastDayOfNextMonth = temporal.with(LAST_DAY_OF_NEXT_MONTH);
        System.out.println("lastDayOfNextMonth：" + lastDayOfNextMonth);
    }

    public static void nextAfterDays(Temporal temporal, DayOfWeek dayOfWeek, int days) {
        Temporal nextAfterDays = temporal.with(TemporalAdjusters.ofDateAdjuster(
                (input) -> input.plusDays(days).with(TemporalAdjusters.next(dayOfWeek))));
        System.out.println("nextAfterDays：" + nextAfterDays);
    }
}
