package tools.repository;

import models.Klubbmodell;
import models.UserModel;
import models.UtoevereModel;
import tools.DbTool;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 Legger til klubb i databasen
 @param navn bruker objekt som inneholder all informasjon om klubben.
 @param p printwriter for å skrive ut html i servlet. F.eks SQL feilmeldinger eller annen info.
 **/
public class KlubbRepo {
    public static void LeggTilKlubb(String navn, PrintWriter p) {
        Connection db = null;
        PreparedStatement insertNewBruker = null;
        try {
            db = DbTool.getINSTANCE().dbLoggIn(p);
            String query = "INSERT INTO `klubb` (klubbnavn) values (?)";
            insertNewBruker = db.prepareStatement(query);
            insertNewBruker.setString(1, navn);
            insertNewBruker.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    /**
     Sletter en klubb i databasen
     @param navn bruker objekt som inneholder all informasjon om klubb.
     @param p printwriter for å skrive ut html i servlet. F.eks SQL feilmeldinger eller annen info.
     **/
    public static void removeKlubb(String navn, PrintWriter p) {

        Connection db = null;
        PreparedStatement removeKlubb = null;
        try {
            db = DbTool.getINSTANCE().dbLoggIn(p);

            String query = "DELETE FROM klubb WHERE Klubbnavn= ? ";
            removeKlubb = db.prepareStatement(query);
            removeKlubb.setString(1, navn);
            removeKlubb.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    /**
     Endrer en enkel klubbs navn.
     @param navn bruker objekt som inneholder all informasjon om klubbnavn.
     @param id bruker objekt som inneholder all informasjon om klubbid.
     @param p printwriter for å skrive ut html i servlet. F.eks SQL feilmeldinger eller annen info.
     **/
    public static void changeKlubb(String navn, String id, PrintWriter p) {

        Connection db = null;
        PreparedStatement changeKlubb = null;
        try {
            db = DbTool.getINSTANCE().dbLoggIn(p);

            String query = "UPDATE klubb SET Klubbnavn = ? WHERE klubb_id = ?";

            changeKlubb = db.prepareStatement(query);
            changeKlubb.setString(1, navn);
            changeKlubb.setString(2, id);

            changeKlubb.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public static List<Klubbmodell> getKlubbnavn(PrintWriter p) {
        Connection db = null;
        PreparedStatement prepareStatement = null;

        List<Klubbmodell> toReturn = new ArrayList<>();
        try {
            db = DbTool.getINSTANCE().dbLoggIn(p);
            ResultSet rs = null;
            String query = "SELECT * FROM Roprosjekt.klubb";
            prepareStatement = db.prepareStatement(query);
            rs = prepareStatement.executeQuery();
            while (rs.next()) {
                Klubbmodell klubb = new Klubbmodell(rs.getString("klubbnavn"));
                toReturn.add(klubb);
            }
            rs.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return toReturn;
    }
}
