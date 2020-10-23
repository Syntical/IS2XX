package servlets;

import tools.DbTool;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Controller2 extends AbstractAppServlet {

    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String _username = request.getParameter("vcbrukernavn");
            String _password = request.getParameter("vcpassord");
            String action = request.getParameter("action");
            Connection db = null;
            PreparedStatement pwm = null;

            try {


                // Sjekker at felter "brukernavn" ikke er tomt
                if (_username != null) {

                    db = DbTool.getINSTANCE().dbLoggIn(out);
                    String Query = "Select * from Roprosjekt.Brukerinfo where Brukernavn=? and Passord=?";
                    pwm = db.prepareStatement(Query);
                    pwm.setString(1, _username);
                    pwm.setString(2, _password);
                    ResultSet rs = pwm.executeQuery();
                    if (rs.next()) {
                        response.sendRedirect("AdminSide.jsp");
                    } else
                        response.sendRedirect("Login.jsp");
                } else
                    System.out.println("Eriks Error");
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
