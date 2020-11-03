package models;

public class UtoevereModel {
    private String fornavn;
    private String etternavn;
    private String fodselsdato;
    private String hoyde;
    private String vekt;
    private String femtusen_watt;
    private String femtusen_tid;
    private String tretusen_sek;
    private String tretusen_tid;
    private String tretusen_lop_tid;
    private String totusen_watt;
    private String totusen_tid;
    private String seksti_watt;
    private String kropps_hev_stk;
    private String Sargeant_stk;
    private String beveg_stk;
    private String ligg_ro;
    private String ligg_ro_pst;
    private String ligg_ro_kg;
    private String kneboy_pst;
    private String kneboy_kg;
    private String totalscore;


    /**
     * @param fornavn   the users firstname
     * @param etternavn the users lastname
     * @param vekt      the users email .e.g., example@example.com
     */
    public UtoevereModel(String fornavn, String etternavn, String fodselsdato, String hoyde, String vekt,String femtusen_watt, String femtusen_tid, String tretusen_sek, String tretusen_tid, String tretusen_lop_tid, String totusen_watt, String totusen_tid, String seksti_watt,
                         String kropps_hev_stk, String Sargeant_stk, String beveg_stk, String ligg_ro, String ligg_ro_pst, String ligg_ro_kg, String kneboy_pst, String kneboy_kg, String totalscore ) {
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.fodselsdato = fodselsdato;
        this.hoyde = hoyde;
        this.vekt = vekt;
        this.femtusen_watt = femtusen_watt;
        this.femtusen_tid = femtusen_tid;
        this.tretusen_sek = tretusen_sek;
        this.tretusen_tid = tretusen_tid;
        this.tretusen_lop_tid = tretusen_lop_tid;
        this.totusen_watt = totusen_watt;
        this.totusen_tid = totusen_tid;
        this.seksti_watt = seksti_watt;
        this.kropps_hev_stk = kropps_hev_stk;
        this.Sargeant_stk = Sargeant_stk;
        this.beveg_stk = beveg_stk;
        this.ligg_ro = ligg_ro;
        this.ligg_ro_pst = ligg_ro_pst;
        this.ligg_ro_kg = ligg_ro_kg;
        this.kneboy_pst = kneboy_pst;
        this.kneboy_kg = kneboy_kg;
        this.totalscore = totalscore;

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

    public String getFemtusen_watt() {
        return femtusen_watt;
    }

    public void setFemtusen_watt(String femtusen_watt) {
        this.femtusen_watt = femtusen_watt;
    }

    public String getFemtusen_tid() {
        return femtusen_tid;
    }

    public void setFemtusen_tid(String femtusen_tid) {
        this.femtusen_tid = femtusen_tid;
    }

    public String getTretusen_sek() {
        return tretusen_sek;
    }

    public void setTretusen_sek(String tretusen_sek) {
        this.tretusen_sek = tretusen_sek;
    }

    public String getTretusen_tid() {
        return tretusen_tid;
    }

    public void setTretusen_tid(String tretusen_tid) {
        this.tretusen_tid = tretusen_tid;
    }

    public String getTretusen_lop_tid() {
        return tretusen_lop_tid;
    }

    public void setTretusen_lop_tid(String tretusen_lop_tid) {
        this.tretusen_lop_tid = tretusen_lop_tid;
    }

    public String getTotusen_watt() {
        return totusen_watt;
    }

    public void setTotusen_watt(String totusen_watt) {
        this.totusen_watt = totusen_watt;
    }

    public String getTotusen_tid() {
        return totusen_tid;
    }

    public void setTotusen_tid(String totusen_tid) {
        this.totusen_tid = totusen_tid;
    }

    public String getSeksti_watt() {
        return seksti_watt;
    }

    public void setSeksti_watt(String seksti_watt) {
        this.seksti_watt = seksti_watt;
    }

    public String getKropps_hev_stk() {
        return kropps_hev_stk;
    }

    public void setKropps_hev_stk(String kropps_hev_stk) {
        this.kropps_hev_stk = kropps_hev_stk;
    }

    public String getSargeant_stk() {
        return Sargeant_stk;
    }

    public void setSargeant_stk(String sargeant_stk) {
        Sargeant_stk = sargeant_stk;
    }

    public String getBeveg_stk() {
        return beveg_stk;
    }

    public void setBeveg_stk(String beveg_stk) {
        this.beveg_stk = beveg_stk;
    }

    public String getLigg_ro() {
        return ligg_ro;
    }

    public void setLigg_ro(String ligg_ro) {
        this.ligg_ro = ligg_ro;
    }
    public String getLigg_ro_pst() {
        return ligg_ro_pst;
    }

    public void setLigg_ro_pst(String ligg_ro_pst) {
        this.ligg_ro_pst = ligg_ro_pst;
    }
    public String getLigg_ro_kg() {
        return ligg_ro_kg;
    }

    public void setLigg_ro_kg(String ligg_ro_kg) {
        this.ligg_ro_kg = ligg_ro_kg;
    }

    public String getKneboy_pst() {
        return kneboy_pst;
    }

    public void setKneboy_pst(String kneboy_pst) {
        this.kneboy_pst = kneboy_pst;
    }

    public String getKneboy_kg() {
        return kneboy_kg;
    }

    public void setKneboy_kg(String kneboy_kg) {
        this.kneboy_kg = kneboy_kg;
    }

    public String getTotalscore() {
        return totalscore;
    }

    public void setTotalscore(String totalscore) {
        this.totalscore = totalscore;
    }
}
