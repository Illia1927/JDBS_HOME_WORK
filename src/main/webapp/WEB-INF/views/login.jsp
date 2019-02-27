<%--
  Created by IntelliJ IDEA.
  User: ILIA
  Date: 14.02.2019
  Time: 15:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <link type="text/css" rel="stylesheet" media="screen"
          href="${pageContext.request.contextPath}/resources/styles/login.css"/>

    <title>Login Form</title>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">

    <script src="https://cdnjs.cloudflare.com/ajax/libs/prefixfree/1.0.7/prefixfree.min.js"></script>

</head>
<%@include file="header1.jsp" %>
<body>

<div class="login">
    <h1>Login</h1>
    <form method="POST"
          action="${pageContext.request.contextPath}/servlet/login">
        <span class="fontawesome-user"></span>
        <input name="login" type="text" class="form-control" placeholder="login"/>
        <span class="fontawesome-lock"></span>
        <input name="password" type="password" class="form-control" placeholder="password"/>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="submit" value="let me in">
    </form>
    <a href="${pageContext.request.contextPath}/servlet/registration">
        <form method="GET"
              action="${pageContext.request.contextPath}/servlet/registration">
            <input type="submit" value=" Go to registration ">
        </form>
    </a>

</div>

<script src="js/index.js"></script>
</body>

</html>
