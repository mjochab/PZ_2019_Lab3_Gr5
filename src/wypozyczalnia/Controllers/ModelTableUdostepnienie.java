package wypozyczalnia.Controllers;

public class ModelTableUdostepnienie {

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

    public String getDatado() {
        return datado;
    }

    public void setDatado(String datado) {
        this.datado = datado;
    }

    public String getDataod() {
        return dataod;
    }

    public void setDataod(String dataod) {
        this.dataod = dataod;
    }

    public ModelTableUdostepnienie(String marka, String model, String rodzaj, String rocznik,String paliwo, String przebieg, String cena, String dataod, String datado) {
        this.marka = marka;
        this.model = model;
        this.rodzaj = rodzaj;
        this.rocznik = rocznik;
        this.paliwo = paliwo;
        this.przebieg = przebieg;
        this.cena = cena;
        this.dataod = dataod;
        this.datado = datado;
    }

    public String getRocznik() {
        return rocznik;
    }

    public void setRocznik(String rocznik) {
        this.rocznik = rocznik;
    }

    String marka,model,rodzaj,paliwo,przebieg,cena, rocznik, dataod, datado;

}
