package wypozyczalnia.Controllers;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import wypozyczalnia.*;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import wypozyczalnia.DBConnector;
import java.sql.*;


public class PodWynController implements Initializable {
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
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/projekt_zespolowe?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            PreparedStatement stmt = con.prepareStatement("SELECT marka, model, cena FROM samochod WHERE samochod_id = ?");
            stmt.setString(1,f);
            ResultSet rs = stmt.executeQuery();
            if(rs.next())
            {
                dane.add(rs.getString("marka"));
                dane.add(rs.getString("model"));
                dane.add(rs.getString("cena"));
                marka.setText(String.valueOf(dane.get(0)+" "+dane.get(1)));
                cena.setText(String.valueOf(dane.get(2))+" zł/dzień");


            }
            dataod.setText(RentCar.getData_od());
            datado.setText(RentCar.getData_do());



        }catch (Exception e)
        {

        }

    }

    public void logOut(ActionEvent event) throws IOException {
        UserSession.cleanUserSession();
        Platform.exit();
    }


    public void openMenu(ActionEvent event) throws IOException {
        String uss = Integer.toString(UserSession.getID());
        String sid = Integer.toString(RentID.getSamochod_id());
        String doo = dataod.getText();
        String ddo = datado.getText();

       try {
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/projekt_zespolowe?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
           PreparedStatement stmt = con.prepareStatement("INSERT INTO wypozyczenie (user_id, samochod_id, data_od, data_do) VALUES (?,?,?,?)");
           stmt.setString(1,uss);
           stmt.setString(2,sid);
           stmt.setString(3,doo);
           stmt.setString(4,ddo);
           stmt.executeUpdate();
           PreparedStatement stmt1 = con.prepareStatement("UPDATE `samochod` SET `dostepnosc`='NIE' WHERE `samochod_id` =" +sid);
           stmt1.executeUpdate();

            RentCar.cleanRentCar();
            RentID.cleanUserSession();
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
