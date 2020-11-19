package servlets;



import tools.DbTool;
import tools.repository.UtoeverRepo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;


@WebServlet(name = "trenerKlubbelns", urlPatterns = {"/trenerKlubbelns"})
public class trenerKlubbelns extends AbstractAppServlet {
    private HttpSession session;



    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String kbb = request.getParameter("kbb");
        ResultSet rs = null;
        PrintWriter p = response.getWriter();

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


        Connection db = null;
        PreparedStatement dropDown = null;
        try {
            db = DbTool.getINSTANCE().dbLoggIn(p);
            ResultSet rss = null;
            String query = "SELECT * FROM klubb where klubb_id = ?";

            assert false;
            dropDown.setString(1, kbb);
            dropDown = db.prepareStatement(query);
            rss = dropDown.executeQuery();
            while (rss.next())
            {

      p.print("<option value=<%=rs.getInt(klubb_id) %>><%=rs.getString(klubbnavn)%> </option>");
                p.print("  <label for=kbb>Klubber:</label>");
                p.print("<select id= kbb   name=kbb>");
                p.print("    <option value=> Velg klubb </option>");
                p.print("</select>");



            }
        } catch (SQLException e ) {
            e.printStackTrace();

        }
        try {

            String klubbid = rs.getNString("klubb_id");

            if (kbb.contentEquals(klubbid)) {


            }


} catch (SQLException throwables) {
    throwables.printStackTrace();
}


        /**
         * skriver ut body på servlet som html.
         *
         * @param req http request objektet med data.
         * @param out http respons objektet som sender data.
         */
    }
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

