<%--
  Created by IntelliJ IDEA.
  User: ILIA
  Date: 19.02.2019
  Time: 20:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/servlet/registration">
    registration
</a>

<a href="${pageContext.request.contextPath}/servlet/admin">
    admin
</a>

<a href="${pageContext.request.contextPath}/servlet/header2">
    header2
</a>

<a href="${pageContext.request.contextPath}/servlet/403">
    403
</a>

<a href="${pageContext.request.contextPath}/servlet/404">
    404
</a>

<a href="${pageContext.request.contextPath}/servlet/home">
    <input type="submit" value=" home ">
</a>

<a href="${pageContext.request.contextPath}/servlet/login">
    <input type="submit" value=" login ">
</a>

</body>
</html>
