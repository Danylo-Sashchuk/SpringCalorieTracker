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
        storage.remove(meal);
        storage.add(meal);
    }

    @Override
    public void delete(int id) {
        storage.remove(id);
    }

    @Override
    public Meal get(int id) {
        return storage.get(id);
    }

    @Override
    public void update(Meal meal) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public Meal[] getAll() {
        return storage.toArray(new Meal[0]);
    }
}
