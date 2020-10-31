
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>AdminSide</title>
     <div style="text-align: left">
            <h1> Velkommen til adminsiden, du er nå logget inn!</h1>
            <b> (${_username})</b>
            <br><br>

    </div>
    <form action="${pageContext.request.contextPath}/LoggUt" method="post">
        <input type="submit" value="Logg ut" />
    </form>
   <!-- <form action="${pageContext.request.contextPath}/LoggUt" method="post">
        <input type="submit" value="Logg ut" />
    </form> -->
</head>
</html>
