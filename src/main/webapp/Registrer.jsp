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

<div class="BrukerReg">
    <form action="RegistrerBruker" method="POST">
        <label for='bn'>Brukernavn:</label>
        <input type='text' name='bn'/>
        <br>
        <label for='pd'>Passord:</label>
        <input type='text' name='pd'/>
        <input type='submit' name="action" value="Registrer"/>
    </form>
</div>

</body>
</html>
