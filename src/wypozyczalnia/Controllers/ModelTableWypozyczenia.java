package wypozyczalnia.Controllers;

public class ModelTableWypozyczenia {


    String marka;
    String model;
    String data_od;
    String data_do;
    String cena;
    String user_id;


    public String getMarka() {
        return marka;
    }

    public void setMarka(String wypozyczenie_id) {
        this.marka = marka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
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

    public String getCena() {
        return cena;
    }

    public void setCena(String cena) {
        this.cena = cena;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }




    public ModelTableWypozyczenia(    String marka, String model, String data_od, String data_do, String cena, String user_id)
    {
        this.marka=marka;
        this.model=model;
        this.data_od=data_od;
        this.data_do=data_do;
        this.cena=cena;
        this.user_id=user_id;


    }



}
