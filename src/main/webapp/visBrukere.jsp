<%@ page import="java.sql.*" %>
<%@ page import="tools.DbTool" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>VisBrukere</title>
</head>
<body>


<form action="Visbrukere" method="POST">

    <input type='submit' name="action" value="HentBrukere"/>


    <label for="user">Bruker:</label>
    <select id="user  " name="bruker">
        <option value=""> Velg bruker </option>
        <%
            PrintWriter p = new PrintWriter(out);
            Connection db = null;
            PreparedStatement dropDown = null;
            try {
                db = DbTool.getINSTANCE().dbLoggIn(p);
                ResultSet rs = null;
                String query = "SELECT * FROM Brukerinfo";
                dropDown = db.prepareStatement(query);
                rs = dropDown.executeQuery();
                while (rs.next())
                {
        %>
        <option value="<%=rs.getInt("brukerinfo_id") %>"><%=rs.getString("Email")%>
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
