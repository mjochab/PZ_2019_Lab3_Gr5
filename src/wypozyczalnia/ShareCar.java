package wypozyczalnia;

public final class ShareCar {

    private static ShareCar instance;
    private static String data_od;
    private static String data_do;
    private static String marka;
    private static String model;
    private static String rodzaj;
    private static String paliwo;
    private static int przebieg;
    private static int cena;
    private static int rocznik;


    private ShareCar(String data_do, String data_od, String marka, String model, String rodzaj, String paliwo, int przebieg ,int cena, int rocznik) {
        this.data_do = data_do;
        this.data_od = data_od;
        this.marka = marka;
        this.model = model;
        this.rodzaj = rodzaj;
        this.paliwo = paliwo;
        this.przebieg = przebieg;
        this.cena=cena;
        this.rocznik= rocznik;

    }

    public static ShareCar getInstance(String data_do, String data_od, String marka, String model, String rodzaj, String paliwo, int przebieg, int cena, int rocznik ) {
        if(instance == null) {
            instance = new ShareCar(data_do, data_od, marka, model, rodzaj, paliwo, przebieg, cena, rocznik);
        }
        return instance;
    }


    public static String getData_od() {
        return data_od;
    }

    public static int getRocznik() {return rocznik;}

    public static int getCena() {return cena;}

    public static String getMarka(){return marka;}

    public static String getModel() {return model;}

    public static String getRodzaj() {return rodzaj;}

    public static int getPrzebieg() {return przebieg;}

    public static String getPaliwo() {return paliwo;}

    public static String getData_do() {
        return data_do;
    }

    public static void cleanRentCar() {
        data_do = "";
        data_od = "";
        marka = "";
        model = "";
        rodzaj = "";
        przebieg = 0;
        paliwo = "";
        cena = 0;
        rocznik = 0;

    }

}
