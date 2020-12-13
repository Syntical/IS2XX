package servlets;


import models.Klubbmodell;
import tools.repository.KlubbRepo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "AddKlubb", urlPatterns = {"/AddKlubb"})
public class AddKlubb extends AbstractAppServlet {
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
        writeResponse(request, response, "Klubb!");
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
        String kb = req.getParameter("kb");


        if (action.contains("Legg til klubb")) {
            KlubbRepo.LeggTilKlubb(kb, out);
             out.println("<link href='test.css' type='text/css' rel='stylesheet'>");
            out.println("<ul>");
            out.println("<li><a href=\"addKlubb.jsp\">Legg til klubb</a></li>");
            out.println("<li><a href=\"AddTestgruppe.jsp\">Legg til testklasse</a></li>");
            out.println("<li><a href=\"Testår.jsp\">Legg til testår og -uke</a></li>");
            out.println("<li><a href=\"RegistrerNyBruker.jsp\">Registrer ny systembruker</a></li>");
            out.println("<li style=\"float:left\"><button class=\"button\" onclick=\"goBack()\">Gå tilbake</button>\n" +
                    "        <script>\n" +
                    "                function goBack() {\n" +
                    "            window.history.back();\n" +
                    "        }\n" +
                    "        </script></li>");
            out.println("</ul>");
            out.println("<div class=\"Rembruker\">");
            out.println("Klubben ble lagt til i databasen");
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

