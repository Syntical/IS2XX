<%--
  Created by IntelliJ IDEA.
  User: mrbee
  Date: 19.10.2020
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AddTestgruppe</title>
    <link rel="stylesheet" href="test.css" />
</head>
<body>
    <div class="AddTG">
        <form action='addtestgruppe' method='POST'>
            <label for='tgn'>Testgruppenavn:</label>

            <input type='text' name='tgn'/>
            <input type='submit' name="action" value="leggTilTestgruppe"/>
        </form>
    </div>
</body>
</html>
