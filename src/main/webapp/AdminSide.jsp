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
        <input type="submit" value="Logg ut" /></form></li>
    <li><a href="AddBruker.jsp">Legg til medlem</a></li>
    <li><a href="addKlubb.jsp">Legg til klubb</a></li>
    <li><a href="AddTestgruppe.jsp">Legg til testgruppe</a></li>
    <li><a href="Testår.jsp">Legg til testår og -uke</a></li>
    <li><a href="RegistrerNyBruker.jsp">Registrer admin/trener</a></li>
    <li style="float:left"><button class="button" onclick="goBack()">Gå tilbake</button>
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
    <h1> Velkommen til adminsiden <b> (${Bruker})</b>, du er nå logget inn!</h1>
    <!-- knapp med henvisning til servletten "LoggUt" som avslutter den innloggede brukerens sesjon. -->
</div>
<br>
<!-- Sesjonsinformasjon ved servelet "SessionTest". -->
<form action="${pageContext.request.contextPath}/SesjonsTest" method="post">
    <input type="submit" value="SesjonsTest" />
</form>
</body>
</html>
