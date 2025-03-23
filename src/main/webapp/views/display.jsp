<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
    <title>Habit Tracker</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>

    <%@ include file="header.jsp" %>

    <div class="habit-tracker-container">
        <h1 class="habit-tracker-title">HABIT TRACKER</h1>

        <table class="habit-table">
            <thead>
                <tr>
                    <th>Habit Name</th>
                    <th>Start Date</th>
                    <th>Total Days</th>
                    <th>Streak</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="habit" items="${habits}">
                    <tr>
                        <td>${habit.name}</td>
                        <td>${habit.startDate}</td>
                        <td>${habit.nDays}</td>
                        <td>${habit.streak}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

</body>
</html>
