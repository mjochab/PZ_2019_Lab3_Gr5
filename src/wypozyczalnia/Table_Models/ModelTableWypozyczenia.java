package wypozyczalnia.Table_Models;

public class ModelTableWypozyczenia {

    String  marka, model, odkiedy, dokiedy, cena;

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
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

    public String getCena() {
        return cena;
    }

    public void setCena(String cena) {
        this.cena = cena;
    }

    public ModelTableWypozyczenia(String marka, String model, String odkiedy, String dokiedy, String cena) {
        this.marka = marka;
        this.model = model;
        this.odkiedy = odkiedy;
        this.dokiedy = dokiedy;
        this.cena = cena;
    }
}