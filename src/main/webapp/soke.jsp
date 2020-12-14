<%@ page import="java.sql.*" %>
<%@ page import="tools.DbTool" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href='test.css' type='text/css' rel='stylesheet'>
    <title>Filtrert søk</title>
</head>
<body>

<div class="Innlogging_S">
    <form action="soooook" method="POST">

        <label for="kl">Klubber:</label>
        <select id="kl  " name="kl">
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
        <br>
        <br>

        <label for="tge">Testgrupper:</label>
        <select id="tge  " name="tge">
            <option value=""> Velg testgruppe </option>
            <%
                PrintWriter o = new PrintWriter(out);
                Connection dbb = null;
                PreparedStatement droptg = null;
                try {
                    dbb = DbTool.getINSTANCE().dbLoggIn(o);
                    ResultSet rs = null;
                    String query = "SELECT * FROM testgruppe";
                    droptg = dbb.prepareStatement(query);
                    rs = droptg.executeQuery();
                    while (rs.next())
                    {
            %>
            <option value="<%=rs.getInt("testgruppe_id") %>"><%=rs.getString("TestGruppeNavn")%>
            </option>
            <%
                    }
                } catch (SQLException e ) {
                    e.printStackTrace();
                }
            %>
        </select>
        <br>
        <br>
        <label for="ts">Testår:</label>
        <select id="ts  " name="ts">
            <option value=""> Velg testår </option>
            <%
                PrintWriter d = new PrintWriter(out);
                Connection dba = null;
                PreparedStatement dropDownar = null;
                try {
                    dba = DbTool.getINSTANCE().dbLoggIn(d);
                    ResultSet rs = null;
                    String query = "SELECT * FROM testyear";
                    dropDownar = dba.prepareStatement(query);
                    rs = dropDownar.executeQuery();
                    while (rs.next())
                    {
            %>
            <option value="<%=rs.getInt("test_year_id") %>"><%=rs.getString("Ar")%>
            </option>
            <%
                    }
                } catch (SQLException e ) {
                    e.printStackTrace();
                }
            %>
        </select>
        <br>
        <br>
        <input type='submit' name="action" value="sok"/>
    </form>
</div>

</body>
</html>
