<%@ page language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/static/style.css">
    </head>
    <body>
        <%@ include file="header.jsp" %>
        <h2>Today's task</h2>

        <form action="/" method="post">
            <div class="habit-list">
                <c:forEach var="habit" items="${habits}">
                    <div class="habit-card">
                        <input type="checkbox" id="habit-${habit.id}" name="selectedHabits" value="<c:out value='${habit.id}'/>">
                        <label for="habit-${habit.id}">
                            <strong><c:out value="${habit.name}"/></strong>
                        </label>
                    </div>
                </c:forEach>
            </div>
            <button type="submit">Submit</button>
        </form>
    </body>
</html>
