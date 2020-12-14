<%@ page session="true" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Adminside</title>
    <link rel="stylesheet" href="test.css"/>
</head>
<body>
<ul>
    <li><form action="${pageContext.request.contextPath}/LoggUt" method="post">
        <input type="submit" value="Logg ut" /></form>
    <li><a href="addKlubb.jsp">Legg til klubb</a></li>
    <li><a href="AddTestgruppe.jsp">Legg til testklasse</a></li>
    <li><a href="Test�r.jsp">Legg til test�r og -uke</a></li>
    <li><a href="Klubboversikt.jsp">Klubboversikt</a></li>
    <li><a href="RegistrerNyBruker.jsp">Registrer ny systembruker</a></li>
    <li><a href="testaddbruker.jsp">Midl.pubReg</a></li>
    <li><a href="testpub.jsp">Midl.publisering</a></li>
    <li style="float:left"><button class="button" onclick="goBack()">G� tilbake</button>
        <script>
            function goBack() {
                window.history.back();
            }
        </script></li>
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
    <h1> Velkommen til adminsiden <b> (${Bruker})</b>, du er n� logget inn!</h1>
    <!-- knapp med henvisning til servletten "LoggUt" som avslutter den innloggede brukerens sesjon. -->
</div>
<br>
<!-- Sesjonsinformasjon ved servelet "SessionTest". -->
<form action="${pageContext.request.contextPath}/SesjonsTest" method="post">
    <input type="submit" value="SesjonsTest" />
</form>
</body>
</html>
