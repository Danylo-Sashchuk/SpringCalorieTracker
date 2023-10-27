package com.calorietracker.app.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Danylo Sashchuk
 * 10/17/23
 */

public class Meal {
    private final LocalDateTime dateTime;
    private final int id;

    private final String description;

    private final int calories;

    public Meal(LocalDateTime dateTime, String description, int calories, int id) {
        this.dateTime = dateTime;
        this.description = description;
        this.calories = calories;
        this.id = id;
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

    public LocalDate getDate() {
        return dateTime.toLocalDate();
    }

    public int getId() {
        return id;
    }

    public LocalTime getTime() {
        return dateTime.toLocalTime();
    }
}
