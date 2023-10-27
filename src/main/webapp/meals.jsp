<%--
  User: Danylo Sashchuk
  Date: 10/26/23
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.calorietracker.app.util.TimeUtil" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>meals</title>
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
<table>
    <tr>
        <th>Description</th>
        <th>Calories</th>
    </tr>
    <c:forEach items="${meals}" var="meal">
        <tr class="${meal.excess ? 'red-row' : 'green-row'}">
            <td><c:set var="time" value="${TimeUtil.formattedDateTime(meal.dateTime)}"/> ${time}</td>
            <td>${meal.description}</td>
            <td>${meal.calories}</td>
            <td><a href="meals?action=edit&id=<c:out value="${meal.id}"/>">Update</a></td>
            <td><a href="meals?action=delete&id=<c:out value="${meal.id}"/>">Delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
