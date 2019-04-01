package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class TerminKlientController {

    @FXML
    private AnchorPane termPane;

    public void openMenu(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("menuKlient.fxml"));
        termPane.getChildren().setAll(pane);
    }
    public void openpods(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("podWyn.fxml"));
        termPane.getChildren().setAll(pane);
    }

}
