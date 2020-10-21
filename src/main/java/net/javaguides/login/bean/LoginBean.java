package net.javaguides.login.bean;

import java.io.Serializable;

public class LoginBean implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String brukernavn;
    private String passord;

    public String getBrukernavn() {
        return brukernavn;
    }

   public void setBrukernavn(String brukernavn) {
        this.brukernavn = brukernavn;
    }

    public String getPassord() {
        return passord;
    }

    public void setPassord(String passord) {
        this.passord = passord;
    }

}