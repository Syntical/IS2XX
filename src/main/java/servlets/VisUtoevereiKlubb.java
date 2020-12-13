package servlets;


import models.Klubbmodell;
import models.UserModel;
import models.UtoevereModel;
import models.UtoverClubModel;
import tools.repository.KlubbRepo;
import tools.repository.LoginRepo;
import tools.repository.SearchRepo;
import tools.repository.UtoeverRepo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Year;
import java.util.List;


@WebServlet(name = "VisUtoevereiKlubb", urlPatterns = {"/VisUtoevereiKlubb"})
public class VisUtoevereiKlubb extends AbstractAppServlet {
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


        //  String action = req.getParameter("action");

        // if (action.contains("HentKlubb")){
        //
        List<UtoverClubModel> UtoverClubModelList = UtoeverRepo.visUtoverKlubb(out);
        out.println("<link rel=\"stylesheet\"href=\"test.css\"/>");
        out.println("<ul>");
        // out.println("<li><form action=\"${pageContext.request.contextPath}/LoggUt\" method=\"post\">\n" +
        //               "        <input type=\"submit\" value=\"Logg ut\" /></form></li>");
        out.println("<li><form action=\"${pageContext.request.contextPath}/VisUtoevereiKlubb\" method=\"post\">\n" +
                "        <input type=\"submit\" value=\"Vis utøvere i klubben\" />\n" +
                "    </form></li>");
        out.println("<li><a href=\"AddBruker.jsp\">Legg til utøver</a></li>");
        out.println("<li><a href=\"Velgtestgruppe.jsp\">Testklasser </a></li>");
        out.println("<li><a href=\"TrenerSide.jsp\">Forside</a></li>");
        out.println("<li style=\"float:left\"><button class=\"button\" onclick=\"goBack()\"> Gå tilbake </button>\n" +
                "        <script>\n" +
                "                function goBack() {\n" +
                "            window.history.back()\n}");
        out.println("</script></li>");
        out.println("</ul>");

        out.println("<br>");
        out.println("<br>");
        out.println("<br>");
        out.println("<br>");
        out.println("<h1>Utøvere i klubb:</h1> ");
        out.println("<table style=\"1px solid black;margin-left:auto;margin-right:auto;\">");
        out.println("<tr>");
        out.println("<th scope=col> Etternavn: </th>");
        out.println("<th scope=col> Fornavn: </th>");
        out.println("<th scope=col> Fødselsår: </th>");
        out.println("<th scope=col> Klubb: </th>");

        for (UtoverClubModel utover : UtoverClubModelList) {
            out.format(" <tr><td> %s </td> <td> %s </td> <td> %s </td> <td> %s </td> </tr>", utover.getlastName(), utover.getfirstName(), utover.getAar(), utover.getClub());
        }
        out.println("</table>");
        out.println("<div class=\"informasjonsBar\">");
        out.println("Kontakt oss på Tlf: 990 99 999 eller E-post: roklubben@support.no");
        out.println("</div>");
        out.println("</table>");
    }
    //}

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