package wypozyczalnia.Controllers;

public class ModelTableWypPoj {

    public String getId() {
        return id;
    }

    public void setid(String id) {
        this.marka = id;
    }

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

    public String getRodzaj() { return rodzaj; }

    public void setRodzaj(String rodzaj) { this.rodzaj = rodzaj; }

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

    public String getDostepnosc() {
        return dostepnosc;
    }

    public void setDostepnosc(String dostepnosc) {
        this.dostepnosc = dostepnosc;
    }

    public ModelTableWypPoj(String id, String marka, String model, String rodzaj, String rocznik,String paliwo, String przebieg, String cena, String dostepnosc) {
        this.id = id;
        this.marka = marka;
        this.model = model;
        this.rodzaj = rodzaj;
        this.rocznik = rocznik;
        this.paliwo = paliwo;
        this.przebieg = przebieg;
        this.cena = cena;
        this.dostepnosc = dostepnosc;
    }

    public String getRocznik() {
        return rocznik;
    }

    public void setRocznik(String rocznik) {
        this.rocznik = rocznik;
    }

    String id, marka,model,rodzaj,paliwo,przebieg,cena, dostepnosc, rocznik;

}
