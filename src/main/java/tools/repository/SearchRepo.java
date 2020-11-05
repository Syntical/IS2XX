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
            String query = "SELECT * FROM utovere JOIN testregister where fornavn = ?";
            prepareStatement = db.prepareStatement(query);
            prepareStatement.setString(1, fornavn);
            rs = prepareStatement.executeQuery();
            while (rs.next()) {
                UtoevereModel utoever = new UtoevereModel(rs.getString("fornavn"), rs.getString("etternavn"), rs.getString("fodselsdato"), rs.getString("hoyde"), rs.getString("vekt"),
                        rs.getString("5000_watt"), rs.getString("5000_tid"), rs.getString("3000_sek"), rs.getString("3000_tid"), rs.getString("3000_lop_tid"), rs.getString("2000_watt"), rs.getString("2000_tid"),
                        rs.getString("60_watt"), rs.getString("kropps_hev_stk"), rs.getString("Sargeant_stk"), rs.getString("beveg_stk"), rs.getString("ligg_ro"), rs.getString("ligg_ro_pst"), rs.getString("ligg_ro_kg"), rs.getString("kneboy_pst"),
                        rs.getString("kneboy_kg"), rs.getString("totalscore"));
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
            String query = "SELECT * FROM utovere JOIN testregister USING(utover_id)";
            prepareStatement = db.prepareStatement(query);
            rs = prepareStatement.executeQuery();
            while (rs.next()) {
                UtoevereModel utoever = new UtoevereModel(rs.getString("fornavn"), rs.getString("etternavn"), rs.getString("fodselsdato"), rs.getString("hoyde"), rs.getString("vekt"),
                        rs.getString("5000_watt"), rs.getString("5000_tid"), rs.getString("3000_sek"), rs.getString("3000_tid"), rs.getString("3000_lop_tid"), rs.getString("2000_watt"), rs.getString("2000_tid"),
                        rs.getString("60_watt"), rs.getString("kropps_hev_stk"), rs.getString("Sargeant_stk"), rs.getString("beveg_stk"), rs.getString("ligg_ro"), rs.getString("ligg_ro_pst"), rs.getString("ligg_ro_kg"), rs.getString("kneboy_pst"),
                        rs.getString("kneboy_kg"), rs.getString("totalscore"));
                toReturn.add(utoever);
            }
            rs.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return toReturn;
    }
}
