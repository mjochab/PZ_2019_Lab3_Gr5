package wypozyczalnia.Controllers;

public class ModelTableWypozyczenia {


    String wypozyczenie_id;
    String user_id;
    String samochod_id;
    String data_od;
    String data_do;

    public String getWypozyczenie_id() {
        return wypozyczenie_id;
    }

    public void setWypozyczenie_id(String wypozyczenie_id) {
        this.wypozyczenie_id = wypozyczenie_id;
    }

    public String getUser_id() {
        return wypozyczenie_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getSamochod_id() {
        return samochod_id;
    }

    public void setSamochod_id(String samochod_id) {
        this.samochod_id = samochod_id;
    }

    public String getData_od() {
        return data_od;
    }

    public void setData_od(String data_od) {
            this.data_do = data_od;
    }

    public String getData_do() {
        return data_do;
    }

    public void setData_do(String data_do) {
        this.data_do = data_do;
    }



    public ModelTableWypozyczenia(String wypozyczenie_id, String user_id, String samochod_id, String data_od, String data_do)
    {
        this.wypozyczenie_id=wypozyczenie_id;
        this.user_id=user_id;
        this.samochod_id=samochod_id;
        this.data_do=data_do;
        this.data_od=data_do;


    }



}
