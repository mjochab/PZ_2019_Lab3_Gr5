package wypozyczalnia.Controllers;

public class ModelTableWypozyczenie {

    String imie;
    String nazwisko;
    String data_poczatkowa;
    String data_koncowa;
    String cena;


    public ModelTableWypozyczenie(String imie, String nazwisko, String data_poczatkowa, String data_koncowa, String cena)
    {
        this.imie=imie;
        this.nazwisko=nazwisko;
        this.data_poczatkowa=data_poczatkowa;
        this.data_koncowa=data_koncowa;
        this.cena = cena;

    }

    public String getImie() { return imie; }

    public void setImie(String pesel) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String marka) {
        this.nazwisko = marka;
    }

    public String getData_poczatkowa() {
        return data_poczatkowa;
    }

    public void setData_poczatkowa(String data_poczatkowa) {
        this.data_poczatkowa = data_poczatkowa;
    }

    public String getData_koncowa() {
        return data_koncowa;
    }

    public void setData_koncowa(String data_koncowa) {
        this.data_koncowa = data_koncowa;
    }

    public String getCena() {
        return cena;
    }

    public void setCena(String cena) {
        this.cena = cena;
    }



}
