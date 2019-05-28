package wypozyczalnia.Controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.AnchorPane;
import wypozyczalnia.RentCar;
import wypozyczalnia.RentID;
import wypozyczalnia.UserSession;
import wypozyczalnia.UserSession;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

public class TerminKlientController implements Initializable {

    @FXML
    private AnchorPane klientPane;
    @FXML
    private DatePicker dataPoczatek;
    @FXML
    private DatePicker dataKoniec;
    @FXML
    private Button add_wypo;


    public void initialize(URL location, ResourceBundle resources) {

    }

    public void add_wypo(ActionEvent event) throws IOException {


        AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/PodWyn.fxml"));
        klientPane.getChildren().setAll(pane);

    }

    public void menuKlient(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/menuKlient.fxml"));
        klientPane.getChildren().setAll(pane);
    }

    public void wypozyczenieKlient(ActionEvent event) throws IOException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        java.util.Date date = new java.util.Date();
        //  System.out.println("Current Date : " + dateFormat.format(date));
        if (walidacjaData()) {
            RentCar.getInstance(dataKoniec.getValue().toString(), dataPoczatek.getValue().toString(), 0, 0, RentID.getSamochod_id());
            AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/wypozyczenieKlient.fxml"));
            klientPane.getChildren().setAll(pane);
        }
        else
    {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Informacja");
        alert.setHeaderText(null);
        alert.setContentText("Data koncowa nieprawidłowa!");
        alert.showAndWait();
    }
    }


    public void logOut(ActionEvent event) throws IOException {
        UserSession.cleanUserSession();
        Platform.exit();
    }

    private boolean walidacjaData()
    {
        if(dataPoczatek.getValue().toEpochDay()>=(dataKoniec.getValue().toEpochDay()))
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Błąd!");
            alert.setHeaderText(null);
            alert.setContentText("Wybierz odpowiednie daty!");
            alert.showAndWait();

            return false;
        }
        return true;
    }


}
