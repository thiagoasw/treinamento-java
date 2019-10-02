package com.java.samples.date;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class DateApi {

    public static void main(String[] args) {

        LocalDateTime dt = LocalDateTime.now();

        System.out.println(dt);
        System.out.println(add(dt, 10));

    }

    public static LocalDateTime add(LocalDateTime date, int workdays) {

        if (workdays < 1) {
            return date;
        }

        LocalDateTime result = date;
        
        int addedDays = 0;
        
        while (addedDays < workdays) {
            result = result.plusDays(1);
            if (!(result.getDayOfWeek() == DayOfWeek.SATURDAY ||
                    result.getDayOfWeek() == DayOfWeek.SUNDAY)) {
                ++addedDays;
            }
        }

        return result;
    }

}
