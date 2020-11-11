package models;

import java.time.Year;

public class UtoverClubModel {

    private String firstName;
    private String lastName;
    private String Club;
    private String aar;


    /**
     * @param firstName the users firstname
     * @param lastName  the users lastname
     **/

    public UtoverClubModel(String firstName, String lastName, String aar, String Club) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.Club = Club;
        this.aar = aar;

    }

    /**
     * GETTERS AND SETTERS!
     */
    public String getfirstName() {
        return firstName;
    }

    public void setfirstName(String firstName) {
        firstName = firstName;
    }

    public String getlastName() {
        return lastName;
    }

    public void setlastName(String lastName) {
        lastName = lastName;
    }

    public String getClub() {
        return Club;
    }

    public void setClub(String Club) {
        Club = Club;
    }

    public String getAar() {
        return aar;
    }

    public void setAar(String aar) {
        this.aar = aar;
    }
}


