
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*" %>
<%@ page import="tools.DbTool" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<form action="AddArogUke" method="POST">
    <label for='ar'>testår</label>
    <input type='text' name='ar'/>
    <br>
    <label for='uke'>Testuke:</label>
    <input type='text' name='uke'/>
    <input type='submit' name="action" value="Leggt"/>



</form>



</body>
</html>
