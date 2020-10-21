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

<div>
    <form action="ChangeBruker" method="POST">
        <label for='cb'>endre fornavn:</label>
        <input type='text' name='cb'/>
        <br>
        <label for='ci'>brukerid:</label>
        <input type='text' name='ci'/>
        <input type='submit' name="action" value="change"/>
    </form>
</div>


</body>
</html>
