package wypozyczalnia.Controllers;

public class ModelTable {

    String imie;
    String nazwisko;
    String login;
    String data_urodzenia;
    String miejscowosc;
    String haslo;
    String pesel;
    String telefon;
    String email;

    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }

    public String getTelefon() {
        return telefon;
    }
    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getEmail() {
        return email;
    }
    public void setEmial(String email) {
        this.email = email;
    }

    public String getPesel() { return pesel; }
    public void setPesel(String pesel) {
        this.pesel = pesel;
    }



    public ModelTable(String login, String haslo, String imie,  String nazwisko, String data_urodzenia, String miejscowosc, String pesel,  String telefon,  String email)
    {
        this.imie=imie;
        this.nazwisko=nazwisko;
        this.data_urodzenia=data_urodzenia;
        this.miejscowosc=miejscowosc;
        this.pesel=pesel;
        this.login=login;
        this.haslo = haslo;
        this.email=email;
        this.telefon=telefon;

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

    public String getHaslo() {return haslo;}
    public void setHaslo(String haslo) {this.haslo = haslo;}


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


}
