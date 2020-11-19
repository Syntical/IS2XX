<%--
  Created by IntelliJ IDEA.
  User: 99kev
  Date: 14.11.2020
  Time: 20:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*" %>
<%@ page import="tools.DbTool" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.sql.ResultSet" %>
<html>
<head>
    <form action='Eksresult' method='POST'>

        <br>
        <label for="utover">utøver:</label>
        <select id="utover" name="utover">
            <option value=""> Velg utøver </option>
            <%
                PrintWriter pa = new PrintWriter(out);
                Connection dba = null;
                PreparedStatement dropDowns = null;
                try {
                    dba = DbTool.getINSTANCE().dbLoggIn(pa);
                    ResultSet rs = null;
                    String query = "SELECT * FROM Roprosjekt.fulltnavn";
                    dropDowns = dba.prepareStatement(query);
                    rs = dropDowns.executeQuery();
                    while (rs.next())
                    {
            %>
            <option value="<%=rs.getInt("utover_id") %>"><%=rs.getString("fulltnavn")%>
            </option>
            <%
                    }
                } catch (SQLException e ) {
                    e.printStackTrace();
                }
            %>
        </select>

        <label for="ars">år:</label>
        <select id="ars" name="ars">
            <option value=""> Velg år </option>
            <%
                PrintWriter p = new PrintWriter(out);
                Connection db = null;
                PreparedStatement dropDown = null;
                try {
                    db = DbTool.getINSTANCE().dbLoggIn(p);
                    ResultSet rs = null;
                    String query = "SELECT * FROM ArogUKE";
                    dropDown = db.prepareStatement(query);
                    rs = dropDown.executeQuery();
                    while (rs.next())
                    {
            %>
            <option value="<%=rs.getInt("test_year_id") %>"><%=rs.getString("ArogUKE")%>
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
        <label for='ftw'>5000 watt:</label>
        <input type='text' name='ftw'/>
        <br>
        <label for='ftt'> 5000 tid:</label>
        <input type='text' name='ftt'/>
        <br>
        <label for='tts'> 3000 sek:</label>
        <input type='text' name='tts'/>
        <br>
        <label for='ttt'> 3000 tid:</label>
        <input type='text' name='ttt'/>
        <br>
        <label for='tlt'> 3000 løp tid:</label>
        <input type='text' name='tlt'/>
        <br>
        <label for='ttw'>2000 watt:</label>
        <input type='text' name='ttw'/>
        <br>
        <label for='tott'> 2000 tid:</label>
        <input type='text' name='tott'/>
        <br>
        <label for='sw'> 60 watt:</label>
        <input type='text' name='sw'/>
        <br>
        <label for='khs'> Kroppshev stk:</label>
        <input type='text' name='khs'/>
        <br>
        <label for='sgs'> Sargeant stk:</label>
        <input type='text' name='sgs'/>
        <br>
        <label for='bs'>Bevegelse stk:</label>
        <input type='text' name='bs'/>
        <br>
        <label for='lr'> ligg ro:</label>
        <input type='text' name='lr'/>
        <br>
        <label for='lrp'> ligg ro prosent:</label>
        <input type='text' name='lrp'/>
        <br>
        <label for='lrk'> ligg ro kilo:</label>
        <input type='text' name='lrk'/>
        <br>
        <label for='kbp'> Knebøy prosent:</label>
        <input type='text' name='kbp'/>
        <br>
        <label for='kbk'> Knebøy kilo:</label>
        <input type='text' name='kbk'/>
        <br>
        <label for='totsc'> totalscore:</label>
        <input type='text' name='totsc'/>
        <br>

        <br>
        <br>
        <input type='submit' name="action" value="legg til resultat"/>
    </form>
</head>
<body>

</body>
</html>
