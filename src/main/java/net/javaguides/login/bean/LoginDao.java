package net.javaguides.login.bean;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.javaguides.login.bean.LoginBean;
/**
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
 */

public class LoginDao {

    public boolean validate(LoginBean loginBean, PrintWriter p) throws ClassNotFoundException {
        boolean status = false;

        Class.forName("org.mariadb.jdbc.MySQLDataSource");

        Connection db = null;
        PreparedStatement Log = null;
        try {
            db = DbTool.getINSTANCE().dbLoggIn(p);
                //(Connection connection = DriverManager
                //.getConnection("jdbc:mariadb://localhost:3308?useSSL=false", "root", "12345");

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection
                     .prepareStatement("select * from Brukerinfo where Brukernavn = ? and Passord = ? ")) {
            preparedStatement.setString(1, loginBean.getBrukernavn());
            preparedStatement.setString(2, loginBean.getPassord());

            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            status = rs.next();

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return status;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}