package servlets;



import tools.repository.UtoeverRepo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;


@WebServlet(name = "velgTG", urlPatterns = {"/velgTG"})
public class velgTG extends AbstractAppServlet {
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

        String tg = request.getParameter("tg");


        if (tg.matches("1")) {

            response.sendRedirect("/Skeleton-1.0/MennSenior.jsp");

        } else if (tg.matches("2")) {
                    response.sendRedirect("/Skeleton-1.0/DamerSenior.jsp");
        } else if (tg.matches("3")) {
            response.sendRedirect("/Skeleton-1.0/JuniorA.jsp");
        } else if (tg.matches("4")) {
            response.sendRedirect("/Skeleton-1.0/JuniorA.jsp");
        } else if (tg.matches("5")) {
            response.sendRedirect("/Skeleton-1.0/JuniorB.jsp");
        } else if (tg.matches("6")) {
        response.sendRedirect("/Skeleton-1.0/JuniorB.jsp");
        }  else if (tg.matches("7")) {
        response.sendRedirect("/Skeleton-1.0/JuniorC.jsp");
     } else if (tg.matches("8")) {
        response.sendRedirect("/Skeleton-1.0/JuniorC.jsp");
        }



        }

        /**
         * skriver ut body på servlet som html.
         *
         * @param req http request objektet med data.
         * @param out http respons objektet som sender data.
         */

    @Override
    protected void writeBody(HttpServletRequest req, PrintWriter out) {




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

