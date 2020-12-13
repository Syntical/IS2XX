package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.UtoevereModel;
import tools.repository.SearchRepo;


@WebServlet(name= "soooook", urlPatterns = {"/soooook"})
public class soooook extends AbstractAppServlet {
    /**
     * Tar imot http requesten og kaller på writeResponse()
     * @param request objektet sender data til servletet
     * @param response objektet sender data fra servleten.
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        writeResponse(request, response, "Hello!");
    }

    /**
     * skriver ut body på servlet som html.
     * @param req http request objektet med data.
     * @param out http respons objektet som sender data.
     */
    @Override
    protected void writeBody(HttpServletRequest req, PrintWriter out) {
        String action = req.getParameter("action");
        String kl = req.getParameter("kl");
        String tge = req.getParameter("tge");
        String ts = req.getParameter("ts");


        if (action.contains("sok")) {
            List<UtoevereModel> sokes = SearchRepo.SøkTKÅ(kl, tge, ts, out);
            out.println("<link rel=\"stylesheet\" href=\"test.css\"/>");
            out.println("<ul>");
            out.println("<li><a href=\"index.jsp\">Tilbake til forsiden</a></li>");
            out.println("</ul>");
            out.println("<br>");
            out.println("<br>");
            out.println("<br>");
            out.println("<br>");
            out.println("<h1>Her er ditt søkeresultat:</h1> ");
            out.println("<table style=\"1px solid black;margin-left:auto;margin-right:auto;\">");
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
            for (UtoevereModel model : sokes) {
                out.format(" <tr><td> %s </td> <td>  %s </td> <td> %s </td> <td> %s </td> <td>  %s </td> <td> %s </td> <td>  %s </td> <td> %s </td> <td> %s </td> <td>  %s </td> <td> %s </td> <td>  %s </td> <td> %s </td> <td> %s </td> <td>  %s </td>\" +" +
                                "\n" + "<td> %s </td> <td>  %s </td> <td> %s </td> <td> %s </td> <td>  %s </td> <td> %s </td> <td>  %s </td> </tr> ", model.getFornavn(),
                        model.getEtternavn(), model.getFodselsdato(), model.getHoyde(), model.getVekt(), model.getFemtusen_watt(), model.getFemtusen_tid(),
                        model.getTretusen_sek(), model.getTretusen_tid(), model.getTretusen_lop_tid(), model.getTotusen_watt(), model.getTotusen_tid(), model.getSeksti_watt(), model.getKropps_hev_stk(),
                        model.getSargeant_stk(), model.getBeveg_stk(), model.getLigg_ro(), model.getLigg_ro_pst(), model.getLigg_ro_kg(), model.getKneboy_pst(), model.getKneboy_kg(), model.getTotalscore());
            }
            out.println("</table>");
            out.println("<div class=\"informasjonsBar\">");
            out.println("Kontakt oss på Tlf: 990 99 999 eller E-post: roklubben@support.no");
            out.println("</div>");
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
     * @param request servlet request
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
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
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

