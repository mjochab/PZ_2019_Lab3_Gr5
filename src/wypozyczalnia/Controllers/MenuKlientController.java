package wypozyczalnia.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;


public class MenuKlientController {

    @FXML
    private AnchorPane klientPane;


    public void logOut(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/login.fxml"));
        klientPane.getChildren().setAll(pane);
    }

    public void terminKlient(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/terminKlient.fxml"));
        klientPane.getChildren().setAll(pane);
    }

    public void udostepnijPojazdK(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/udostepnijPojazdK.fxml"));
        klientPane.getChildren().setAll(pane);
    }

    public void historiaWypozyczenK(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/historiaWypozyczenK.fxml"));
        klientPane.getChildren().setAll(pane);
    }

    public void menuKlient(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/menuKlient.fxml"));
        klientPane.getChildren().setAll(pane);
    }

    public void mojeWypozyczeniaK(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/mojeWypozyczeniaK.fxml"));
        klientPane.getChildren().setAll(pane);
    }

}
