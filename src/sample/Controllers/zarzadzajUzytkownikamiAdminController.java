package sample.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class zarzadzajUzytkownikamiAdminController {
    @FXML
    private AnchorPane adminPane;
    private AnchorPane zarzadzajPojazdamiPane;


    public void logOut(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../Fxml/login.fxml"));
        adminPane.getChildren().setAll(pane);
    }

    public void menuAdmin(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../Fxml/menuAdmin.fxml"));
        adminPane.getChildren().setAll(pane);
    }



}
