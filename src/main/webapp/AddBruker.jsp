<%--
  Created by IntelliJ IDEA.
  User: dalaria
  Date: 01.10.2020
  Time: 19:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Legg til utoever</title>
</head>
<body>
<h1>Add someone to the database :-)</h1>
<form action='AddBruker' method='POST'>
    <label for='fn'>Fornavn:</label>
    <input type='text' name='fn' placeholder='Fornavn'/>
    <br>
    <label for='en'> Etternavn:</label>
    <input type='text' name='en' placeholder='Etternavn'/>
    <br>
    <label for='fd'> Fødselsår: </label>
    <input type='text' name='fd' placeholder='YYYY'/>
    <br>
    <label for='hd'> Høyde:</label>
    <input type='text' name='hd' placeholder='høyde i cm'/>
    <br>
    <label for='vk'> Vekt:</label>
    <input type='text' name='vk' placeholder='antall kg'/>
    <br>
    <input type='submit' name="action" value="add"/>
    </form>

<p>Trykk her for å slette en bruker
    <a href="RemoveBruker.jsp">Slett Bruker</a></p>
<p>Trykk her for å endre en bruker
    <a href="ChangeBruker.jsp">endre bruker</a></p>

<form action="AddBruker" method="POST">
    <input type="submit" name="action" value="hent">
</form>


</body>
</html>
