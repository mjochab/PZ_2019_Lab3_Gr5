package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class WypozyczenieKlientController {

    @FXML
    private AnchorPane wypPane;


    public void openMenu(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("menuKlient.fxml"));
        wypPane.getChildren().setAll(pane);
    }

    public void opentermin(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("menuKlient.fxml"));
        wypPane.getChildren().setAll(pane);
    }

}
