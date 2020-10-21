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
    <title>Hjemmeside</title>
    <link rel="stylesheet" href="test.css" />
</head>
<body>
<h1>Velkommen til Roklubben</h1>

<div class="Introduksjon">
<h3>Vennligst logg inn som enten Administrator eller Trener</h3>
</div>

<div class="Innlogging">
<form action="ChangeBruker" method="POST">
    <label for='bn'>Brukernavn:</label>
    <input type='text' name='cb'/>
    <br>
    <label for='pd'>Passord:</label>
    <input type='text' name='cp'/>
    <br>
    <button class="button loginAdmin"><a href="Main_pageAdmin.jsp">Logg inn som Admin</a></button>
    <button class="button loginAdmin"><a href="Main_pageTrener.jsp">Logg inn som Trener</a></button>
</form>
</div>

</body>
</html>
