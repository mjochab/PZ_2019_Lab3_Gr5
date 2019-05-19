package wypozyczalnia.Controllers;

public class ModelTableWypozyczenie {

    String marka;
    String model;
    String data_poczatkowa;
    String data_koncowa;
    String pesel;
    double cena;

    public ModelTableWypozyczenie(String pesel, String marka, String model, String data_poczatkowa, String data_koncowa, double cena)
    {
        this.pesel=pesel;
        this.marka=marka;
        this.model=model;
        this.data_poczatkowa=data_poczatkowa;
        this.data_koncowa=data_koncowa;
        this.cena=cena;

    }

    public String getPesel() { return pesel; }

    public void setPesel(String pesel) {
        this.pesel = pesel;
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

    public String getData_poczatkowa() {
        return data_poczatkowa;
    }

    public void setData_poczatkowa(String data_poczatkowa) {
        this.data_poczatkowa = data_poczatkowa;
    }
    public String getData_koncowa() {
        return data_poczatkowa;
    }

    public void setData_koncowa(String data_koncowa) {
        this.data_koncowa = data_koncowa;
    }
    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }




}
