package wypozyczalnia.Controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import wypozyczalnia.RentCar;
import wypozyczalnia.RentID;
import wypozyczalnia.ShareCar;
import wypozyczalnia.UserSession;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class PodUdoController implements Initializable {
    int i =RentID.getSamochod_id();
    String f = Integer.toString(i);
    @FXML
    private AnchorPane klientPane;
    @FXML TextField marka;
    @FXML TextField dataod;
    @FXML TextField datado;
    @FXML TextField cena;

    @Override
    public void initialize(URL location, ResourceBundle resources){

        ArrayList<String> dane = new ArrayList<String>();

        marka.setText(ShareCar.getMarka()+" "+ShareCar.getModel());
        dataod.setText(ShareCar.getData_od());
        datado.setText(ShareCar.getData_do());
        cena.setText(Integer.toString(ShareCar.getCena()));
        String marka1 = marka.getText();
    }

    public void logOut(ActionEvent event) throws IOException {
        UserSession.cleanUserSession();
        Platform.exit();
    }
   int x = 2012;
    String marka1 = marka.getText();
    String model = ShareCar.getModel();
    String rodzaj = ShareCar.getRodzaj();
    String rocznik = Integer.toString(x);
    String paliwo = ShareCar.getPaliwo();
    String przebieg = Integer.toString(ShareCar.getPrzebieg());
    String cena1 = Integer.toString(ShareCar.getCena());
    public void openMenu(ActionEvent event) throws IOException {
        String uss = Integer.toString(UserSession.getID());
        String sid = Integer.toString(RentID.getSamochod_id());
        String doo = dataod.getText();
        String ddo = datado.getText();
       try {
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/projekt_zespolowe?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
           PreparedStatement stmt = con.prepareStatement("INSERT INTO `samochod` (`marka`, `model`, `rodzaj`, `rocznik`, `paliwo`, `przebieg`, `cena`, `dostepnosc`, `user_id`) VALUES (?,?,?,?,?,?,?,?,?)");
           stmt.setString(0,marka1);
           stmt.setString(1,model);
           stmt.setString(2,sid);
           stmt.setString(3,doo);
           stmt.setString(4,ddo);
           stmt.setString(5,rocznik);
           stmt.setString(6,paliwo);
           stmt.setString(7,przebieg);
           stmt.setString(8,cena1);
           stmt.setString(9,"TAK");

           stmt.executeUpdate();


           AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/menuKlient.fxml"));
           klientPane.getChildren().setAll(pane);
       }catch (Exception e)
       {

       }
    }
    public void wypozyczenieKlient(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/wypozyczenieKlient.fxml"));
        klientPane.getChildren().setAll(pane);
    }

}
