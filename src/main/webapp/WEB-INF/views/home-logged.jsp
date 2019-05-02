<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
    <title>Home</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
    <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-light bg-light shadow fixed-top">
        <div class="container">
            <a class="navbar-brand" href="#">Twitter</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive"
                    aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarResponsive">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="#">Home
                            <span class="sr-only">(current)</span>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">My Profile</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Logout</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <br>
    <br>
    <br>
    <div class="container">
        <h2>Hi ${user.firstName}!</h2>
        <h2>Post Tweet:</h2>
        <form:form method="post" modelAttribute="userTweet">
            <form:input type="hidden" name="id" path="id"/>
            <form:input type="hidden" name="${user.id}" path="user.id"/>

            Text:<br>
            <form:textarea path="text"/><br>
            <form:errors path="text" cssClass="text-danger"/><br>

            <input type="submit" value="Save"><br>
        </form:form>

        <h2>Your Tweets:</h2>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Text</th>
                <th scope="col">Created</th>
                <th scope="col">User</th>
            </tr>
            </thead>
            <c:forEach items="${tweetsByUser}" var="tweetByUser">
                <tr>
                    <td>${tweetByUser.id}</td>
                    <td>${tweetByUser.text}</td>
                    <td>${tweetByUser.created}</td>
                    <td>${tweetByUser.user.firstName} ${tweetByUser.user.lastName}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
