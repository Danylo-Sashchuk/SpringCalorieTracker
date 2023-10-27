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

    private final int id;

    public MealTo(LocalDateTime dateTime, String description, int calories, int id, boolean excess) {
        this.dateTime = dateTime;
        this.description = description;
        this.calories = calories;
        this.id = id;
        this.excess = excess;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public boolean isExcess() {
        return excess;
    }

    public int getCalories() {
        return calories;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "MealTo{" + "dateTime=" + dateTime + ", description='" + description + '\'' + ", calories" +
               "=" + calories + ", id='" + id + "', excess=" + excess + '}';
    }
}
