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
        <div class="habit-container">
                    <c:forEach var="habit" items="${habits}">
            <div class="habit-box">
                <h2>${habit.name}</h2>
                <p><strong>Started:</strong> ${habit.startDate}</p>
                <p><strong>Total Days:</strong> ${habit.nDays}</p>
                <p><strong>Streak:</strong> ${habit.streak}</p>
            </div>
        </c:forEach>
        </div>
    </div>
    

    
    <script>
        document.addEventListener("DOMContentLoaded", function () {
            document.querySelectorAll('.habit-box').forEach(box => {
                let width = Math.random() * (300 - 100) + 100; // Random width (100px to 300px)
                let height = Math.random() * (250 - 100) + 100; // Random height (100px to 250px)

                box.style.width = `${width}px`;
                box.style.height = `${height}px`;
            });

            document.querySelectorAll('.habit-id, .habit-name').forEach(element => {
                element.style.fontSize = "20px";  // Increase font size
                element.style.fontWeight = "bold"; // Make it bold
            });
            document.querySelectorAll('.habit-box').forEach(box => {
                let randomWidth = Math.floor(Math.random() * 150) + 150; // 150px - 300px
                let randomHeight = Math.floor(Math.random() * 50) + 100; // 100px - 150px
                box.style.width = `${randomWidth}px`;
                box.style.height = `${randomHeight}px`;
            });
        });
    </script>
    
</body>
</html>
