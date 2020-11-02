<%@ page session="true" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <body>

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
<h3>Hi <%=bruker %>, Login successful. Your Session ID=<%=sessionID %></h3>
<br>
User=<%=Bruker %>
<br>


    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>AdminSide</title>
     <div style="text-align: left">
            <h1> Velkommen til adminsiden, du er nå logget inn!</h1>
            <b> (${Bruker})</b>
            <br><br>
<!-- knapp med henvisning til servletten "LoggUt" som avslutter den innloggede brukerens sesjon. -->
    </div>
    <form action="${pageContext.request.contextPath}/LoggUt" method="post">
        <input type="submit" value="Logg ut" />
    </form>
    <br>
    <!-- Sesjonsinformasjon ved servelet "SessionTest". -->
    <form action="${pageContext.request.contextPath}/SesjonsTest" method="post">
        <input type="submit" value="SesjonsTest" />
    </form>
</body>
</head>
</html>
