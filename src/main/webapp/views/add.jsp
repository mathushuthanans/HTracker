<%@ page language="java" %>

<html>
<head>
    <title>Add the Habit</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>

<body>
    <%@ include file="header.jsp" %>  <h2>Add Habit</h2>

    <form action="add" method="post">
        <label for="name">Enter the Habit Name: </label>
        <input type="text" id="name" name="name"><br>

        <label for="startDate">Enter the Start Date: </label><br>
        <input type="date" id="startDate" name="startDate"><br>

        <input type="submit" value="Submit">
    </form>
</body>
</html>