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
</head>
<body>


<form action="ChangeKlubb" method="POST">
    <label for='ck'>endre klubbnavn:</label>
    <input type='text' name='ck'/>
    <br>
    <label for='ki'>brukerid:</label>
    <input type='text' name='ki'/>
    <input type='submit' name="action" value="changeklubb"/>
</form>



</body>
</html>
