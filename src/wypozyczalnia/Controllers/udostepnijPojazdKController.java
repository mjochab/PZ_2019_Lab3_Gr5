package wypozyczalnia.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class udostepnijPojazdKController {

    @FXML
    private AnchorPane klientPane;

    public void logOut(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../Fxml/login.fxml"));
        klientPane.getChildren().setAll(pane);
    }

    public void menuKlient(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../Fxml/menuKlient.fxml"));
        klientPane.getChildren().setAll(pane);
    }

    public void wypozyczenieKlient(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../Fxml/wypozyczenieKlient.fxml"));
        klientPane.getChildren().setAll(pane);
    }


}
