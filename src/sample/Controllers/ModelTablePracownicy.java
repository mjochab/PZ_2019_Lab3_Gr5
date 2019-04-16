package sample.Controllers;

public class ModelTablePracownicy {
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public ModelTablePracownicy(String imie, String nazwisko, String login, String pesel) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.login = login;
        this.pesel = pesel;
    }

    String imie,nazwisko,login,pesel;
}
