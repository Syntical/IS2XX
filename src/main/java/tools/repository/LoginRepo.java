package tools.repository;

import tools.DbTool;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LoginRepo {
    public static void Login(String bruk, String Passo, PrintWriter p) {

        Connection db = null;
        PreparedStatement Log = null;
        try {
            db = DbTool.getINSTANCE().dbLoggIn(p);

            String query = "SELECT * FROM Brukerinfo WHERE brukernavn = ? AND Passo = ?";
            Log = db.prepareStatement(query);
            Log.setString(1, bruk);
            Log.setString(2, Passo);
            Log.executeQuery();


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static int Registrer(String Brukernavn, String passord, PrintWriter p) {
        Connection db = null;
        PreparedStatement insertNewBruker = null;
        try {
            db = DbTool.getINSTANCE().dbLoggIn(p);
            String query =
                    "INSERT INTO `Brukerinfo` (Brukernavn, Passord) values (?,?)";

            insertNewBruker = db.prepareStatement(query);
            insertNewBruker.setString(1, Brukernavn);
            insertNewBruker.setString(2, passord);

            insertNewBruker.execute();

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
