<%--
  Created by IntelliJ IDEA.
  User: ILIA
  Date: 14.02.2019
  Time: 14:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <link type="text/css" rel="stylesheet" media="screen"
          href="${pageContext.request.contextPath}/resources/styles/login.css"/>

    <title>Home page</title>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">

    <script src="https://cdnjs.cloudflare.com/ajax/libs/prefixfree/1.0.7/prefixfree.min.js"></script>

</head>
<%@include file="header1.jsp"%>
<body>
<div class="login">
    <h1>Home</h1>

    <form method="post" action="${pageContext.request.contextPath}/servlet/logout" class="form">
        <button type="submit">Logout</button>
        <a href="${pageContext.request.contextPath}/servlet/login">
            <form method="GET"
                  action="${pageContext.request.contextPath}/servlet/login">
                <input type="submit" value=" Login ">
            </form>
        </a>
        <button type="submit" class="btn btn-primary btn-block btn-large">Registration</button>
    </form>
</div>

<script  src="js/index.js"></script>
</body>
</html>
