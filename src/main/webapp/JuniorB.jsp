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
    <input type='hidden' name='ftw'/>
    <input type='hidden' name='ftt'/>
    <label for='tts'> 3000 sek:</label>
    <input type='text' name='tts'/>
    <br>
    <label for='ttt'> 3000 tid:</label>
    <input type='text' name='ttt'/>
    <br>
    <input type='hidden' name='tlt'/>
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

    <input type='hidden' name='lr'/>
    <br>

    <input type='hidden' name='lrp'/>
    <br>

    <input type='hidden' name='lrk'/>
    <br>

    <input type='hidden' name='kbp'/>
    <br>

    <input type='hidden' name='kbk'/>
    <br>

    <input type='hidden' name='totsc'/>
    <br>
    <input type='submit' name="action" value="add"/>
</form>



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
                PrintWriter pc = new PrintWriter(out);
                Connection dbc = null;
                PreparedStatement dropDownc = null;
                try {
                    dbc = DbTool.getINSTANCE().dbLoggIn(pc);
                    ResultSet rs = null;
                    String query = "SELECT * FROM ArogUKE";
                    dropDownc = dbc.prepareStatement(query);
                    rs = dropDownc.executeQuery();
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


        <input type='hidden' name='fw' />
        <br>

        <input type='hidden' name='ft'/>
        <br>
        <label for='ts'> 3000 sek:</label>
        <input type='text' name='ts'/>
        <br>
        <label for='tt'> 3000 tid:</label>
        <input type='text' name='tt'/>
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
        <label for='ks'> Kroppshev stk:</label>
        <input type='text' name='ks'/>
        <br>
        <label for='ss'> Sargeant stk:</label>
        <input type='text' name='ss'/>
        <br>
        <label for='bss'>Bevegelse stk:</label>
        <input type='text' name='bss'/>
        <br>

        <input type='hidden' name='lrr'/>
        <br>

        <input type='hidden' name='lp'/>
        <br>

        <input type='hidden' name='lr'/>
        <br>

        <input type='hidden' name='kb'/>
        <br>

        <input type='hidden' name='kk'/>
        <br>

        <input type='hidden' name='totc'/>
        <br>
        <input type='submit' name="action" value="legg til resultat"/>
    </form>


</body>
</html>