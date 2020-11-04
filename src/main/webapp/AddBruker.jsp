<%--
  Created by IntelliJ IDEA.
  User: dalaria
  Date: 01.10.2020
  Time: 19:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*" %>
<%@ page import="tools.DbTool" %>
<%@ page import="java.io.PrintWriter" %>
<html>
<head>
    <title>Legg til utoever</title>
</head>
<body>
<h1>Add someone to the database :-)</h1>
<form action='AddBruker' method='POST'>
    <label for='fn'>Fornavn:</label>
    <input type='text' name='fn'/>
    <br>
    <label for='en'> Etternavn:</label>
    <input type='text' name='en'/>
    <br>
    <label for='fd'> Fødselsdato:</label>
    <input type='text' name='fd'/>
    <br>
    <label for='hd'> Høyde:</label>
    <input type='text' name='hd'/>
    <br>
    <label for='vk'> Vekt:</label>
    <input type='text' name='vk'/>
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


    <label for="year">år:</label>
    <select id="year" name="year">
        <option value=""> Velg år </option>
        <%
            PrintWriter p = new PrintWriter(out);
            Connection db = null;
            PreparedStatement dropDown = null;
            try {
                db = DbTool.getINSTANCE().dbLoggIn(p);
                ResultSet rs = null;
                String query = "SELECT * FROM testyear";
                dropDown = db.prepareStatement(query);
                rs = dropDown.executeQuery();
                while (rs.next())
                {
        %>
        <option value="<%=rs.getInt("test_year_id") %>"><%=rs.getString("Year")%>
        </option>
        <%
                }
            } catch (SQLException e ) {
                e.printStackTrace();
            }
        %>
    </select>
    <br>
    <label for="klubb">klubb:</label>
    <select id="klubb" name="klubb">
        <option value=""> Velg klubb </option>
        <%
            PrintWriter o = new PrintWriter(out);
            Connection dbb = null;
            PreparedStatement klubb = null;
            try {
                dbb = DbTool.getINSTANCE().dbLoggIn(o);
                ResultSet rs = null;
                String query = "SELECT * FROM klubb";
                klubb = dbb.prepareStatement(query);
                rs = klubb.executeQuery();
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
    <label for="test">Testgruppe:</label>
    <select id="test" name="test">
        <option value=""> Velg testgruppe </option>
        <%
            PrintWriter l = new PrintWriter(out);
            Connection ddb = null;
            PreparedStatement gruppe = null;
            try {
                ddb = DbTool.getINSTANCE().dbLoggIn(l);
                ResultSet rs = null;
                String query = "SELECT * FROM Testgruppe";
                gruppe = ddb.prepareStatement(query);
                rs = gruppe.executeQuery();
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
    <input type='submit' name="action" value="add"/>
    </form>
<form>
<p>Trykk her for å slette en bruker
    <a href="RemoveBruker.jsp">Slett Bruker</a></p>
<p>Trykk her for å endre en bruker
    <a href="ChangeBruker.jsp">endre bruker</a></p>
</form>
<form action="AddBruker" method="POST">
    <input type="submit" name="action" value="hent">
</form>


</body>
</html>
