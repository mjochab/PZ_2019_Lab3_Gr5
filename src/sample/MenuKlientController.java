package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class MenuKlientController {

    @FXML
    private AnchorPane klientPane;


    public void logOut(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("login.fxml"));
        klientPane.getChildren().setAll(pane);
    }

    public void loadwypozyczenieKlient(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("wypozyczenieKlient.fxml"));
        klientPane.getChildren().setAll(pane);
    }
}
