package tools.repository;

import models.UserModel;
import models.UtoevereModel;
import tools.DbTool;

import javax.validation.constraints.Email;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoginRepo {

    /**
     Legger til en bruker i databasen
     @param Brukernavn  objekt som inneholder all informasjon om brukernavnet.
     @param passord objekt som inneholder all informasjon om passordet til brukeren..
     @param p printwriter for å skrive ut html i servlet. F.eks SQL feilmeldinger eller annen info.
     **/
    public static int Registrer(String Brukernavn, String passord,   PrintWriter p) {
        Connection db = null;
        PreparedStatement insertNewBrukerinfo = null;
        try {
            db = DbTool.getINSTANCE().dbLoggIn(p);
            String begynn = "BEGIN;";

            String query =


                    "INSERT INTO Brukerinfo (Email, Passord) VALUES(?, ?)";


            String query2 =    "INSERT INTO Bruker (Brukerinfo_id, rolle_id) VALUES( (SELECT MAX (brukerinfo_id) FROM Brukerinfo), 1)";



            String query3 = "COMMIT;";


            insertNewBrukerinfo = db.prepareStatement(query);
            insertNewBrukerinfo.setString(1, Brukernavn);
            insertNewBrukerinfo.setString(2, passord);


            PreparedStatement insertNewBruker = db.prepareStatement(query2);



            PreparedStatement begi = db.prepareStatement(begynn);
            PreparedStatement slutt = db.prepareStatement(query3);

            begi.execute();
            insertNewBrukerinfo.execute();
            insertNewBruker.execute();
            slutt.execute();

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

    public static void addTrener(String br, String ps, String klobb,  PrintWriter p) {

        Connection db = null;
        PreparedStatement addtr = null;
        try {
            db = DbTool.getINSTANCE().dbLoggIn(p);

            String begquery = "BEGIN;";

            String query=   "INSERT INTO Brukerinfo (Email, Passord) VALUES(?, ?)";

            String query2 =    "INSERT INTO Bruker (Brukerinfo_id, rolle_id) VALUES( (SELECT MAX (brukerinfo_id) FROM Brukerinfo), 2)";

            String query3 = "INSERT INTO BrukerKlubb (bruker_id, klubb_id) VALUES ((SELECT MAX (bruker_id) FROM Bruker JOIN roller USING (rolle_id) WHERE rolle_id = 2) , ?)";

            String query4= "COMMIT;";

            addtr = db.prepareStatement(query);
            addtr.setString(1, br);
            addtr.setString(2, ps);


            PreparedStatement insBruker = db.prepareStatement(query2);



            PreparedStatement insBKR = db.prepareStatement(query3);
            insBKR.setString(1,klobb );


            PreparedStatement beg = db.prepareStatement(begquery);
            PreparedStatement end = db.prepareStatement(query4);



            beg.execute();
            addtr.execute();
            insBruker.execute();
            insBKR.execute();
            end.execute();



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
//
        // Klubb og tilkoblede trenere (Admin) visKlubbOgTrenere.jsp  /////
        //

    }

    public static List<UserModel> visBrukere(PrintWriter p) {
        Connection db = null;
        PreparedStatement prepareStatement = null;

        List<UserModel> toReturn = new ArrayList<>();
        try {
            db = DbTool.getINSTANCE().dbLoggIn(p);
            ResultSet rs = null;
            String query = "SELECT bi.Email, kb.Klubbnavn FROM Brukerinfo bi JOIN bruker USING (brukerinfo_id) JOIN BrukerKlubb USING(bruker_id) JOIN klubb kb USING(klubb_id)";

            prepareStatement = db.prepareStatement(query);
            rs = prepareStatement.executeQuery();
            while (rs.next()) {
                UserModel bruker = new UserModel(rs.getString("Email"), rs.getString("Klubbnavn"));
                toReturn.add(bruker);
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

}
