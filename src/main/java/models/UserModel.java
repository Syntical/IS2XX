package models;

public class UserModel {

    private String Email;
    private String Klubbnavn;


    /**
     *
     * @param Email the users firstname
     * @param Klubbnavn the users lastname
     **/

    public UserModel(String Email, String Klubbnavn) {

        this.Email = Email;
        this.Klubbnavn = Klubbnavn;

    }

    /**
     *
     * GETTERS AND SETTERS!
     */
    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getKlubbnavn() {
        return Klubbnavn;
    }

    public void setKlubbnavn(String klubbnavn) {
        Klubbnavn = klubbnavn;
    }


}
