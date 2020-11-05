package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;


@WebServlet(name = "SesjonsTest", urlPatterns = {"/SesjonsTest"})
public class SesjonsTest extends AbstractAppServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("Bruker");

        PrintWriter writer = response.getWriter();

        writer.println("Sesjons ID: " + session.getId() + " belongs to " + username);
        writer.println("Opprettet: " + new Date(session.getCreationTime()));
        writer.println("Siste tilgangstidpkt: " + new Date(session.getLastAccessedTime()));
        writer.println("Session Timeout value: " + request.getSession().getMaxInactiveInterval() / 60 + " minutter");
    }


    @Override
    protected void writeBody(HttpServletRequest req, PrintWriter out) {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
