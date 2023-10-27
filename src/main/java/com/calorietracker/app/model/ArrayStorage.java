package com.calorietracker.app.model;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Danylo Sashchuk <p>
 * 10/26/23
 */

public class ArrayStorage implements Storage {
    private final List<Meal> storage = new CopyOnWriteArrayList<>();

    public ArrayStorage() {
    }

    public ArrayStorage(List<Meal> meals) {
        storage.addAll(meals);
    }

    @Override
    public void add(Meal meal) {

    }

    @Override
    public void delete(int id) {
        storage.removeIf(meal -> meal.getId() == id);
    }

    @Override
    public Meal get(int id) {
        for (Meal meal : storage) {
            if (meal.getId() == id) {
                return meal;
            }
        }
        return null;
    }

    @Override
    public void update(Meal meal) {
        delete(meal.getId());
        storage.add(meal);
    }

    @Override
    public void deleteAll() {

    }

    @Override
    public Meal[] getAll() {
        return storage.toArray(new Meal[0]);
    }
}
