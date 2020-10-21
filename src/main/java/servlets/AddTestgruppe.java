package servlets;


import models.TestgruppeModel;
import models.UtoevereModel;
import org.mariadb.jdbc.MariaDbDatabaseMetaData;
import tools.DbTool;
import tools.repository.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.registry.infomodel.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;


@WebServlet(name = "AddTestgruppe", urlPatterns = {"/AddTestgruppe"})
public class AddTestgruppe extends AbstractAppServlet {
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
        writeResponse(request, response, "Legg til testgruppe!");
    }

    protected void writeBody(HttpServletRequest req, PrintWriter out){
        String action = req.getParameter("action");
        String tgn = req.getParameter("tgn");
        String tri = req.getParameter("tri");
        String tgi = req.getParameter("tgi");
        String ui = req.getParameter("ui");
        if (action.contains("leggTilTestgruppe")) {
            UserRepository.addTestgruppe(tgn, tri, tgi, ui, out);
        }
    }


}




