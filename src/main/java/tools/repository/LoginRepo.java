package tools.repository;

import tools.DbTool;

import javax.validation.constraints.Email;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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





           // String query3 = "START TRANSACTION;" + query + query2 + "COMMIT;";

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
}
