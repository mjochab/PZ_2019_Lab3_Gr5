package wypozyczalnia.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TerminPracownikController implements Initializable {
    @FXML
    private AnchorPane pracownikPane;
    @FXML
    private DatePicker dataPoczatek;
    private DatePicker dataKoniec;




    public void logOut(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/login.fxml"));
        pracownikPane.getChildren().setAll(pane);
    }

    public void menuPracownik(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/menuPracownik.fxml"));
        pracownikPane.getChildren().setAll(pane);
    }
    public void wypozyczeniePracownik(ActionEvent event) throws IOException {

            AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/wypozyczeniePracownik.fxml"));
            pracownikPane.getChildren().setAll(pane);
        }


    private boolean walidacjaData()
    {
        if(dataPoczatek.getValue()==dataKoniec.getValue())
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Informacja");
            alert.setHeaderText(null);
            alert.setContentText("Uzupełnij wszystkie pola");
            alert.showAndWait();

            return false;
        }
        return true;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }



}
