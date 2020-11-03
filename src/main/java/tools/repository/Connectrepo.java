package tools.repository;

import tools.DbTool;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Connectrepo {

    public static int leggtilalt(String tstID, String kbID, PrintWriter p) {
        Connection db = null;
        PreparedStatement insertNewBrukerinfo = null;
        try {
            db = DbTool.getINSTANCE().dbLoggIn(p);
            String query =


                    "INSERT INTO Register (utovere_id, testgruppe_id, klubb_id) " +
                            "VALUES( (SELECT MAX (utoever_id) FROM utovere), ?, ?)";



            insertNewBrukerinfo = db.prepareStatement(query);
            insertNewBrukerinfo.setString(1, tstID);
            insertNewBrukerinfo.setString(2, kbID);







            insertNewBrukerinfo.execute();



        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                assert db != null;
                db.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return 1;
    }
}

