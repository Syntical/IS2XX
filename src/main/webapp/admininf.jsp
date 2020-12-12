<%--
  Created by IntelliJ IDEA.
  User: 99kev
  Date: 13.11.2020
  Time: 14:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*" %>
<%@ page import="tools.DbTool" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.sql.ResultSet" %>
<html>
<head>
    <title>Her bytter du brukernavn og passord på adminbrukere</title>
</head>
<body>

    <form action='Endrebrukere' method='post'>


        <label for='bkn'> Endre brukernavn</label>
        <input type='text' name='bkn'/>
        <br>

        <label for="em">Velg brukernavnet som skal endres:</label>
        <select id="em" name="em">
            <option value=""> Brukernavn </option>
                <%
            PrintWriter l = new PrintWriter(out);
            Connection ddb = null;
            PreparedStatement gruppe = null;
            try {
                ddb = DbTool.getINSTANCE().dbLoggIn(l);
                ResultSet rs = null;
                String query = "SELECT brukerinfo.brukerinfo_id, brukerinfo.email FROM brukerinfo join bruker using (brukerinfo_id) where rolle_id = 1";
                gruppe = ddb.prepareStatement(query);
                rs = gruppe.executeQuery();
                while (rs.next())
                {
        %>
            <option value="<%=rs.getInt("brukerinfo_id") %>"><%=rs.getString("email")%>
            </option>
                <%
                }
            } catch (SQLException e ) {
                e.printStackTrace();
            }
        %>




            <input type='submit' name="action" value="Endre brukernavn"/>
    </form>


    <form action='Endrebrukere' method='post'>


        <label for='pkn'> Endre passord</label>
        <input type='text' name='pkn'/>
        <br>

        <label for="gg">Velg bruker passordet skal bli endret på:</label>
        <select id="gg" name="gg">
            <option value=""> brukernavn </option>
                <%
            PrintWriter lo = new PrintWriter(out);
            Connection db = null;
            PreparedStatement pass = null;
            try {
                db = DbTool.getINSTANCE().dbLoggIn(lo);
                ResultSet rs = null;
                String query = "SELECT brukerinfo.brukerinfo_id, brukerinfo.email FROM brukerinfo join bruker using (brukerinfo_id) where rolle_id = 1";
                pass = db.prepareStatement(query);
                rs = pass.executeQuery();
                while (rs.next())
                {
        %>
            <option value="<%=rs.getInt("brukerinfo_id") %>"><%=rs.getString("email")%>
            </option>
                <%
                }
            } catch (SQLException e ) {
                e.printStackTrace();
            }
        %>




            <input type='submit' name="action" value="endre passord"/>
    </form>


</body>
</html>
