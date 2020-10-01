package models;

public class UtoevereModel {
    private String fornavn;
    private String etternavn;
    private String vekt;


    /**
     * @param fornavn   the users firstname
     * @param etternavn the users lastname
     * @param vekt      the users email .e.g., example@example.com
     */
    public UtoevereModel(String fornavn, String etternavn, String vekt) {
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.vekt = vekt;
    }

    public String getFornavn() {
        return fornavn;
    }

    public String getEtternavn() {
        return etternavn;
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

    public void setVekt(String vekt) {
        this.vekt = vekt;
    }

}