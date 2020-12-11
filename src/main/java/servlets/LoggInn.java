package servlets;


import tools.DbTool;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class LoggInn extends AbstractAppServlet {


    /**
     * Tar imot http requesten og responderer med å sende brukeren til restrikterte sider hvis bruker finnes i databasen()
     *
     * @param request  objektet sender data til servletet
     * @param response objektet sender data fra servleten.
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            // henter data som klienten taster inn i html-en og lagrer hvert respektive felt som en variabel
            // som brukes senere i funksjonen.
            String _username = request.getParameter("vcbrukernavn");
            String _password = request.getParameter("vcpassord");

            // Kobler til databasen
            Connection db = null;
            PreparedStatement pwm = null;

            try {

                String nesteSide = "/Login.jsp";

                if (_username != null) {

                    db = DbTool.getINSTANCE().dbLoggIn(out);
                    //String Query = "Select * from Roprosjekt.Brukerinfo where Email=? and Passord=?";
                    String Query = "Select * from Roprosjekt.Brukerinfo JOIN Roprosjekt.bruker USING(brukerinfo_id)" +
                            "  where Email=? and Passord=?";


                    pwm = db.prepareStatement(Query);
                    pwm.setString(1, _username);
                    pwm.setString(2, _password);


                    // Kjører sql-query ved navn "pwn" hvis overnenvte krav er tilfredsstilt

                    ResultSet rs = pwm.executeQuery();

                    if (rs.next()) {

                        // Deklarer "rolle_id" som en variabel som senere bruker til å sjekke brukerens rolle i databasen og systemet.
                        String name = rs.getNString("rolle_id");
                        Integer brukerId = rs.getInt("bruker_id");


                        //sjekker om det allerede eksisterer en sesjon/session og lukker den hvis en eksisterer

                        HttpSession oldSession = request.getSession(false);
                        if (oldSession != null) {
                            oldSession.invalidate();
                        }

                        //Setter opp en ny sesjon/ session n
                        HttpSession newSession = request.getSession(true);

                        //Setter sesjonen til å autoavsluttet etter 5 minutter med inaktivitet
                        newSession.setMaxInactiveInterval(15 * 60);

                        // Oppretter en cookie ved navn "bruker" som setter lagrer informasjon om brukeren i sesjonen.
                        Cookie bruker = new Cookie("Bruker", _username);


                        if (!name.equals( "admin")) {
                            String getClub = "Select klubb_id from BrukerKlubb where bruker_id = ?";
                            PreparedStatement statement = db.prepareStatement(getClub);
                            statement.setInt(1,brukerId);
                            ResultSet clubRes = statement.executeQuery();
                            if (clubRes.next()) {
                                Cookie club = new Cookie("Klubb", clubRes.getString("klubb_id"));
                                response.addCookie(club);
                            }
                        }


                        //bruker.setMaxAge(10); // Min * sekunder       Denne linja virker unødvendig, gjør intenting så lenge  newSession.setMaxInactiveInterval(15 *60); eksisterer.
                        response.addCookie(bruker);

                        // Sjekker om rolle_id-en er Admin eller Trener, hvis Admin, sendes bruker til Adminsiden.
                        // DETTE FORUTSETTER AT ROLLENE SOM ER LAGT TIL I DATABASEN ER LAGT INN I REKKE FØLGEN Admin (1) og Trener (2).
                        if (name.contains("1")) {
                            response.sendRedirect("/Skeleton-1.0/AdminSide.jsp");
                        } else {
                            response.sendRedirect("/Skeleton-1.0/TrenerSide.jsp");
                        }

                        // Setter brukernavnet for den innloggede brukeren som sesjonens attribut,
                        // slik at brukeren er knyttet til den opprettede sesjonsID-en
                        newSession.setAttribute("Bruker", _username);

                    } else {
                        // Hvis brukernavn og/eller passord som er tastet inn i html-en er feil, vises feilmelding
                        // nevnt nedenfor på siden som "nesteSide" refererer til.
                        RequestDispatcher rd = getServletContext().getRequestDispatcher(nesteSide);
                        PrintWriter sout = response.getWriter();
                        sout.println("<font color=red size='25'> Brukernavn eller passord er feil.</font>");
                        rd.include(request, response);
                    }

                } else {

                    System.out.println("Error, Innlogging feilet, kontakt systamansvarlig!");

                }

            } catch (Exception ex) {
                out.println("Exception :" + ex.getMessage());
                ex.printStackTrace();
            }
        }

    }


    @Override
    protected void writeBody(HttpServletRequest req, PrintWriter out) {

    }


}
