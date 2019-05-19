package wypozyczalnia.Table_Models;

public class ModelTable {

    String imie;
    String nazwisko;
    String data_urodzenia;
    String miejscowosc;
    String pesel;

    public ModelTable(String imie, String nazwisko, String data_urodzenia, String miejscowosc, String pesel)
    {
        this.imie=imie;
        this.nazwisko=nazwisko;
        this.data_urodzenia=data_urodzenia;
        this.miejscowosc=miejscowosc;
        this.pesel=pesel;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getData_urodzenia() {
        return data_urodzenia;
    }

    public void setData_urodzenia(String data_urodzenia) {
        this.data_urodzenia = data_urodzenia;
    }

    public String getMiejscowosc() {
        return miejscowosc;
    }

    public void setMiejscowosc(String miejscowosc) {
        this.miejscowosc = miejscowosc;
    }

    public String getPesel() { return pesel; }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }


}
