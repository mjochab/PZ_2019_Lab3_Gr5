package wypozyczalnia.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class PodWynPController {
    @FXML
    private AnchorPane pracownikPane;



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



}
