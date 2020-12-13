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
<%@ page import="java.sql.ResultSet" %>
<html>
<head>
    <title>Legg til utøver</title>
    <link rel="stylesheet" href="test.css"/>
</head>
<body>
<ul>
    <li><form action="${pageContext.request.contextPath}/LoggUt" method="post">
        <input type="submit" value="Logg ut" /></form></li>
    <li><form action="${pageContext.request.contextPath}/VisUtoevereiKlubb" method="post">
        <input type="submit" value="Vis utøvere i klubben" />
    </form>
    </li>
    <li><a href="AddBruker.jsp">Legg til utøver</a></li>
    <li><a href="Velgtestgruppe.jsp">Testklasser </a></li>
    <li style="float:left"><button class="button" onclick="goBack()">Gå tilbake</button>
        <script>
            function goBack() {
                window.history.back();
            }
        </script></li>
</ul>
<%--
<%
    //allow access only if session exists
    String Bruker = null;
    if(session.getAttribute("Bruker") == null){
        response.sendRedirect("Login.jsp");
    }else Bruker = (String) session.getAttribute("Bruker");
    String bruker = null;
    String sessionID = null;
    Cookie[] cookies = request.getCookies();
    if(cookies !=null){
        for(Cookie cookie : cookies){
            if(cookie.getName().equals("Bruker")) bruker = cookie.getValue();
            if(cookie.getName().equals("JSESSIONID")) sessionID = cookie.getValue();
        }
    }
%>
--%>
<br>
<br>
<br>
<br>
<br>
<div class="LeggtilMedlem">
<form action='AddBruker' method='POST'>

    <h1>Legg til en ny utøver og resultat</h1>

    <label for="year">Testår og uke:</label>
    <select id="year" name="year">
        <option value=""> Velg testperiode </option>
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
    <br>
    <label for="test">Testklasse:</label>
    <select id="test" name="test">
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
    <label for='lr'> Ligg ro:</label>
    <input type='text' name='lr'/>
    <br>
    <label for='lrp'> Ligg ro prosent:</label>
    <input type='text' name='lrp'/>
    <br>
    <label for='lrk'> Ligg ro kilo:</label>
    <input type='text' name='lrk'/>
    <br>
    <label for='kbp'> Knebøy prosent:</label>
    <input type='text' name='kbp'/>
    <br>
    <label for='kbk'> Knebøy kilo:</label>
    <input type='text' name='kbk'/>
    <br>
    <label for='totsc'> Totalscore:</label>
    <input type='text' name='totsc'/>
    <br>

    <br>
    <br>
    <input type='submit' name="action" value="Legg til ny utøver og resultat"/>
    </form>
</div>

<div class="informasjonsBar">
    Kontakt oss på Tlf: 990 99 999 eller E-post: roklubben@support.no
</div>
</body>
</html>
