package tools.repository;

import models.Klubbmodell;
import models.UserModel;
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
    public static int Registrer(String Brukernavn, String passord, String id,   PrintWriter p) {
        Connection db = null;
        PreparedStatement insertNewBrukerinfo = null;
        try {
            db = DbTool.getINSTANCE().dbLoggIn(p);
            String query =


                                   "INSERT INTO Brukerinfo (Email, Passord) VALUES(?, ?)";


            String query2 =    "INSERT INTO Bruker (Brukerinfo_id, rolle_id) VALUES( (SELECT MAX (brukerinfo_id) FROM Brukerinfo), ?)";






            insertNewBrukerinfo = db.prepareStatement(query);
            insertNewBrukerinfo.setString(1, Brukernavn);
            insertNewBrukerinfo.setString(2, passord);


           PreparedStatement insertNewBruker = db.prepareStatement(query2);

            insertNewBruker.setString(1, id);
            insertNewBrukerinfo.execute();
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

    public static List<UserModel> getUserName(PrintWriter p) {
        Connection db = null;
        PreparedStatement prepareStatement = null;

        List<UserModel> toReturn = new ArrayList<>();
        try {
            db = DbTool.getINSTANCE().dbLoggIn(p);
            ResultSet rs = null;
            String query = "SELECT Email, Rolletype FROM Brukerinfo JOIN roller ON rolle_id";
            prepareStatement = db.prepareStatement(query);
            rs = prepareStatement.executeQuery();
            while (rs.next()) {
                UserModel user = new UserModel(rs.getString("firstName"), rs.getString("lastName"), rs.getString("userName"), rs.getString("password"));
                toReturn.add(user);
            }
            rs.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return toReturn;
    }


}

