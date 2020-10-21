<%--
  Created by IntelliJ IDEA.
  User: 99kev
  Date: 12.10.2020
  Time: 14:03
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Guru Login Form</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/Login" method="post">
    <table style="with: 100%">

        <tr>
            <td>UserName</td>
            <td><input type="text" name="brukernavn" /></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type="passord" name="passord" /></td>
        </tr>
    </table>
 <!--   <button class="button buttonHent"> <a href="AdminSide.jsp"> Login</a></button> /> -->
<br> <input type="submit" value="Submit" />
</form>


</body>
</html>

<!--

<html>
<head>
    <title>Title</title>
</head>
<body>


<form action="ChangeBruker" method="POST">
    <label for='bn'>Brukernavn:</label>
    <input type='text' name='cb'/>
    <br>
    <label for='pd'>Passord:</label>
    <input type='text' name='ci'/>
    <input type='submit' name="action" value="login"/>
</form>

</body>
</html>
-->