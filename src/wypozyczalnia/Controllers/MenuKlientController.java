package wypozyczalnia.Controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import wypozyczalnia.UserSession;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class MenuKlientController implements Initializable {

    @FXML
    public Label usernamedisplay_lbl;

    @FXML
    private AnchorPane klientPane;


    public void logOut(ActionEvent event) throws IOException {
        UserSession.cleanUserSession();
        Platform.exit();
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void displayName (String usernamedisplay){

        this.usernamedisplay_lbl.setText(usernamedisplay+"!");

    }
}
