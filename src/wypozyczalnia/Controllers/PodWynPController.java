package wypozyczalnia.Controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import wypozyczalnia.UserSession;

import java.awt.*;
import java.io.IOException;

public class PodWynPController {
    @FXML
    private AnchorPane pracownikPane;
    private Label markamodel_lbl;



    public void logOut(ActionEvent event) throws IOException {
        UserSession.cleanUserSession();
        Platform.exit();
    }

    public void menuPracownik(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/menuPracownik.fxml"));
        pracownikPane.getChildren().setAll(pane);
    }

    public void wypozyczeniePracownik(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/wypozyczeniePracownik.fxml"));
        pracownikPane.getChildren().setAll(pane);
    }

    public void markaModel (String marka){

        this.markamodel_lbl.setText(marka+"!");

    }


}
