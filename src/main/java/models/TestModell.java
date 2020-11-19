package models;

public class TestModell {

    private int femtusen_watt;
    private int femtusen_tid;
    private int tretusen_sek;
    private int tretusen_tid;
    private int tretusen_lop_tid;
    private int totusen_watt;
    private int totusen_tid;
    private int seksti_watt;
    private int kropps_hev_stk;
    private int Sargeant_stk;
    private int beveg_stk;
    private int ligg_ro;
    private int ligg_ro_pst;
    private int ligg_ro_kg;
    private int kneboy_pst;
    private int kneboy_kg;
    private int totalscore;


    public TestModell(String femtusen_watt, String femtusen_tid, String tretusen_sek, String tretusen_tid, String tretusen_lop_tid, String totusen_watt, String totusen_tid, String seksti_watt,
                         String kropps_hev_stk, String Sargeant_stk, String beveg_stk, String ligg_ro, String ligg_ro_pst, String ligg_ro_kg, String kneboy_pst, String kneboy_kg, String totalscore ) {

        this.femtusen_watt = femtusen_watt.isEmpty() ? 0 : Integer.parseInt(femtusen_watt);

        this.femtusen_tid = femtusen_tid.isEmpty()  ? 0 : Integer.parseInt(femtusen_tid);
        this.tretusen_sek = tretusen_sek.isEmpty() ? 0 : Integer.parseInt(tretusen_sek);
        this.tretusen_tid = tretusen_tid.isEmpty() ? 0 : Integer.parseInt(tretusen_tid);
        this.tretusen_lop_tid = tretusen_lop_tid.isEmpty()? 0 : Integer.parseInt(tretusen_lop_tid);
        this.totusen_watt = totusen_watt.isEmpty() ? 0 : Integer.parseInt(totusen_watt);
        this.totusen_tid = totusen_tid.isEmpty() ? 0 : Integer.parseInt(totusen_tid);
        this.seksti_watt = seksti_watt.isEmpty() ? 0 : Integer.parseInt(seksti_watt);
        this.kropps_hev_stk = kropps_hev_stk.isEmpty() ? 0 : Integer.parseInt(kropps_hev_stk);
        this.Sargeant_stk = Sargeant_stk.isEmpty() ? 0 : Integer.parseInt(Sargeant_stk);
        this.beveg_stk = beveg_stk.isEmpty() ? 0 : Integer.parseInt(beveg_stk);
        this.ligg_ro = ligg_ro.isEmpty() ? 0 : Integer.parseInt(ligg_ro);
        this.ligg_ro_pst = ligg_ro_pst.isEmpty() ? 0 : Integer.parseInt(ligg_ro_pst);
        this.ligg_ro_kg = ligg_ro_kg.isEmpty() ? 0 : Integer.parseInt(ligg_ro_kg);
        this.kneboy_pst = kneboy_pst.isEmpty() ? 0 : Integer.parseInt(kneboy_pst);
        this.kneboy_kg = kneboy_kg.isEmpty()? 0 : Integer.parseInt(kneboy_kg);
        this.totalscore = totalscore.isEmpty() ? 0 : Integer.parseInt(totalscore);

    }


    public int getFemtusen_watt() {
        return femtusen_watt;
    }

    public void setFemtusen_watt(int femtusen_watt) {
        this.femtusen_watt = femtusen_watt;
    }

    public int getFemtusen_tid() {
        return femtusen_tid;
    }

    public void setFemtusen_tid(int femtusen_tid) {
        this.femtusen_tid = femtusen_tid;
    }

    public int getTretusen_sek() {
        return tretusen_sek;
    }

    public void setTretusen_sek(int tretusen_sek) {
        this.tretusen_sek = tretusen_sek;
    }

    public int getTretusen_tid() {
        return tretusen_tid;
    }

    public void setTretusen_tid(int tretusen_tid) {
        this.tretusen_tid = tretusen_tid;
    }

    public int getTretusen_lop_tid() {
        return tretusen_lop_tid;
    }

    public void setTretusen_lop_tid(int tretusen_lop_tid) {
        this.tretusen_lop_tid = tretusen_lop_tid;
    }

    public int getTotusen_watt() {
        return totusen_watt;
    }

    public void setTotusen_watt(int totusen_watt) {
        this.totusen_watt = totusen_watt;
    }

    public int getTotusen_tid() {
        return totusen_tid;
    }

    public void setTotusen_tid(int totusen_tid) {
        this.totusen_tid = totusen_tid;
    }

    public int getSeksti_watt() {
        return seksti_watt;
    }

    public void setSeksti_watt(int seksti_watt) {
        this.seksti_watt = seksti_watt;
    }

    public int getKropps_hev_stk() {
        return kropps_hev_stk;
    }

    public void setKropps_hev_stk(int kropps_hev_stk) {
        this.kropps_hev_stk = kropps_hev_stk;
    }

    public int getSargeant_stk() {
        return Sargeant_stk;
    }

    public void setSargeant_stk(int sargeant_stk) {
        Sargeant_stk = sargeant_stk;
    }

    public int getBeveg_stk() {
        return beveg_stk;
    }

    public void setBeveg_stk(int beveg_stk) {
        this.beveg_stk = beveg_stk;
    }

    public int getLigg_ro() {
        return ligg_ro;
    }

    public void setLigg_ro(int ligg_ro) {
        this.ligg_ro = ligg_ro;
    }
    public int getLigg_ro_pst() {
        return ligg_ro_pst;
    }

    public void setLigg_ro_pst(int ligg_ro_pst) {
        this.ligg_ro_pst = ligg_ro_pst;
    }
    public int getLigg_ro_kg() {
        return ligg_ro_kg;
    }

    public void setLigg_ro_kg(int ligg_ro_kg) {
        this.ligg_ro_kg = ligg_ro_kg;
    }

    public int getKneboy_pst() {
        return kneboy_pst;
    }

    public void setKneboy_pst(int kneboy_pst) {
        this.kneboy_pst = kneboy_pst;
    }

    public int getKneboy_kg() {
        return kneboy_kg;
    }

    public void setKneboy_kg(int kneboy_kg) {
        this.kneboy_kg = kneboy_kg;
    }

    public int getTotalscore() {
        return totalscore;
    }

    public void setTotalscore(int totalscore) {
        this.totalscore = totalscore;
    }
}
