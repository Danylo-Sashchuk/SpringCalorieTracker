package com.calorietracker.app.repository;

import com.calorietracker.app.model.Meal;

import java.util.Collection;

/**
 * Danylo Sashchuk <br>
 * 10/28/23
 */

public interface MealRepository {
    // null if not found, when updated
    Meal save(Meal meal);

    // false if not found
    boolean delete(int id);

    // null if not found
    Meal get(int id);

    Collection<Meal> getAll();
}
