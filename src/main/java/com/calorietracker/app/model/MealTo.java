package com.calorietracker.app.model;

import java.time.LocalDateTime;

/**
 * Danylo Sashchuk
 * 10/17/23
 */

public class MealTo {
    private final LocalDateTime dateTime;
    private final String description;

    private final int calories;

    private final boolean excess;

    public MealTo(LocalDateTime dateTime, String description, int calories, boolean excess) {
        this.dateTime = dateTime;
        this.description = description;
        this.calories = calories;
        this.excess = excess;
    }

    @Override
    public String toString() {
        return "MealTo{" + "dateTime=" + dateTime + ", description='" + description + '\'' + ", calories" +
               "=" + calories + ", excess=" + excess + '}';
    }
}