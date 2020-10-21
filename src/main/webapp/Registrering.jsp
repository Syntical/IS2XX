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
</head>
<body>


<form action="RegistrerBruker" method="POST">

    <table style="with: 50%">

        <tr>
            <td>Brukernavn</td>
            <td><input type="text" name="bn" /></td>
        </tr>
        <tr>
            <td>Passord</td>
            <td><input type="text" name="pd" /></td>

          </tr> </table>
    <input type='submit' name="action" value="Registrer"/>

</form>

</body>
</html>
