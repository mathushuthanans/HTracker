<%@ page language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="navbar">
    <a href="<%= request.getContextPath() %>/">Today</a>
    <a href="<%= request.getContextPath() %>/add">Add Habit</a>
    <a href="<%= request.getContextPath() %>/display">View Habits</a>
</div>

<style>
    .navbar {
        background: #333;
        padding: 10px;
        text-align: center;
    }
    .navbar a {
        color: white;
        text-decoration: none;
        margin: 0 15px;
        font-size: 18px;
    }
    .navbar a:hover {
        text-decoration: underline;
    }
</style>
