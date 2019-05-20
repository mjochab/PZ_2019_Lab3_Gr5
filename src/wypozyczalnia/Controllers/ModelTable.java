package wypozyczalnia.Controllers;

public class ModelTable {

    String imie;
    String nazwisko;
    String login;
    String haslo;
    String data_urodzenia;
    String miejscowosc;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmial() {
        return emial;
    }

    public void setEmial(String emial) {
        this.emial = emial;
    }

    public String getRodzaj() {
        return rodzaj;
    }

    public void setRodzaj(String rodzaj) {
        this.rodzaj = rodzaj;
    }

    String pesel;
    String tel;
    String emial;
    String rodzaj;

    public ModelTable(String imie, String nazwisko, String data_urodzenia, String miejscowosc, String pesel, String tel, String login, String haslo, String rodzaj, String emial)
    {
        this.imie=imie;
        this.nazwisko=nazwisko;
        this.data_urodzenia=data_urodzenia;
        this.miejscowosc=miejscowosc;
        this.pesel=pesel;
        this.login=login;
        this.haslo=haslo;
        this.emial=emial;
        this.rodzaj=rodzaj;
        this.tel=tel;
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
