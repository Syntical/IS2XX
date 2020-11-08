package tools.repository;

import models.UtoevereModel;
import tools.DbTool;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UtoeverRepo {
    /**
     * legger til utøver til databasen.

     * @param utoever bruker objekt som inneholder all informasjon om personen.
     *                Tips: Objektet må instansieres i en servlet før man kaller på addUser().
     * @param p       printwriter for å skrive ut html i servlet. F.eks SQL feilmeldinger eller annen info.
     */


    public static int addUtoever(UtoevereModel utoever, String id,  String klubb, String gruppe ,PrintWriter p) {
        Connection db = null;
        PreparedStatement insertNewUtoever = null;
        try {
            db = DbTool.getINSTANCE().dbLoggIn(p);
            String transquery = "BEGIN;";
            String query1 =
                    "INSERT INTO `utovere` (Fornavn, Etternavn, Fodselsdato, Hoyde, Vekt) values (?,?,?,?,?)";


            String query2 ="INSERT INTO testregister (utover_id, testyear_id, 5000_watt, 5000_tid, 3000_sek, 3000_tid, 3000_lop_tid, 2000_watt, 2000_tid, 60_watt," +
                            "kropps_hev_stk, Sargeant_stk, beveg_stk, ligg_ro, ligg_ro_pst, ligg_ro_kg, kneboy_pst, kneboy_kg, totalscore) " +
                            "values ((SELECT MAX(utover_id) FROM utovere),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";


            String query3 =  "INSERT INTO Register (utover_id, testgruppe_id, klubb_id, bruker_id) " +
                    "VALUES ((SELECT MAX(utover_id) FROM utovere), ?, ?, 1)";

            String query4  ="commit;";

            insertNewUtoever = db.prepareStatement(query1);
            insertNewUtoever.setString(1, utoever.getFornavn());
            insertNewUtoever.setString(2, utoever.getEtternavn());
            insertNewUtoever.setString(3, utoever.getFodselsdato());
            insertNewUtoever.setString(4, utoever.getHoyde());
            insertNewUtoever.setString(5, utoever.getVekt());


            PreparedStatement insertNewTest = db.prepareStatement(query2);


            insertNewTest.setString(1, id);
            insertNewTest.setString(2, utoever.getFemtusen_watt());
            insertNewTest.setString(3, utoever.getFemtusen_tid());
            insertNewTest.setString(4, utoever.getTretusen_sek());
            insertNewTest.setString(5, utoever.getTretusen_tid());
            insertNewTest.setString(6, utoever.getTretusen_lop_tid());
            insertNewTest.setString(7, utoever.getTotusen_watt());
            insertNewTest.setString(8, utoever.getTotusen_tid());
            insertNewTest.setString(9, utoever.getSeksti_watt());
            insertNewTest.setString(10, utoever.getKropps_hev_stk());
            insertNewTest.setString(11, utoever.getSargeant_stk());
            insertNewTest.setString(12, utoever.getBeveg_stk());
            insertNewTest.setString(13, utoever.getLigg_ro());
            insertNewTest.setString(14, utoever.getLigg_ro_pst());
            insertNewTest.setString(15, utoever.getLigg_ro_kg());
            insertNewTest.setString(16, utoever.getKneboy_pst());
            insertNewTest.setString(17, utoever.getKneboy_kg());
            insertNewTest.setString(18, utoever.getTotalscore());


            PreparedStatement insertNewReg = db.prepareStatement(query3);
            insertNewReg.setString(1, klubb);
            insertNewReg.setString(2, gruppe);

            PreparedStatement begin = db.prepareStatement(transquery);
            PreparedStatement end = db.prepareStatement(query4);

            begin.execute();
            insertNewUtoever.execute();
            insertNewTest.execute();
            insertNewReg.execute();
            end.execute();



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
     * Fjerner en utøver fra databasen

     * @param id objektet som brukes for å slette en utøver via sql id.
     *
     * @param p       printwriter for å skrive ut html i servlet. F.eks SQL feilmeldinger eller annen info.
     */

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
        } finally {
            try {
                assert db != null;
                db.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }


    }

    /**
     * Endrer for øyeblikket kun fornavn

     @param fornavn objektet som inneholder dataen vi endrer

     * @param id objektet som brukes for å slette en utøver via sql id.
     *
     * @param p       printwriter for å skrive ut html i servlet. F.eks SQL feilmeldinger eller annen info.
     */
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

