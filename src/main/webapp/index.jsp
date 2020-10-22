<%--
  Created by IntelliJ IDEA.
  User: 99kev
  Date: 12.10.2020
  Time: 14:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="test.css" />
</head>
<body>

<div class="Innlogging">
<form action="ChangeBruker" method="POST">
    <label for='bn'>Brukernavn:</label>
    <input type='text' name='cb'/>
    <br>
    <label for='pd'>Passord:</label>
    <input type='text' name='ci'/>
    <input type='submit' name="action" value="login"/>
</form>

    <button class="button loginSomAdmin"><a href="Main_pageAdmin.jsp">Login Admin</a></button>
    <button class="button loginSomTrener"><a href="Main_pageTrener.jsp">Login Trener</a></button>
</div>
</body>
</html>
