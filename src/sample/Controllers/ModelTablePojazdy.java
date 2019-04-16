package sample.Controllers;

public class ModelTablePojazdy {

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

    public String getRodzaj() {
        return rodzaj;
    }

    public void setRodzaj(String rodzaj) {
        this.rodzaj = rodzaj;
    }

    public String getPaliwo() {
        return paliwo;
    }

    public void setPaliwo(String paliwo) {
        this.paliwo = paliwo;
    }

    public String getPrzebieg() {
        return przebieg;
    }

    public void setPrzebieg(String przebieg) {
        this.przebieg = przebieg;
    }

    public String getCena() {
        return cena;
    }

    public void setCena(String cena) {
        this.cena = cena;
    }

    public ModelTablePojazdy(String marka, String model, String rodzaj, String paliwo, String przebieg, String cena) {
        this.marka = marka;
        this.model = model;
        this.rodzaj = rodzaj;
        this.paliwo = paliwo;
        this.przebieg = przebieg;
        this.cena = cena;
    }

    String marka,model,rodzaj,paliwo,przebieg,cena;

}
