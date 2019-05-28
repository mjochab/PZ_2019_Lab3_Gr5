package wypozyczalnia;

public final class RentCar {

    private static RentCar instance;
    private static int samochod_id;
    private static String data_od;
    private static String data_do;
    private static int wypozyczenie_id;

    private RentCar(String data_do, String data_od, int wypozyczenie_id, int samochod_id) {
        this.data_do = data_do;
        this.data_od = data_od;
        this.wypozyczenie_id = wypozyczenie_id;
        this.samochod_id = samochod_id;
    }

    public static RentCar getInstance(String data_do, String data_od, int wypozyczenie_id, int user_id, int samochod_id) {
        if(instance == null) {
            instance = new RentCar(data_do, data_od, wypozyczenie_id, samochod_id);
        }
        return instance;
    }


    public static String getData_od() {
        return data_od;
    }

    public static String getData_do() {
        return data_do;
    }

    public static int getWypozyczenie_id() {
        return wypozyczenie_id;
    }

    public static int getSamochod_id() {return samochod_id;}




    public static void cleanRentCar() {
        data_do = "";
        data_od = "";
        samochod_id = 0;
        wypozyczenie_id = 0;
    }

}
