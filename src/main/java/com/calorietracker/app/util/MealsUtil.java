package com.calorietracker.app.util;

import com.calorietracker.app.model.Meal;
import com.calorietracker.app.model.MealTo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.Collection;

/**
 * Danylo Sashchuk <br>
 * 10/28/23
 */

public class MealsUtil {
    public static final int DEFAULT_CALORIES_PER_DAY = 2000;
    public static final List<Meal> meals = createMeals();

    private static List<Meal> createMeals() {
        List<Meal> meals = new ArrayList<>();
        meals.add(new Meal(LocalDateTime.of(2023, Month.OCTOBER, 26, 10, 55), "Omelet", 150));
        meals.add(new Meal(LocalDateTime.of(2023, Month.OCTOBER, 26, 13, 10), "Sandwich", 700));
        meals.add(new Meal(LocalDateTime.of(2023, Month.OCTOBER, 27, 20, 12), "Pork", 500));
        meals.add(new Meal(LocalDateTime.of(2023, Month.OCTOBER, 27, 18, 30), "French Fries", 300));
        meals.add(new Meal(LocalDateTime.of(2023, Month.OCTOBER, 26, 10, 0), "Fish", 400));
        meals.add(new Meal(LocalDateTime.of(2023, Month.OCTOBER, 26, 13, 0), "Apple", 50));
        meals.add(new Meal(LocalDateTime.of(2023, Month.OCTOBER, 27, 20, 0), "Beer", 300));
        return meals;
    }

    public static List<MealTo> getTos(Collection<Meal> meals, int caloriesPerDay) {
        return filterByPredicate(meals, caloriesPerDay, meal -> true);
    }

    public static List<MealTo> getFilteredTos(Collection<Meal> meals, int caloriesPerDay, LocalTime startTime,
                                              LocalTime endTime) {
        return filterByPredicate(meals, caloriesPerDay, meal -> DateTimeUtil.isBetweenHalfOpen(meal.getTime(),
                startTime, endTime));
    }

    private static List<MealTo> filterByPredicate(Collection<Meal> meals, int caloriesPerDay, Predicate<Meal> filter) {
        Map<LocalDate, Integer> caloriesSumByDate = meals.stream()
                .collect(
                        Collectors.groupingBy(Meal::getDate, Collectors.summingInt(Meal::getCalories))
                );

        return meals.stream()
                .filter(filter)
                .map(meal -> createTo(meal, caloriesSumByDate.get(meal.getDate()) > caloriesPerDay))
                .collect(Collectors.toList());
    }

    private static MealTo createTo(Meal meal, boolean excess) {
        return new MealTo(meal.getId(), meal.getDateTime(), meal.getDescription(), meal.getCalories(), excess);
    }
}
