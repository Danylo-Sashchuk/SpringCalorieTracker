package com.calorietracker.app.model;

public interface Storage {
    void add(Meal meal);

    void delete(int id);

    Meal get(int id);

    void update(Meal meal);

    void deleteAll();

    Meal[] getAll();
}
