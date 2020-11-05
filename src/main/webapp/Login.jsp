<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding='UTF-8' %>
<!DOCTYPE html PUBLIC '-//W3C//DTD HTML 4.01 Transitional//EN' 'http://www.w3.org/TR/html4/loose.dtd'>
<html>
<head>
    <meta http-equiv='Content-Type' content='text/html; charset=ISO-8859-1'>
    <title>Login</title>
    <link href='test.css' type='text/css' rel='stylesheet'>
</head>
<body>
<div class="Introduksjon">
    <h1>Vennligst logg inn</h1>
</div>
<div class="Innlogging">
    <form action='Login' method='post'>
        <input type='text' name='vcbrukernavn' placeholder='E-mail'>
        <input type='password' name='vcpassord' placeholder='Passord'>
        <!--   <button class='button buttonHent'> <a href='AdminSide.jsp'> Login</a></button> /> -->
        <br>
        <input type='submit' value="Logg inn" class="btn">
    </form>
</div>
<div class="informasjonsBar">
    Kontakt oss på Tlf: 990 99 999 eller E-post: roklubben@support.no
</div>
</body>
</html>
