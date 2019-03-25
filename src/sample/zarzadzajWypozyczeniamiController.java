package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class zarzadzajWypozyczeniamiController {
    @FXML
    private AnchorPane pracownikPane;
    private AnchorPane zarzadzajPojazdamiPane;


    public void logOut(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("login.fxml"));
        pracownikPane.getChildren().setAll(pane);
    }

    public void menuPracownik(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("menuPracownik.fxml"));
        pracownikPane.getChildren().setAll(pane);
    }



}
