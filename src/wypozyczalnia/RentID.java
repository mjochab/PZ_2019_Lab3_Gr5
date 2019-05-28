package wypozyczalnia;

public final class RentID {

    private static RentID instance;
    private static int samochod_id;


    private RentID(int samochod_id) {

        this.samochod_id = samochod_id;
    }

    public static RentID getInstance(int samochod_id) {
        if(instance == null) {
            instance = new RentID(samochod_id);
        }
        return instance;
    }

    public static int getSamochod_id() {return samochod_id;}



    public static void cleanUserSession() {

        samochod_id = 0;
    }


}
