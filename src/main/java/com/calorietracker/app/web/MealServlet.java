package com.calorietracker.app.web;

import com.calorietracker.app.model.ArrayStorage;
import com.calorietracker.app.model.Meal;
import com.calorietracker.app.model.MealTo;
import com.calorietracker.app.model.Storage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static com.calorietracker.app.util.MealsUtil.filteredByCycles;

/**
 * Danylo Sashchuk <p>
 * 10/26/23
 */

public class MealServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(UserServlet.class);
    private static final int DEFAULT_CALORIES_PER_DAY = 2000;
    private AtomicInteger id = new AtomicInteger(0);
    private final Storage meals = new ArrayStorage(createMeals());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,
            ServletException {
        log.debug("forward to meals.jsp");

        String forward = "";
        String action = request.getParameter("action");

        if (action == null) {
            request.setAttribute("meals", getList(meals));
            forward = "meals.jsp";
            request.getRequestDispatcher(forward).forward(request, response);
        } else if (action.equalsIgnoreCase("delete")) {
            int id = Integer.parseInt(request.getParameter("id"));
            meals.delete(id);
            response.sendRedirect("meals");
        } else if (action.equalsIgnoreCase("edit")) {
            forward = "meal.jsp";
            int id = Integer.parseInt(request.getParameter("id"));
            Meal meal = meals.get(id);
            request.setAttribute("meal", meal);
            request.getRequestDispatcher(forward).forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        String description = request.getParameter("description");
        int calories = Integer.parseInt(request.getParameter("calories"));
        LocalDate date = LocalDate.parse(request.getParameter("date"));
        int id = Integer.parseInt(request.getParameter("id"));
        Meal meal = new Meal(LocalDateTime.of(date, LocalTime.now()), description, calories, id);
        meals.add(meal);

        request.setAttribute("meals", meals);
        request.getRequestDispatcher("meals.jsp").forward(request, response);
    }

    private List<MealTo> getList(Storage storage) {
        return filteredByCycles(new ArrayList<>(List.of(storage.getAll())), LocalTime.of(0, 0), LocalTime.of(23, 59),
                DEFAULT_CALORIES_PER_DAY);
    }

    private List<Meal> createMeals() {
        List<Meal> meals = new ArrayList<>();
        meals.add(new Meal(LocalDateTime.of(2023, Month.OCTOBER, 26, 10, 55), "Omelet", 150, id.getAndIncrement()));
        meals.add(new Meal(LocalDateTime.of(2023, Month.OCTOBER, 26, 13, 10), "Sandwich", 700, id.getAndIncrement()));
        meals.add(new Meal(LocalDateTime.of(2023, Month.OCTOBER, 27, 20, 12), "Pork", 500, id.getAndIncrement()));
        meals.add(new Meal(LocalDateTime.of(2023, Month.OCTOBER, 27, 18, 30), "French Fries", 300,
                id.getAndIncrement()));
        meals.add(new Meal(LocalDateTime.of(2023, Month.OCTOBER, 26, 10, 0), "Fish", 400, id.getAndIncrement()));
        meals.add(new Meal(LocalDateTime.of(2023, Month.OCTOBER, 26, 13, 0), "Apple", 50, id.getAndIncrement()));
        meals.add(new Meal(LocalDateTime.of(2023, Month.OCTOBER, 27, 20, 0), "Beer", 300, id.getAndIncrement()));
        return meals;
    }
}
