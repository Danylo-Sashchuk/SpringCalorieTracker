package com.calorietracker.app.web;

import com.calorietracker.app.model.Meal;
import com.calorietracker.app.model.MealTo;
import com.calorietracker.app.util.MealsUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

/**
 * Danylo Sashchuk <p>
 * 10/26/23
 */

public class MealServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(UserServlet.class);
    private static final int DEFAULT_CALORIES_PER_DAY = 2000;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,
            ServletException {
        log.debug("forward to meals.jsp");

        List<Meal> meals = Arrays.asList(
                new Meal(LocalDateTime.of(2023, Month.OCTOBER, 26, 10, 55), "Omelet", 150),
                new Meal(LocalDateTime.of(2023, Month.OCTOBER, 26, 13, 10), "Sandwich", 700),
                new Meal(LocalDateTime.of(2023, Month.OCTOBER, 27, 20, 12), "Pork", 500),
                new Meal(LocalDateTime.of(2023, Month.OCTOBER, 27, 18, 30), "French Fries", 300),
                new Meal(LocalDateTime.of(2023, Month.OCTOBER, 26, 10, 0), "Fish", 400),
                new Meal(LocalDateTime.of(2023, Month.OCTOBER, 26, 13, 0), "Apple", 50),
                new Meal(LocalDateTime.of(2023, Month.OCTOBER, 27, 20, 0), "Beer", 300));
        List<MealTo> mealsTo = MealsUtil.filteredByCycles(meals, LocalTime.of(0, 0), LocalTime.of(23, 59),
                DEFAULT_CALORIES_PER_DAY);
        request.setAttribute("meals", mealsTo);
        request.getRequestDispatcher("/meals.jsp").forward(request, response);
    }
}
