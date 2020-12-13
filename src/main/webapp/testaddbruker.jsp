<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*" %>
<%@ page import="tools.DbTool" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.sql.ResultSet" %>
<html>
<head>
    <title>Legg til utoever</title>
    <link rel="stylesheet" href="test.css"/>

</head>
<body>

<ul>
    <li><form action="${pageContext.request.contextPath}/LoggUt" method="post">
        <input type="submit" value="Logg ut" /></form></li>

</ul>
<form action='insertTestUtover' method='POST'>

    <br>
    <br>
    <br>
    <br>
    <br>
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
    <input type='hidden' name='tts'/>
    <input type='hidden' name='ttt'/>
    <input type='hidden' name='tlt'/>
    <br>
    <label for='ttw'>2000 watt:</label>
    <input type='text' name='ttw'/>
    <br>
    <label for='tott'> 2000 tid:</label>
    <input type='text' name='tott'/>
    <br>
    <label for='sw'> 60 watt:</label>
    <input type='text' name='sw'/>
    <input type='hidden' name='khs'/>
    <br>
    <label for='sgs'> Sargeant stk:</label>
    <input type='text' name='sgs'/>
    <br>
    <label for='bs'>Bevegelse stk:</label>
    <input type='text' name='bs'/>
    <input type='hidden' name='lr'/>
    <br>
    <label for='lrp'> ligg ro prosent:</label>
    <input type='text' name='lrp'/>
    <br>
    <label for='lrk'> ligg ro kilo:</label>
    <input type='text' name='lrk'/>
    <input type='hidden' name='kbp'/>
    <input type='hidden' name='kbk'/>

    <input type='hidden' name='totsc'/>
    <input type='submit' name="action" value="adde"/>
</form>

<form action='insertRes' method='POST'>
    <label for="uutid">utøver:</label>
    <select id="uutid" name="uutid">
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

    <label for="tsstid">år:</label>
    <select id="tsstid" name="tsstid">
        <option value=""> Velg år </option>
        <%
            PrintWriter pp = new PrintWriter(out);
            Connection dbl = null;
            PreparedStatement dropDownz = null;
            try {
                dbl = DbTool.getINSTANCE().dbLoggIn(pp);
                ResultSet rs = null;
                String query = "SELECT * FROM ArogUKE";
                dropDownz = dbl.prepareStatement(query);
                rs = dropDownz.executeQuery();
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
    <label for='ftw'>5000 watt:</label>
    <input type='text' name='ftw'/>
    <br>
    <label for='ftt'> 5000 tid:</label>
    <input type='text' name='ftt'/>
    <input type='hidden' name='tts'/>
    <input type='hidden' name='ttt'/>
    <input type='hidden' name='tlt'/>
    <br>
    <label for='ttw'>2000 watt:</label>
    <input type='text' name='ttw'/>
    <br>
    <label for='tott'> 2000 tid:</label>
    <input type='text' name='tott'/>
    <br>
    <label for='sw'> 60 watt:</label>
    <input type='text' name='sw'/>
    <input type='hidden' name='khs'/>
    <br>
    <label for='sgs'> Sargeant stk:</label>
    <input type='text' name='sgs'/>
    <br>
    <label for='bs'>Bevegelse stk:</label>
    <input type='text' name='bs'/>
    <input type='hidden' name='lr'/>
    <br>
    <label for='lrp'> ligg ro prosent:</label>
    <input type='text' name='lrp'/>
    <br>
    <label for='lrk'> ligg ro kilo:</label>
    <input type='text' name='lrk'/>
    <input type='hidden' name='kbp'/>
    <input type='hidden' name='kbk'/>

    <input type='hidden' name='totsc'/>
    <br>
    <input type='submit' name="action" value="legg til resultat"/>
</form>
</body>
</html>