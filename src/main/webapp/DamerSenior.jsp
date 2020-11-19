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
<form action='AddBruker' method='POST'>

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

        <label for='fw'>5000 watt:</label>
        <input type='text' name='fw' />
        <br>
        <label for='ft'> 5000 tid:</label>
        <input type='text' name='ft'/>
        <br>
        <input type='hidden' name='ts'/>
        <input type='hidden' name='tt'/>
        <br>
        <input type='hidden' name='tl'/>
        <br>
        <label for='tw'>2000 watt:</label>
        <input type='text' name='tw' />
        <br>
        <label for='tot'> 2000 tid:</label>
        <input type='text' name='tot'/>
        <br>
        <label for='sww'> 60 watt:</label>
        <input type='text' name='sww'/>
        <br>
        <input type='hidden' name='ks'/>
        <input type='hidden' name='ss'/>
        <br>
        <label for='bss'>Bevegelse stk:</label>
        <input type='text' name='bss'/>
        <br>
        <input type='hidden' name='lrr'/>
        <br>
        <label for='lp'> ligg ro prosent:</label>
        <input type='text' name='lp'/>
        <br>
        <label for='lr'> ligg ro kilo:</label>
        <input type='text' name='lr'/>
        <br>
        <label for='kb'> Knebøy prosent:</label>
        <input type='text' name='kb'/>
        <br>
        <label for='kk'> Knebøy kilo:</label>
        <input type='text' name='kk'/>
        <br>

        <input type='hidden' name='totc'/>
        <br>
    <input type='submit' name="action" value="add"/>
</form>

<form action='Eksresult' method='POST'>
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
    <label for='fw'>5000 watt:</label>
    <input type='text' name='fw' />
    <br>
    <label for='ft'> 5000 tid:</label>
    <input type='text' name='ft'/>
    <br>
    <input type='hidden' name='ts'/>
    <input type='hidden' name='tt'/>
    <br>
    <input type='hidden' name='tl'/>
    <br>
    <label for='tw'>2000 watt:</label>
    <input type='text' name='tw' />
    <br>
    <label for='tot'> 2000 tid:</label>
    <input type='text' name='tot'/>
    <br>
    <label for='sww'> 60 watt:</label>
    <input type='text' name='sww'/>
    <br>

    <input type='hidden' name='ks'/>


    <input type='hidden' name='ss'/>
    <br>
    <label for='bss'>Bevegelse stk:</label>
    <input type='text' name='bss'/>
    <br>
    <input type='hidden' name='lrr'/>
    <br>
    <label for='lp'> ligg ro prosent:</label>
    <input type='text' name='lp'/>
    <br>
    <label for='lr'> ligg ro kilo:</label>
    <input type='text' name='lr'/>
    <br>
    <label for='kb'> Knebøy prosent:</label>
    <input type='text' name='kb'/>
    <br>
    <label for='kk'> Knebøy kilo:</label>
    <input type='text' name='kk'/>
    <br>

    <input type='hidden' name='totc'/>
    <br>
    <input type='submit' name="action" value="legg til resultat"/>
</form>
</body>
</html>