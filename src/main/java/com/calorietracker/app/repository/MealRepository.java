package com.calorietracker.app.repository;

import com.calorietracker.app.model.Meal;

import java.util.Collection;

/**
 * Danylo Sashchuk <br>
 * 10/28/23
 */

// TODO add userId
public interface MealRepository {
    // null if updated meal does not belong to userId
    Meal save(Meal meal);

    // false if meal does not belong to userId
    boolean delete(int id);

    // null if meal does not belong to userId
    Meal get(int id);

    // ORDERED dateTime desc
    Collection<Meal> getAll();
}
