<%--
  Created by IntelliJ IDEA.
  User: 99kev
  Date: 12.10.2020
  Time: 14:03
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Login</title>
    <link href="test.css" type="text/css" rel="stylesheet">
</head>
<body>
<form action="Controller" method="post">
    <table style="with: 100%">

        <tr>
            <th align="right"> Brukernavn: </th>
            <td><input type="text" name="vcbrukernavn" placeholder="Brukernavn"></td>
        </tr>
        <tr>
            <th align="right"> Passord: </th>
            <td colspan="2" align="right">
                <input type="passord" name="vcpassord" placeholder="Passord" >
            </td>

        </tr>
    </table>
 <!--   <button class="button buttonHent"> <a href="AdminSide.jsp"> Login</a></button> /> -->
<br> <input type="submit" value="Logg inn" class="btn" >
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