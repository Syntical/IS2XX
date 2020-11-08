package tools.repository;

import tools.DbTool;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Testrepo {


    public static void addTestAr(String ar, String uke, PrintWriter p) {

        Connection db = null;
        PreparedStatement addar = null;
        try {
            db = DbTool.getINSTANCE().dbLoggIn(p);

            String query = "INSERT INTO testyear (Year, Testuke) VALUES (?, ?)";

            addar = db.prepareStatement(query);
            addar.setString(1, ar);
            addar.setString(2, uke);
            addar.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                assert db != null;
                db.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }


    }

    public static void addTestGruppe(String tsg, PrintWriter p) {

        Connection db = null;
        PreparedStatement testgruppe = null;
        try {
            db = DbTool.getINSTANCE().dbLoggIn(p);

            String query = "INSERT INTO Testgruppe (TestGruppeNavn) VALUES (?)";

            testgruppe = db.prepareStatement(query);
            testgruppe.setString(1, tsg);

            testgruppe.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                assert db != null;
                db.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }



    }
}
