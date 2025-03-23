<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Today's Tasks</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
    <%@ include file="header.jsp" %>
    <h2>Today's Habits</h2>
    
    <form action="/" method="post">
        <div class="habit-list">
            <c:forEach var="habit" items="${habits}">
                <div class="habit-card">
                    <input type="checkbox" id="habit-${habit.id}" name="selectedHabits" value="${habit.id}">
                    <label for="habit-${habit.id}"><strong>${habit.name}</strong></label>
                </div>
            </c:forEach>
        </div>
        <button type="submit">Mark as Done</button>
    </form>
</body>
</html>