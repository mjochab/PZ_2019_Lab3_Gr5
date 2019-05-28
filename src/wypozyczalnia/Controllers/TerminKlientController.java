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
    public void add_wypo (ActionEvent event) throws IOException {



            AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/PodWyn.fxml"));
            klientPane.getChildren().setAll(pane);

    }
    public void menuKlient(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/menuKlient.fxml"));
        klientPane.getChildren().setAll(pane);
    }

    public void wypozyczenieKlient(ActionEvent event) throws IOException {
            RentCar.getInstance(dataKoniec.getValue().toString(), dataPoczatek.getValue().toString(), 0, 0, RentID.getSamochod_id());
            AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/wypozyczenieKlient.fxml"));
            klientPane.getChildren().setAll(pane);
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
