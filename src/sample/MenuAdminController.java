package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;


public class MenuAdminController {

    @FXML
    private AnchorPane adminPane;


    public void logOut(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("login.fxml"));
        adminPane.getChildren().setAll(pane);
    }


}
