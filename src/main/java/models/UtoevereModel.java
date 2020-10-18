package models;

public class UtoevereModel {
    private String fornavn;
    private String etternavn;
    private String fodselsdato;
    private String hoyde;
    private String vekt;



    /**
     * @param fornavn   the users firstname
     * @param etternavn the users lastname
     * @param vekt      the users email .e.g., example@example.com
     */
    public UtoevereModel(String fornavn, String etternavn, String fodselsdato, String hoyde, String vekt) {
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.fodselsdato = fodselsdato;
        this.hoyde = hoyde;
        this.vekt = vekt;

    }

    public String getFornavn() {
        return fornavn;
    }

    public String getEtternavn() {
        return etternavn;
    }


    public String getFodselsdato() {
        return fodselsdato;
    }


    public String getHoyde() {
        return hoyde;
    }


    public String getVekt() {
        return vekt;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public void setEtternavn(String etternavn) {
        this.etternavn = etternavn;
    }

    public void setFodselsdato(String fodselsdato) {
        this.fodselsdato = fodselsdato;
    }
    public void setHoyde(String hoyde) {
        this.hoyde = hoyde;
    }

    public void setVekt(String vekt) {
        this.vekt = vekt;
    }

}