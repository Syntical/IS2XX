<%--
  Created by IntelliJ IDEA.
  User: 99kev
  Date: 05.10.2020
  Time: 19:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="test.css" />
</head>
<body>

<div class="RemBruker">
<form action="RemoveBruker" method="POST">

    <label for='rm'>fjern:</label>
    <input type='text' name='rm'/>
    <br>
    <input type='submit' name="action" value="remove"/>
</form>
</div>
</body>
</html>
