<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding='UTF-8' %>
<!DOCTYPE html PUBLIC '-//W3C//DTD HTML 4.01 Transitional//EN' 'http://www.w3.org/TR/html4/loose.dtd'>
<html>
<head>
    <meta http-equiv='Content-Type' content='text/html; charset=ISO-8859-1'>
    <title>Søk</title>
    <link href='test.css' type='text/css' rel='stylesheet'>
</head>
<body>
<ul>
    <li><a href="Login.jsp">Logg inn</a></li>
</ul>
<br>
<br>
<br>
<br>
<div class="Introduksjon">
    <h1>Her kan du søke etter medlemmer</h1>
</div>
<div class="Innlogging">
    <h1>Søk i databasen</h1>
    <form action='ResultsFromDb' method='POST'>
        <label for='ffnavn'></label>
        <input type='text' name='ffnavn' placeholder="Søk med fornavn"/>
        <input type='submit' name='action' value='sok'/>
    </form>
</div>
<div class="informasjonsBar">
    Kontakt oss på Tlf: 990 99 999 eller E-post: roklubben@support.no

</div>
</body>
</html>