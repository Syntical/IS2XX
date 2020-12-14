package tools.repository;

import models.TestModell;
import models.UtoevereModel;
import models.UtoverClubModel;
import tools.DbTool;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UtoeverRepo {
    /**
     * legger til utøver til databasen.
     *
     * @param utoever bruker objekt som inneholder all informasjon om personen.
     *                Tips: Objektet må instansieres i en servlet før man kaller på addUser().
     * @param p       printwriter for å skrive ut html i servlet. F.eks SQL feilmeldinger eller annen info.
     */


    public static void addUtoever(UtoevereModel utoever, String id, String klubb, String gruppe, PrintWriter p) {
        Connection db = null;
        PreparedStatement insertNewUtoever = null;
        boolean success = false;
        try {
            db = DbTool.getINSTANCE().dbLoggIn(p);
            String transquery = "BEGIN;";
            String query1 =
                    "INSERT INTO `utovere` (Fornavn, Etternavn, Fodselsdato, Hoyde, Vekt) values (?,?,?,?,?)";


            String query2 = "INSERT INTO testregister (utover_id, test_year_id, 5000_watt, 5000_tid, 3000_sek, 3000_tid, 3000_lop_tid, 2000_watt, 2000_tid, 60_watt," +
                    "kropps_hev_stk, Sargeant_stk, beveg_stk, ligg_ro, ligg_ro_pst, ligg_ro_kg, kneboy_pst, kneboy_kg, totalscore) " +
                    "values ((SELECT MAX(utover_id) FROM utovere),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";


            String query3 = "INSERT INTO Register (utover_id, testgruppe_id, klubb_id, bruker_id) " +
                    "VALUES ((SELECT MAX(utover_id) FROM utovere), ?, ?, 1)";

            String query4 = "commit;";

            insertNewUtoever = db.prepareStatement(query1);
            insertNewUtoever.setString(1, utoever.getFornavn());
            insertNewUtoever.setString(2, utoever.getEtternavn());
            insertNewUtoever.setString(3, utoever.getFodselsdato());
            insertNewUtoever.setString(4, utoever.getHoyde());
            insertNewUtoever.setString(5, utoever.getVekt());


            PreparedStatement insertNewTest = db.prepareStatement(query2);


            insertNewTest.setString(1, id);
            insertNewTest.setInt(2, utoever.getFemtusen_watt());
            insertNewTest.setInt(3, utoever.getFemtusen_tid());
            insertNewTest.setInt(4, utoever.getTretusen_sek());
            insertNewTest.setInt(5, utoever.getTretusen_tid());
            insertNewTest.setInt(6, utoever.getTretusen_lop_tid());
            insertNewTest.setInt(7, utoever.getTotusen_watt());
            insertNewTest.setInt(8, utoever.getTotusen_tid());
            insertNewTest.setInt(9, utoever.getSeksti_watt());
            insertNewTest.setInt(10, utoever.getKropps_hev_stk());
            insertNewTest.setInt(11, utoever.getSargeant_stk());
            insertNewTest.setInt(12, utoever.getBeveg_stk());
            insertNewTest.setInt(13, utoever.getLigg_ro());
            insertNewTest.setInt(14, utoever.getLigg_ro_pst());
            insertNewTest.setInt(15, utoever.getLigg_ro_kg());
            insertNewTest.setInt(16, utoever.getKneboy_pst());
            insertNewTest.setInt(17, utoever.getKneboy_kg());
            insertNewTest.setInt(18, utoever.getTotalscore());


            PreparedStatement insertNewReg = db.prepareStatement(query3);
            insertNewReg.setString(1, klubb);
            insertNewReg.setString(2, gruppe);

            PreparedStatement begin = db.prepareStatement(transquery);
            PreparedStatement end = db.prepareStatement(query4);

            begin.execute();
            insertNewUtoever.executeQuery();

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


    }

    /**
     * Fjerner en utøver fra databasen
     *
     * @param id objektet som brukes for å slette en utøver via sql id.
     * @param p  printwriter for å skrive ut html i servlet. F.eks SQL feilmeldinger eller annen info.
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
     *
     * @param fornavn objektet som inneholder dataen vi endrer
     * @param id      objektet som brukes for å slette en utøver via sql id.
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
        } finally {
            try {
                assert db != null;
                db.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }


    }

    public static List<UtoverClubModel> visUtoverKlubb(PrintWriter p) {
        Connection db = null;
        PreparedStatement prepareStatement = null;

        List<UtoverClubModel> toReturn = new ArrayList<>();
        try {
            db = DbTool.getINSTANCE().dbLoggIn(p);
            ResultSet rs = null;
            String query = "SELECT ut.fornavn, ut.etternavn, ut.Fodselsdato, kb.klubbnavn FROM utovere ut JOIN register USING (utover_id) JOIN klubb kb USING (klubb_id) order by ut.etternavn";

            prepareStatement = db.prepareStatement(query);
            rs = prepareStatement.executeQuery();
            while (rs.next()) {
                UtoverClubModel utover = new UtoverClubModel(rs.getString("fornavn"), rs.getString("etternavn"), rs.getString("Fodselsdato"), rs.getString("klubbnavn"));
                toReturn.add(utover);
            }
            rs.close();


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


        return toReturn;
    }

    public static int velgUT(TestModell test, String navn, String id, PrintWriter p) {

        Connection db = null;
        PreparedStatement leggEksBruk = null;
        try {
            db = DbTool.getINSTANCE().dbLoggIn(p);

            String query = "INSERT INTO testregister (utover_id, test_year_id, 5000_watt, 5000_tid, 3000_sek, 3000_tid, 3000_lop_tid, 2000_watt, 2000_tid, 60_watt," +
                    "kropps_hev_stk, Sargeant_stk, beveg_stk, ligg_ro, ligg_ro_pst, ligg_ro_kg, kneboy_pst, kneboy_kg, totalscore) " +
                    "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";


            leggEksBruk = db.prepareStatement(query);
            leggEksBruk.setString(1, navn);
            leggEksBruk.setString(2, id);

            leggEksBruk.setInt(3, test.getFemtusen_watt());
            leggEksBruk.setInt(4, test.getFemtusen_tid());
            leggEksBruk.setInt(5, test.getTretusen_sek());
            leggEksBruk.setInt(6, test.getTretusen_tid());
            leggEksBruk.setInt(7, test.getTretusen_lop_tid());
            leggEksBruk.setInt(8, test.getTotusen_watt());
            leggEksBruk.setInt(9, test.getTotusen_tid());
            leggEksBruk.setInt(10, test.getSeksti_watt());
            leggEksBruk.setInt(11, test.getKropps_hev_stk());
            leggEksBruk.setInt(12, test.getSargeant_stk());
            leggEksBruk.setInt(13, test.getBeveg_stk());
            leggEksBruk.setInt(14, test.getLigg_ro());
            leggEksBruk.setInt(15, test.getLigg_ro_pst());
            leggEksBruk.setInt(16, test.getLigg_ro_kg());
            leggEksBruk.setInt(17, test.getKneboy_pst());
            leggEksBruk.setInt(18, test.getKneboy_kg());
            leggEksBruk.setInt(19, test.getTotalscore());


            //   String [] arrofquery = query.split(",");
            // StringBuilder builder = new StringBuilder();

            //  for (String q : arrofquery)
            //  if (q == (null )) {
            //     builder.append("NULL,");


            //   } else {
            //     builder.append(q + ",");
            //   }
            leggEksBruk.executeQuery();


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

        return 1;

    }


    public static int temp(UtoevereModel utoever, String tstid, String klubb, String gruppe, PrintWriter p) {
        Connection db = null;
        PreparedStatement insertToTest = null;

        try {
            db = DbTool.getINSTANCE().dbLoggIn(p);

            String tmp = "CREATE TABLE IF NOT EXISTS uttestreg " +
                    " SELECT  utover_id , fornavn, etternavn, fodselsdato, hoyde, vekt, " +
                    "test_year_id, `5000_watt`, `5000_tid`, `3000_sek`, `3000_tid`, `3000_lop_tid`, `2000_watt`, `2000_tid`, `60_watt`, kropps_hev_stk, sargeant_stk, beveg_stk, ligg_ro, ligg_ro_pst, ligg_ro_kg, kneboy_pst, kneboy_kg, totalscore, klubb_id, testgruppe_id, bruker_id  FROM utovere join testregister  using (utover_id) join register using (utover_id)" +
                    "  LIMIT 0;";

            String qu = "insert into uttestreg values (1,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,1)";

            insertToTest = db.prepareStatement(tmp);


            PreparedStatement test = db.prepareStatement(qu);


            test.setString(1, utoever.getFornavn());
            test.setString(2, utoever.getEtternavn());
            test.setString(3, utoever.getFodselsdato());
            test.setString(4, utoever.getHoyde());
            test.setString(5, utoever.getVekt());
            test.setString(6, tstid);
            test.setInt(7, utoever.getFemtusen_watt());
            test.setInt(8, utoever.getFemtusen_tid());
            test.setInt(9, utoever.getTretusen_sek());
            test.setInt(10, utoever.getTretusen_tid());
            test.setInt(11, utoever.getTretusen_lop_tid());
            test.setInt(12, utoever.getTotusen_watt());
            test.setInt(13, utoever.getTotusen_tid());
            test.setInt(14, utoever.getSeksti_watt());
            test.setInt(15, utoever.getKropps_hev_stk());
            test.setInt(16, utoever.getSargeant_stk());
            test.setInt(17, utoever.getBeveg_stk());
            test.setInt(18, utoever.getLigg_ro());
            test.setInt(19, utoever.getLigg_ro_pst());
            test.setInt(20, utoever.getLigg_ro_kg());
            test.setInt(21, utoever.getKneboy_pst());
            test.setInt(22, utoever.getKneboy_kg());
            test.setInt(23, utoever.getTotalscore());
            test.setString(24, klubb);
            test.setString(25, gruppe);


            insertToTest.executeQuery();
            test.execute();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return 1;
    }

    public static int testres(UtoevereModel utoever, String uutid, String tsstid, PrintWriter p) {
        Connection db = null;
        PreparedStatement insertToTest = null;

        try {
            db = DbTool.getINSTANCE().dbLoggIn(p);

            String tmp = "CREATE TABLE IF NOT EXISTS uttestreg " +
                    " SELECT utover_id, fornavn, etternavn, fodselsdato, hoyde, vekt, " +
                    "test_year_id, `5000_watt`, `5000_tid`, `3000_sek`, `3000_tid`, `3000_lop_tid`, `2000_watt`, `2000_tid`, `60_watt`, kropps_hev_stk, sargeant_stk, beveg_stk, ligg_ro, ligg_ro_pst, ligg_ro_kg, kneboy_pst, kneboy_kg, totalscore, klubb_id, testgruppe_id, bruker_id " +
                    " FROM utovere join testregister  using (utover_id) join register using (utover_id)" +
                    "  LIMIT 0;";

            String qu = "insert into uttestreg values (?,'a','a',1990,1,1,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,0,0,1)";

            insertToTest = db.prepareStatement(tmp);


            PreparedStatement test = db.prepareStatement(qu);

            test.setString(1, uutid);
            test.setString(2, tsstid);
            test.setInt(3, utoever.getFemtusen_watt());
            test.setInt(4, utoever.getFemtusen_tid());
            test.setInt(5, utoever.getTretusen_sek());
            test.setInt(6, utoever.getTretusen_tid());
            test.setInt(7, utoever.getTretusen_lop_tid());
            test.setInt(8, utoever.getTotusen_watt());
            test.setInt(9, utoever.getTotusen_tid());
            test.setInt(10, utoever.getSeksti_watt());
            test.setInt(11, utoever.getKropps_hev_stk());
            test.setInt(12, utoever.getSargeant_stk());
            test.setInt(13, utoever.getBeveg_stk());
            test.setInt(14, utoever.getLigg_ro());
            test.setInt(15, utoever.getLigg_ro_pst());
            test.setInt(16, utoever.getLigg_ro_kg());
            test.setInt(17, utoever.getKneboy_pst());
            test.setInt(18, utoever.getKneboy_kg());
            test.setInt(19, utoever.getTotalscore());


            insertToTest.executeQuery();
            test.execute();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return 1;
    }


    public static int bbbb(PrintWriter p) {

        Connection db = null;
        PreparedStatement leggEksBruk = null;

        try {
            db = DbTool.getINSTANCE().dbLoggIn(p);


            //where utover_id != 0; KAN FORTSATT FUNKE

            String query = "INSERT INTO testregister  " +
                    "SELECT 0, utover_id, test_year_id, 5000_watt, 5000_tid, 3000_sek, 3000_tid, 3000_lop_tid, 2000_watt, 2000_tid, 60_watt," +
                    "                    kropps_hev_stk, Sargeant_stk, beveg_stk, ligg_ro, ligg_ro_pst, ligg_ro_kg, kneboy_pst, kneboy_kg, totalscore " +
                    "FROM uttestreg " +
                    "WHERE utover_id != 0";


            String transquery = "BEGIN;";


            String query1 =
                    "INSERT INTO `utovere` " +
                            "SELECT 0, Fornavn, Etternavn, Fodselsdato, Hoyde, Vekt " +
                            "FROM uttestreg " +
                            "WHERE utover_id = 0";


            String query2 = "INSERT INTO testregister " +
                    "SELECT 0, (SELECT MAX(utover_id) FROM utovere), test_year_id, 5000_watt, 5000_tid, 3000_sek, 3000_tid, 3000_lop_tid, 2000_watt, 2000_tid, 60_watt, " +
                    "       kropps_hev_stk, Sargeant_stk, beveg_stk, ligg_ro, ligg_ro_pst, ligg_ro_kg, kneboy_pst, kneboy_kg, totalscore " +
                    "FROM uttestreg WHERE utover_id  = 0";


            String query3 = "INSERT INTO Register " +
                    " SELECT 0,(SELECT MAX(utover_id) FROM utovere),testgruppe_id,klubb_id, bruker_id " +
                    "FROM uttestreg " +
                    "where utover_id = 0";
            //

            String droppe = "Drop table uttestreg;";
            String query4 = "commit;";


            leggEksBruk = db.prepareStatement(query);


            PreparedStatement ssss = db.prepareStatement(query1);
            PreparedStatement insertNewTest = db.prepareStatement(query2);


            PreparedStatement insertNewReg = db.prepareStatement(query3);
            PreparedStatement start = db.prepareStatement(transquery);

            PreparedStatement drop = db.prepareStatement(droppe);
            PreparedStatement slutt = db.prepareStatement(query4);


            start.execute();
            leggEksBruk.execute();
            ssss.execute();
            insertNewTest.execute();
            insertNewReg.execute();
            drop.execute();
            slutt.execute();


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

        return 1;

    }
}