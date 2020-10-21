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
        <form action='AddTestgruppe' method='POST'>
            <label for='tgn'>Testgruppenavn:</label>
            <input type='text' name='tgn'/>
            <label for='tri'>Test_reg_id:</label>
            <input type='text' name='tri'/>
            <label for='tgi'>Testgruppe_id:</label>
            <input type='text' name='tgi'/>
            <label for='ui'>Utover_id:</label>
            <input type='text' name='ui'/>
            <input type='submit' name="action" value="leggTilTestgruppe"/>
        </form>
    </div>
</body>
</html>
