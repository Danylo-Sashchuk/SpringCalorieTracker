package com.calorietracker.app.util;

import java.time.LocalTime;

/**
 * Danylo Sashchuk
 * 10/17/23
 */

public class TimeUtil {
    public static boolean isBetweenHalfOpen(LocalTime lt, LocalTime startTime, LocalTime endTime) {
        return !lt.isBefore(startTime) && lt.isBefore(endTime);
    }
}
