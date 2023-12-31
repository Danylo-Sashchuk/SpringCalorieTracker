package com.calorietracker.app.repository.inmemory;

import com.calorietracker.app.model.Meal;
import com.calorietracker.app.repository.MealRepository;
import com.calorietracker.app.util.MealsUtil;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Danylo Sashchuk <br>
 * 10/28/23
 */

public class InMemoryMealRepository implements MealRepository {
    private final Map<Integer, Meal> repository = new ConcurrentHashMap<>();
    private final AtomicInteger counter = new AtomicInteger(0);

    {
        MealsUtil.meals.forEach(this::save);
    }

    @Override
    public Meal save(Meal meal) {
        if (meal.isNew()) {
            meal.setId(counter.incrementAndGet());
            repository.put(meal.getId(), meal);
            return meal;
        }
        if (repository.containsKey(meal.getId())) {
            return repository.put(meal.getId(), meal);
        } else {
            Meal newMeal = new Meal(counter.incrementAndGet(), meal.getDateTime(), meal.getDescription(),
                    meal.getCalories());
            return repository.put(newMeal.getId(), newMeal);
        }
    }

    @Override
    public boolean delete(int id) {
        return repository.remove(id) != null;
    }

    @Override
    public Meal get(int id) {
        return repository.get(id);
    }

    @Override
    public Collection<Meal> getAll() {
        return repository.values();
    }
}

