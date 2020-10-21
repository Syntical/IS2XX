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

public class UserRepository {
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

    /**
     * henter ut spesifikk person fra databasen
     *
     * @param fornavn brukerens epost-addresse ("trym@example.com");
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
                UtoevereModel utoever = new UtoevereModel(rs.getString("fornavn"), rs.getString("etternavn"),rs.getString("fodselsdato"),rs.getString("hoyde"), rs.getString("vekt"));
                toReturn.add(utoever);
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
            String query = "SELECT * FROM Roprosjekt.utovere";
            prepareStatement = db.prepareStatement(query);
            rs = prepareStatement.executeQuery();
            while (rs.next()) {
                UtoevereModel utoever = new UtoevereModel(rs.getString("fornavn"), rs.getString("etternavn"),rs.getString("fodselsdato"),rs.getString("hoyde"), rs.getString("vekt"));
                toReturn.add(utoever);
            }
            rs.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return toReturn;
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


        } catch (SQLException e ) {
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

        } catch (SQLException e ) {
            e.printStackTrace();
        }

    }


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


        } catch (SQLException e ) {
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
            insertNewBruker.setString(1,Brukernavn);
            insertNewBruker.setString(2,passord);

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


    UserRepository.java

    public static int addTestgruppe(String Testgruppenavn, String utover_id, String test_reg_id, String Testgruppe_id, PrintWriter p) {
        Connection db = null;
        PreparedStatement insertNewTestGruppe = null;
        try {
            db = DbTool.getINSTANCE().dbLoggIn(p);
            String query =
                    "INSERT INTO 'Testgruppe' (Testgruppenavn, test_reg_id, utover_id, Testgruppe_id) values (?, ?, ?, ?)";


            insertNewTestGruppe = db.prepareStatement(query);
            insertNewTestGruppe.setString(1, Testgruppenavn);
            insertNewTestGruppe.setString(2, test_reg_id);
            insertNewTestGruppe.setString(3, utover_id);
            insertNewTestGruppe.setString(4, Testgruppe_id);


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

