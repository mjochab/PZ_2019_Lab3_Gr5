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
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../Fxml/login.fxml"));
        klientPane.getChildren().setAll(pane);
    }

    public void terminKlient(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../Fxml/terminKlient.fxml"));
        klientPane.getChildren().setAll(pane);
    }

    public void udostepnijPojazdK(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../Fxml/udostepnijPojazdK.fxml"));
        klientPane.getChildren().setAll(pane);
    }

    public void historiaWypozyczenK(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../Fxml/historiaWypozyczenK.fxml"));
        klientPane.getChildren().setAll(pane);
    }

    public void menuKlient(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../Fxml/menuKlient.fxml"));
        klientPane.getChildren().setAll(pane);
    }

    public void mojeWypozyczeniaK(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../Fxml/mojeWypozyczeniaK.fxml"));
        klientPane.getChildren().setAll(pane);
    }

}
