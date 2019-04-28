<%--
  Created by IntelliJ IDEA.
  User: maakaa
  Date: 28.04.19
  Time: 14:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<html>
<head>
    <title>Registration form</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h2>Register</h2>
    <form:form method="post" modelAttribute="user">

        First Name:
        <form:input path="firstName"/><br>
        <form:errors path="firstName" cssClass="error" /><br>

        Last Name:
        <form:input path="lastName"/><br>
        <form:errors path="lastName" cssClass="error" /><br>

        Email:
        <form:input path="email"/><br>
        <form:errors path="email" cssClass="error" /><br>

        Password:
        <form:password path="password"/><br>
        <form:errors path="password" cssClass="error" /><br>

        <input type="submit" value="save"><br>
    </form:form>
</div>
</body>
</html>
