package wypozyczalnia.Controllers;

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

    public String getPesel() { return pesel; }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getData() {
        return data_urodzenia;
    }

    public void setData(String data_urodzenia) {
        this.data_urodzenia = data_urodzenia;
    }

    public String getMiejscowosc() {
        return miejscowosc;
    }

    public void setMiejscowosc(String miejscowosc) { this.miejscowosc = miejscowosc; }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email= email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon= telefon;
    }

    public ModelTablePracownicy(String imie, String nazwisko, String login, String pesel, String data_urodzenia, String miejscowosc, String email, String telefon) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.login = login;
        this.pesel = pesel;
        this.data_urodzenia = data_urodzenia;
        this.miejscowosc = miejscowosc;
        this.email = email;
        this.telefon = telefon;

    }

    String imie,nazwisko,login,data_urodzenia, miejscowosc, email, telefon, pesel;
}
