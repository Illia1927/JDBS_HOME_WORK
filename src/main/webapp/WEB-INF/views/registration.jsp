<%--
  Created by IntelliJ IDEA.
  User: ILIA
  Date: 14.02.2019
  Time: 13:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <link type="text/css" rel="stylesheet" media="screen"
          href="${pageContext.request.contextPath}/resources/styles/login.css"/>

    <title>Registration Form</title>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">

    <script src="https://cdnjs.cloudflare.com/ajax/libs/prefixfree/1.0.7/prefixfree.min.js"></script>

</head>

<body>

<div class="login">
    <h1>Registration</h1>
    <form method="post">
        <input type="text" name="u" placeholder="Username" required="required" />

        <input type="text" name="u" placeholder="E-mail" required="required" />

        <input type="text" name="u" placeholder="Name" required="required" />

        <input type="text" name="u" placeholder="Surname" required="required" />

        <input type="password" name="p" placeholder="Password" required="required" />

        <button type="submit" class="btn btn-primary btn-block btn-large">Registration</button>
    </form>

</div>

<script  src="js/index.js"></script>

</body>

</html>

