package sample.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class WypozyczenieKlientController {

    @FXML
    private AnchorPane klientPane;


    public void openMenu(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../Fxml/menuKlient.fxml"));
        klientPane.getChildren().setAll(pane);
    }

    public void podWyn(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../Fxml/podWyn.fxml"));
        klientPane.getChildren().setAll(pane);
    }

    public void terminKlient(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../Fxml/terminKlient.fxml"));
        klientPane.getChildren().setAll(pane);
    }

}
