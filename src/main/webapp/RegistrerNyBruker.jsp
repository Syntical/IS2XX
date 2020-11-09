<%@ page session="true" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Hjemmeside</title>
    <link rel="stylesheet" href="test.css"/>
</head>
<body>
<ul>
    <li><form action="${pageContext.request.contextPath}/LoggUt" method="post">
        <input type="submit" value="Logg ut" /></form></li>
    <li><a href="RegistrerAdmin.jsp">Legg til ny Superbruker</a></li>
    <li><a href="RegistrerTrener.jsp">Legg til ny Trener</a></li>
    <li><a href="AdminSide.jsp">Forside</a></li>

</ul>
<%
    //allow access only if session exists
    String Bruker = null;
    if(session.getAttribute("Bruker") == null){
        response.sendRedirect("Login.jsp");
    }else Bruker = (String) session.getAttribute("Bruker");
    String bruker = null;
    String sessionID = null;
    Cookie[] cookies = request.getCookies();
    if(cookies !=null){
        for(Cookie cookie : cookies){
            if(cookie.getName().equals("Bruker")) bruker = cookie.getValue();
            if(cookie.getName().equals("JSESSIONID")) sessionID = cookie.getValue();
        }
    }
%>
<br>
<br>
<br>
<div class="Introduksjon">
    <h3>Hei <%=bruker %>, din sesjonsid er <%=sessionID %></h3>
</div>
<br>
User=<%=Bruker %>
<br>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AdminSide</title>
<div class="Introduksjon">
    <h1> Hei ${Bruker} Her velger du hvilken type bruker du ønsker å registrere. Benytt valgene nedenfor for å legge inn brukere av ulik type <b> </h1>

</div>
<br>

</body>
</html>