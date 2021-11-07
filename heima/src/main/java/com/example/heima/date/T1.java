package com.example.heima.date;

import java.time.*;
import java.time.temporal.TemporalAdjusters;
import java.util.Set;

public class T1 {

    public static void main(String[] args) {

        MonthDay now = MonthDay.now();
        System.out.println(now);

        Clock systemDefaultZone = Clock.systemDefaultZone();
        Clock systemUTC = Clock.systemUTC();



        System.out.println(systemDefaultZone);
        System.out.println(systemUTC);

        System.out.println(systemDefaultZone.millis());
        System.out.println(systemUTC.millis());

        System.out.println(systemDefaultZone.getZone());
        System.out.println(systemUTC.getZone());

        System.out.println(systemDefaultZone.instant());
        System.out.println(systemUTC.instant());


        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        availableZoneIds.forEach(System.out::println);

        LocalTime now1 = LocalTime.now();

        LocalDate now2 = LocalDate.now();

        Duration duration = Duration.ofHours(1+24);
        TemporalAdjusters.firstDayOfMonth().adjustInto(now1);


    }

}
