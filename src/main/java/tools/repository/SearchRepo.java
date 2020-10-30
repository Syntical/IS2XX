package tools.repository;

import models.UtoevereModel;
import tools.DbTool;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SearchRepo {
    /**
     * henter ut spesifikk person fra databasen
     *
     * @param fornavn henter ut utøverens data ved bruk av fornavn
     * @param p       printwriter see metoden over.
     * @return et String objekt med eposten til brukeren.
     */

    public static List<UtoevereModel> getFornavn(String fornavn, PrintWriter p) {
        Connection db = null;
        PreparedStatement prepareStatement = null;

        List<UtoevereModel> toReturn = new ArrayList<>();
        try {
            db = DbTool.getINSTANCE().dbLoggIn(p);
            ResultSet rs = null;
            String query = "SELECT * FROM utovere where fornavn = ?";
            prepareStatement = db.prepareStatement(query);
            prepareStatement.setString(1, fornavn);
            rs = prepareStatement.executeQuery();
            while (rs.next()) {
                UtoevereModel utoever = new UtoevereModel(rs.getString("fornavn"), rs.getString("etternavn"), rs.getString("fodselsdato"), rs.getString("hoyde"), rs.getString("vekt"));
                toReturn.add(utoever);
            }
            rs.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return toReturn;
    }

    /**
     * Henter ut all data fra databasen om utøvere.
     *
     * @return et String objekt med eposten til brukeren.
     */
    public static List<UtoevereModel> getUtoever(PrintWriter p) {
        Connection db = null;
        PreparedStatement prepareStatement = null;

        List<UtoevereModel> toReturn = new ArrayList<>();
        try {
            db = DbTool.getINSTANCE().dbLoggIn(p);
            ResultSet rs = null;
            String query = "SELECT * FROM Roprosjekt.utovere";
            prepareStatement = db.prepareStatement(query);
            rs = prepareStatement.executeQuery();
            while (rs.next()) {
                UtoevereModel utoever = new UtoevereModel(rs.getString("fornavn"), rs.getString("etternavn"), rs.getString("fodselsdato"), rs.getString("hoyde"), rs.getString("vekt"));
                toReturn.add(utoever);
            }
            rs.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return toReturn;
    }
}
