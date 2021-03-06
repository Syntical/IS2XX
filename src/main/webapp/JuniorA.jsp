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
    <li><form action="${pageContext.request.contextPath}/VisUtoevereiKlubb" method="post">
        <input type="submit" value="Vis utøvere i klubben" />
    </form></li>
    <li><a href="AddBruker.jsp">Legg til utøver</a></li>
    <li><a href="Velgtestgruppe.jsp">Testklasser </a></li>
    <li><a href="TrenerSide.jsp">Forside</a></li>
    <li style="float:left"><button class="button" onclick="goBack()">Gå tilbake</button>
        <script>
            function goBack() {
                window.history.back();
            }
        </script></li>
</ul>
<br>
<br>
<br>

<div class="LeggtilMedlem">
    <h1>Legg til ny utøver med resultater</h1>
    <h2>for Junior A</h2>
    <h3>Informasjon i alle felter er påkrevd</h3>
    <form action='AddBruker' method='POST'>
        <br>
        <br>

        <label for="year">Testår og uke:</label>
        <select id="year" name="year" required>
            <option value=""> Velg periode </option>
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
        <label for="klubb">Klubb:</label>
        <select id="klubb" name="klubb" required>
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
        <br>
        <label for="test">Testklasse:</label>
        <select id="test" name="test" required>
            <option value=""> Velg testklasse </option>
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
        <input type='text' name='fn' required/>
        <br>
        <label for='en'> Etternavn:</label>
        <input type='text' name='en' required/>
        <br>
        <label for='fd'> Fødselsår:</label>
        <input type='text' name='fd' placeholder="ÅÅÅÅ" minlength="4" maxlength="4" required/>
        <br>
        <label for='hd'> Høyde:</label>
        <input type='text' name='hd' maxlength="3" required/>
        <br>
        <label for='vk'> Vekt:</label>
        <input type='text' name='vk' maxlength="3" required/>
              <br>
            <label for='ftw'>5000 watt:</label>
            <input type='text' name='ftw' required/>
            <br>
            <label for='ftt'> 5000 tid:</label>
            <input type='text' name='ftt' required/>
            <input type='hidden' name='tts'/>
            <input type='hidden' name='ttt'/>
            <input type='hidden' name='tlt'/>
            <br>
            <label for='ttw'>2000 watt:</label>
            <input type='text' name='ttw' required/>
            <br>
            <label for='tott'> 2000 tid:</label>
            <input type='text' name='tott' required/>
            <br>
            <label for='sw'> 60 watt:</label>
            <input type='text' name='sw' required/>
            <input type='hidden' name='khs'/>
            <label for='sgs'> Sargeant stk:</label>
            <input type='text' name='sgs' required/>
            <br>
            <label for='bs'>Bevegelse stk:</label>
            <input type='text' name='bs' required/>
            <input type='hidden' name='lr'/>
            <br>
            <label for='lrp'> ligg ro prosent:</label>
            <input type='text' name='lrp' required/>
            <br>
            <label for='lrk'> ligg ro kilo:</label>
            <input type='text' name='lrk' required/>
            <input type='hidden' name='kbp'/>
            <input type='hidden' name='kbk'/>

            <input type='hidden' name='totsc'/>


            <input type='submit' name="action" value="Legg til ny utover og resultat"/>

    </form>

</div>


<br>
<br>
<div class ="LeggtilMedlem">
    <h1>Legg til testresultat for eksisterende utøver</h1>
    <h3>Informasjon i alle felter er påkrevd</h3>
    <br>
    <br>
    <form action='Eksresult' method='POST'>
        <label for="utover">Utøver:</label>
        <select id="utover" name="utover" required>
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
        <br>
        <br>
        <label for="ars">Testår og uke:</label>
        <select id="ars" name="ars" required>
            <option value=""> Velg testperiode </option>
            <%
                PrintWriter pp = new PrintWriter(out);
                Connection dbl = null;
                PreparedStatement dropDownz = null;
                try {
                    dbl = DbTool.getINSTANCE().dbLoggIn(pp);
                    ResultSet rs = null;
                    String query = "SELECT * FROM Roprosjekt.ArogUKE";
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
        <br>
        <label for='ftw'>5000 watt:</label>
        <input type='text' name='ftw' required/>
        <br>
        <label for='ftt'> 5000 tid:</label>
        <input type='text' name='ftt' required/>
        <input type='hidden' name='tts'/>
        <input type='hidden' name='ttt'/>
        <input type='hidden' name='tlt'/>
        <br>
        <label for='ttw'>2000 watt:</label>
        <input type='text' name='ttw' required/>
        <br>
        <label for='tott'> 2000 tid:</label>
        <input type='text' name='tott' required/>
        <br>
        <label for='sw'> 60 watt:</label>
        <input type='text' name='sw' required/>
        <input type='hidden' name='khs'/>
        <br>
        <label for='sgs'> Sargeant stk:</label>
        <input type='text' name='sgs' required/>
        <br>
        <label for='bs'>Bevegelse stk:</label>
        <input type='text' name='bs' required/>
        <input type='hidden' name='lr'/>
        <br>
        <label for='lrp'> Ligg ro prosent:</label>
        <input type='text' name='lrp' required/>
        <br>
        <label for='lrk'> Ligg ro kilo:</label>
        <input type='text' name='lrk' required/>
        <br>
        <input type='hidden' name='kbp'/>
        <input type='hidden' name='kbk'/>
        <input type='hidden' name='totsc'/>

        <input type='submit' name="action" value="Legg til resultat"/>
        
    </form>
</div>


</body>
</html>
