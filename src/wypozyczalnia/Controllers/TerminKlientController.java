package wypozyczalnia.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class TerminKlientController {

    @FXML
    private AnchorPane klientPane;

<<<<<<< HEAD

    public void initialize(URL location, ResourceBundle resources) {
       System.out.println(UserSession.getUsername());
       System.out.println(UserSession.getID());
    }

=======
>>>>>>> parent of e2cf6e1... - Sesja logowania na singletionie,
    public void menuKlient(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/menuKlient.fxml"));
        klientPane.getChildren().setAll(pane);
    }

    public void wypozyczenieKlient(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/wypozyczenieKlient.fxml"));
        klientPane.getChildren().setAll(pane);
    }

    public void logOut(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/login.fxml"));
        klientPane.getChildren().setAll(pane);
    }

}
