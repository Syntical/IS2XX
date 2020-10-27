package tools.repository;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.UtoevereModel;
import tools.DbTool;

public class UtoeverRepo {
    /**
     * legger til bruker til databasen.
     * Denne er ikke implementert. Her må dere gjerne prøve å lage en egen servlet som kan kommunisere med
     * denne metoden.
     *
     * @param utoever bruker objekt som inneholder all informasjon om personen.
     *                Tips: Objektet må instansieres i en servlet før man kaller på addUser().
     * @param p       printwriter for å skrive ut html i servlet. F.eks SQL feilmeldinger eller annen info.
     */


    public static int addUtoever(UtoevereModel utoever, PrintWriter p) {
        Connection db = null;
        PreparedStatement insertNewUtoever = null;
        try {
            db = DbTool.getINSTANCE().dbLoggIn(p);
            String query =
                    "INSERT INTO `utovere` (fornavn, etternavn, fodselsdato, hoyde, vekt) values (?,?,?,?,?)";

            insertNewUtoever = db.prepareStatement(query);
            insertNewUtoever.setString(1, utoever.getFornavn());
            insertNewUtoever.setString(2, utoever.getEtternavn());
            insertNewUtoever.setString(3, utoever.getFodselsdato());
            insertNewUtoever.setString(4, utoever.getHoyde());
            insertNewUtoever.setString(5, utoever.getVekt());
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

    public static void removeUtoever(String id, PrintWriter p) {

        Connection db = null;
        PreparedStatement removeBruker = null;
        try {
            db = DbTool.getINSTANCE().dbLoggIn(p);

            String query = "DELETE FROM Roprosjekt.Utovere WHERE utover_id= ? ";
            removeBruker = db.prepareStatement(query);
            removeBruker.setString(1, id);
            removeBruker.executeQuery();


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public static void changeUtoever(String fornavn, String id, PrintWriter p) {

        Connection db = null;
        PreparedStatement changeBruker = null;
        try {
            db = DbTool.getINSTANCE().dbLoggIn(p);

            String query = "UPDATE Roprosjekt.Utovere SET fornavn = ? WHERE Utover_id = ?";

            changeBruker = db.prepareStatement(query);
            changeBruker.setString(1, fornavn);
            changeBruker.setString(2, id);

            changeBruker.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}

