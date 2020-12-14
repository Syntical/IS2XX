package servlets;


import models.UtoevereModel;
import tools.repository.SearchRepo;
import tools.repository.UtoeverRepo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


@WebServlet(name = "AddBruker", urlPatterns = {"/AddBruker"})
public class AddBruker extends AbstractAppServlet {
    /**
     * Tar imot http requesten og kaller på writeResponse()
     *
     * @param request  objektet sender data til servletet
     * @param response objektet sender data fra servleten.
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        writeResponse(request, response, "Legg til bruker!");
    }

    /**
     * skriver ut body på servlet som html.
     *
     * @param req http request objektet med data.
     * @param out http respons objektet som sender data.
     */
    @Override

    protected void writeBody(HttpServletRequest req, PrintWriter out) {

        String action = req.getParameter("action");
        String year = req.getParameter("year");
        String klubb = req.getParameter("klubb");
        String test = req.getParameter("test");

        if (action.contains("Legg til ny utover og resultat")) {
            UtoevereModel utoever = new UtoevereModel(req.getParameter("fn"), req.getParameter("en"), req.getParameter("fd"), req.getParameter("hd"), req.getParameter("vk"), req.getParameter("ftw"),
                    req.getParameter("ftt"), req.getParameter("tts"), req.getParameter("ttt"), req.getParameter("tlt"), req.getParameter("ttw"),
                    req.getParameter("tott"), req.getParameter("sw"), req.getParameter("khs"), req.getParameter("sgs"), req.getParameter("bs"), req.getParameter("lr"), req.getParameter("lrp"),
                    req.getParameter("lrk"), req.getParameter("kbp"), req.getParameter("kbk"), req.getParameter("totsc"));
            UtoeverRepo.addUtoever(utoever, year, test, klubb, out);
            String[] arr = { req.getParameter("ftw"), req.getParameter("ftt"), req.getParameter("tts"), req.getParameter("ttt"), req.getParameter("tlt"), req.getParameter("ttw"),
                    req.getParameter("tott"), req.getParameter("sw"), req.getParameter("khs"), req.getParameter("sgs"), req.getParameter("bs"), req.getParameter("lr"), req.getParameter("lrp"),
                    req.getParameter("lrk"), req.getParameter("kbp"), req.getParameter("kbk"), req.getParameter("totsc")};

            boolean  etTestfeltErFyltUt= false;
            System.out.println("ftw = " + req.getParameter("ftw"));
            for(String e : arr) {
                System.out.println("e = " + e.length());
                if (e.length() > 0) {
                    etTestfeltErFyltUt = true;
                    break;
                }
            }

            if (etTestfeltErFyltUt) {

                out.println("<link href='test.css' type='text/css' rel='stylesheet'>");
                out.println("<div class=\"Innlogging\">");
                out.println("<h1>");
                out.println(utoever.getFornavn());
                out.println(utoever.getEtternavn() + " ble lagt til i databasen. </h1>");
                out.println("<br>");
                out.println("<br>");
                out.println("Trykk her for å gå tilbake");
                out.println("<br>");
                out.println("<a href=AddBruker.jsp class=\"button\">Tilbake</a>");
                out.println("</div>");

            } else if (!etTestfeltErFyltUt) {
                out.println("<a href=AddBruker.jsp> <h1> Ops! Du har kommet til denne siden fordi du har lagt til en utøver uten resultater </h1>");
                out.println("<font color=red size='25'> Vennligst klikk her for å forsøke igjen . Hazzard imidi!!!</font>");
            }

        } if (action.contains("hent")){
            List<UtoevereModel> utoevereModelList = SearchRepo.getUtoever(out);
            out.println("<h1>Her er listen over alle medlemmene i roklubben:</h1> ");
            out.println("<table>");
            out.println("<tr>");
            out.println("<th scope=col> Fornavn: </th>");
            out.println("<th scope=col> Etternavn: </th>");
            out.println("<th scope=col> Fødselsår: </th>");
            out.println("<th scope=col> Høyde: </th>");
            out.println("<th scope=col> Vekt: </th>");
            out.println("<th scope=col> 5000 watt: </th>");
            out.println("<th scope=col> 5000 tid: </th>");
            out.println("<th scope=col> 3000 sek: </th>");
            out.println("<th scope=col> 3000 tid: </th>");
            out.println("<th scope=col> 3000 løp tid: </th>");
            out.println("<th scope=col> 2000 watt: </th>");
            out.println("<th scope=col> 2000 tid: </th>");
            out.println("<th scope=col> 60 watt: </th>");
            out.println("<th scope=col> Kroppshev stk: </th>");
            out.println("<th scope=col> Sargeant stk: </th>");
            out.println("<th scope=col> Bevegelse stk: </th>");
            out.println("<th scope=col> Ligg ro: </th>");
            out.println("<th scope=col> Ligg ro prosent: </th>");
            out.println("<th scope=col> Ligg ro kilo: </th>");
            out.println("<th scope=col> Knebøy prosent: </th>");
            out.println("<th scope=col> Knebøy kilo: </th>");
            out.println("<th scope=col> Totalscore: </th>");
            out.println("</tr>");

            for (UtoevereModel model : utoevereModelList) {
                out.format(" <tr><td> %s </td> <td>  %s </td> <td> %s </td> <td> %s </td> <td>  %s </td> <td> %s </td> <td>  %s </td> <td> %s </td> <td> %s </td> <td>  %s </td> <td> %s </td> <td>  %s </td> <td> %s </td> <td> %s </td> <td>  %s </td>\" +" +
                                "\n" + "<td> %s </td> <td>  %s </td> <td> %s </td> <td> %s </td> <td>  %s </td> <td> %s </td> <td>  %s </td> </tr> ", model.getFornavn(),
                        model.getEtternavn(), model.getFodselsdato(), model.getHoyde(), model.getVekt(),model.getFemtusen_watt(), model.getFemtusen_tid(),
                        model.getTretusen_sek(), model.getTretusen_tid(), model.getTretusen_lop_tid(), model.getTotusen_watt(), model.getTotusen_tid(), model.getSeksti_watt(), model.getKropps_hev_stk(),
                        model.getSargeant_stk(), model.getBeveg_stk(), model.getLigg_ro(), model.getLigg_ro_pst(), model.getLigg_ro_kg(), model.getKneboy_pst(), model.getKneboy_kg(), model.getTotalscore());
            }
            out.println("</table>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

    /**
     * Alle get forespørsler til denne servleten blir håndert av doGEt.
     * får servleten en Get request vil den svare med doGet som kaller på metoden process Request.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}

