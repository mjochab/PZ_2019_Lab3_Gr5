package wypozyczalnia.Table_Models;

public class ModelTableWypozyczenia {

    String user_id, samochod_id, odkiedy, dokiedy, wypozyczenie_id;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getSamochod_id() {
        return samochod_id;
    }

    public void setSamochod_id(String samochod_id) {
        this.samochod_id = samochod_id;
    }

    public String getOdkiedy() {
        return odkiedy;
    }

    public void setOdkiedy(String odkiedy) {
        this.odkiedy = odkiedy;
    }

    public String getDokiedy() {
        return dokiedy;
    }

    public void setDokiedy(String dokiedy) {
        this.dokiedy = dokiedy;
    }

    public String getWypozyczenie_id() {
        return wypozyczenie_id;
    }

    public void setWypozyczenie_id(String wypozyczenie_id) {
        this.wypozyczenie_id = wypozyczenie_id;
    }

    public ModelTableWypozyczenia(String user_id, String samochod_id, String odkiedy, String dokiedy, String wypozyczenie_id) {
        this.user_id = user_id;
        this.samochod_id = samochod_id;
        this.odkiedy = odkiedy;
        this.dokiedy = dokiedy;
        this.wypozyczenie_id = wypozyczenie_id;
    }
}