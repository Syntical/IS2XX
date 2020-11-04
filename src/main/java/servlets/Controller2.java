package servlets;

import org.w3c.dom.ls.LSOutput;
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
public class Controller2 extends AbstractAppServlet {


    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String _username = request.getParameter("vcbrukernavn");
            String _password = request.getParameter("vcpassord");

            Connection db = null;
            PreparedStatement pwm = null;

            try {

                String nesteSide = "/Login.jsp";

                if (_username != null) {

                    db = DbTool.getINSTANCE().dbLoggIn(out);
                    String Query = "Select * from Roprosjekt.Brukerinfo where Email=? and Passord=?";
                    pwm = db.prepareStatement(Query);
                    pwm.setString(1, _username);
                    pwm.setString(2, _password);

                    ResultSet rs = pwm.executeQuery();
                    if (rs.next()) {

                        //get the old session and invalidate
                        HttpSession oldSession = request.getSession(false);
                        if (oldSession != null) {
                            oldSession.invalidate();
                        }

                        //generate a new session
                        HttpSession newSession = request.getSession(true);

                        //setting session to expiry in 2 mins
                        newSession.setMaxInactiveInterval(2 * 60);

                        Cookie bruker = new Cookie("Bruker", _username);
                        bruker.setMaxAge(2 * 60); // Min * sekunder
                        response.addCookie(bruker);
                        response.sendRedirect("/Skeleton-1.0/AdminSide.jsp");
                        

                        newSession.setAttribute("Bruker", _username);

                    } else {

                        RequestDispatcher rd = getServletContext().getRequestDispatcher(nesteSide);
                        PrintWriter sout = response.getWriter();
                        sout.println("<font color=red>Either username or password is wrong.</font>");
                        rd.include(request, response);
                    }

                } else {

                    System.out.println("Eriks Error");

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
