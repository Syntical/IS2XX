package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.UtoevereModel;
import tools.repository.UserRepository;


@WebServlet(name= "ResultsFromDb", urlPatterns = {"/ResultsFromDb"})
public class ResultsFromDb extends AbstractAppServlet {
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
        String fornavn = req.getParameter("ffnavn");
        List<UtoevereModel> nameFromDb = UserRepository.getFornavn(fornavn, out);
        out.println("<h1>Her er ditt søkeresultat:</h1> ");
        out.println("<table>");
        out.println("<tr>");
        out.println("<th scope=col> Fornavn: </th>");
        out.println("<th scope=col> Etternavn: </th>");
        out.println("<th scope=col> Fødselsår: </th>");
        out.println("<th scope=col> Høyde: </th>");
        out.println("<th scope=col> Vekt: </th>");
        out.println("</tr>");
        for (UtoevereModel model : nameFromDb) {
            out.format(" <tr><td> %s </td> <td>  %s </td> <td> %s </td> <td> %s </td> <td>  %s </td> </tr>", model.getFornavn(),
                    model.getEtternavn(), model.getFodselsdato(), model.getHoyde(), model.getVekt());
        }
        out.println("</table>");
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
