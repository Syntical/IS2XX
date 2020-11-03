<%@ page import="java.sql.*" %>
<%@ page import="tools.DbTool" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<form action="Visklubb" method="POST">

    <input type='submit' name="action" value="HentKlubb"/>


    <label for="klubb">Klubber:</label>
    <select id="klubb  " name="klubb">
        <option value=""> Velg klubb </option>
        <%
            PrintWriter p = new PrintWriter(out);
            Connection db = null;
            PreparedStatement dropDown = null;
            try {
                db = DbTool.getINSTANCE().dbLoggIn(p);
                ResultSet rs = null;
                String query = "SELECT * FROM klubb";
                dropDown = db.prepareStatement(query);
                rs = dropDown.executeQuery();
                while (rs.next())
                {
        %>
        <option value="<%=rs.getInt("klubb_id") %>"><%=rs.getString("klubbnavn")%>
        </option>
        <%
                }
            } catch (SQLException e ) {
                e.printStackTrace();
            }
        %>
    </select>
</form>



</body>
</html>
