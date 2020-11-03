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
<img src="https://assets.website-files.com/5b3335ab4ca8551124a2ba8f/5cbf778b0cdebda6ec56b4a6_norges-roforbund-logo-p-500.png" alt="Norges Roforbund" style="width:600px;height:200px;vertical-align:middle;margin:40px 600px">
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
