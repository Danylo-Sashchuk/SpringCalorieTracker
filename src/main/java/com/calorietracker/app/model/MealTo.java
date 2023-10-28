package com.calorietracker.app.model;

import java.time.LocalDateTime;

/**
 * Danylo Sashchuk <br>
 * 10/17/23
 */

public class MealTo {
    private final Integer id;

    private final LocalDateTime dateTime;

    private final String description;

    private final int calories;

    private final boolean excess;

    public MealTo(Integer id, LocalDateTime dateTime, String description, int calories, boolean excess) {
        this.id = id;
        this.dateTime = dateTime;
        this.description = description;
        this.calories = calories;
        this.excess = excess;
    }

    public Integer getId() {
        return id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getDescription() {
        return description;
    }

    public int getCalories() {
        return calories;
    }

    public boolean isExcess() {
        return excess;
    }

    @Override
    public String toString() {
        return "MealTo{" + "dateTime=" + dateTime + ", id=" + id +", description='" + description + '\'' + ", calories" + "=" + calories + "', excess=" + excess + '}';
    }
}
