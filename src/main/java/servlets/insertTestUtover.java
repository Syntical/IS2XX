package servlets;


import models.TestModell;
import models.UtoevereModel;
import tools.repository.LoginRepo;
import tools.repository.SearchRepo;
import tools.repository.UtoeverRepo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet(name = "insertTestUtover", urlPatterns = {"/insertTestUtover"})
public class insertTestUtover extends AbstractAppServlet {
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
        String test = req.getParameter("test");
        String klubb = req.getParameter("klubb");



        if (action.contains("adde")) {
            UtoevereModel utoever = new UtoevereModel(req.getParameter("fn"), req.getParameter("en"), req.getParameter("fd"), req.getParameter("hd"), req.getParameter("vk"), req.getParameter("ftw"),
                    req.getParameter("ftt"), req.getParameter("tts"), req.getParameter("ttt"), req.getParameter("tlt"), req.getParameter("ttw"),
                    req.getParameter("tott"), req.getParameter("sw"), req.getParameter("khs"), req.getParameter("sgs"), req.getParameter("bs"), req.getParameter("lr"), req.getParameter("lrp"),
                    req.getParameter("lrk"), req.getParameter("kbp"), req.getParameter("kbk"), req.getParameter("totsc"));
            UtoeverRepo.temp(utoever, year, klubb, test, out);
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

