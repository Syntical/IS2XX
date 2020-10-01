package tools.repository;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.UtoevereModel;
import org.graalvm.compiler.printer.BinaryGraphPrinter;
import tools.DbTool;

public class UserRepository {
    /**
     * legger til bruker til databasen.
     * Denne er ikke implementert. Her må dere gjerne prøve å lage en egen servlet som kan kommunisere med
     * denne metoden.
     * @param utoever bruker objekt som inneholder all informasjon om personen.
     * Tips: Objektet må instansieres i en servlet før man kaller på addUser().
     * @param p printwriter for å skrive ut html i servlet. F.eks SQL feilmeldinger eller annen info.
     */

    public static int addUtoever(UtoevereModel utoever, PrintWriter p) {
        Connection db = null;
        PreparedStatement insertNewUtoever = null;
        try {
            db = DbTool.getINSTANCE().dbLoggIn(p);
            String query =
                "INSERT INTO `utoevere` (fornavn, etternavn, vekt) values (?, ?, ?)";

            insertNewUtoever = db.prepareStatement(query);
            insertNewUtoever.setString(1, utoever.getFornavn());
            insertNewUtoever.setString(2, utoever.getEtternavn());
            insertNewUtoever.setString(3, utoever.getVekt());
            insertNewUtoever.execute();

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

    /**
     * henter ut spesifikk person fra databasen
     * @param fornavn brukerens epost-addresse ("trym@example.com");
     * @param p printwriter see metoden over.
     * @return et String objekt med eposten til brukeren.
     */

    public static String getEtternavn(String fornavn, PrintWriter p) {
        Connection db = null;
        PreparedStatement prepareStatement = null;

        String toReturn = null;
        try {
            db = DbTool.getINSTANCE().dbLoggIn(p);
            ResultSet rs = null;
            String query = "SELECT * FROM roklubben.utoevere where fornavn = ?";
            prepareStatement = db.prepareStatement(query);
            prepareStatement.setString(1, fornavn);
            rs = prepareStatement.executeQuery();
            while (rs.next()) {
                toReturn = rs.getString("Fornavn");
            }
            rs.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return toReturn;
    }

    public static List<UtoevereModel> getUtoever(PrintWriter p) {
        Connection db = null;
        PreparedStatement prepareStatement = null;

        List<UtoevereModel> toReturn = new ArrayList<>();
        try {
            db = DbTool.getINSTANCE().dbLoggIn(p);
            ResultSet rs = null;
            String query = "SELECT * FROM roklubben.utoevere";
            prepareStatement = db.prepareStatement(query);
            rs = prepareStatement.executeQuery();
            while (rs.next()) {
                UtoevereModel utoever = new UtoevereModel(rs.getString("fornavn"), rs.getString("etternavn"),rs.getString("vekt"));
                toReturn.add(utoever);
            }
            rs.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return toReturn;
    }
}