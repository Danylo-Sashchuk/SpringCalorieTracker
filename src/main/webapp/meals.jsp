<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://app.calorietracker.com/functions" %>
<%--<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>--%>
<html>
<head>
    <title>Meal list</title>
    <style>
        .red-row {
            background-color: #8c3b3b;
        }

        .green-row {
            background-color: #81e581;
        }
    </style>
</head>
<body>
<section>
    <h3><a href="index.html">Home</a></h3>
    <hr/>
    <h2>Meals</h2>
    <table>
        <thead>
        <tr>
            <th>Date</th>
            <th>Description</th>
            <th>Calories</th>
        </tr>
        </thead>
        <c:forEach items="${meals}" var="meal">
            <jsp:useBean id="meal" type="com.calorietracker.app.model.MealTo"/>
            <tr class="${meal.excess ? 'red-row' : 'green-row'}">
                <td>${fn:formatDateTime(meal.dateTime)}</td>
                <td>${meal.description}</td>
                <td>${meal.calories}</td>
                    <%--                <td><a href="meals?action=edit&id=<c:out value="${meal.id}"/>">Update</a></td>--%>
                    <%--                <td><a href="meals?action=delete&id=<c:out value="${meal.id}"/>">Delete</a></td>--%>
            </tr>
        </c:forEach>
    </table>
<%--    <p><a href="meals?action=insert">Add Meal</a></p>--%>
</section>
</body>
</html>