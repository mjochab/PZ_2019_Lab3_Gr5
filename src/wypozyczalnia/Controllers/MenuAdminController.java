package wypozyczalnia.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class MenuAdminController {
    @FXML
    private AnchorPane adminPane;


    public void logOut(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../Fxml/login.fxml"));
        adminPane.getChildren().setAll(pane);
    }

    public void menuAdmin(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../Fxml/menuAdmin.fxml"));
        adminPane.getChildren().setAll(pane);
    }

    public void zarzadzajUzytkownikamiAdmin(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../Fxml/zarzadzajUzytkownikamiAdmin.fxml"));
        adminPane.getChildren().setAll(pane);
    }

    public void zarzadzajPojazdamiAdmin(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../Fxml/zarzadzajPojazdamiAdmin.fxml"));
        adminPane.getChildren().setAll(pane);
    }

    public void zarzadzajWypozyczeniamiAdmin(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../Fxml/zarzadzajWypozyczeniamiAdmin.fxml"));
        adminPane.getChildren().setAll(pane);
    }

    public void zarzadzajPracownikami(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../Fxml/zarzadzajPracownikami.fxml"));
        adminPane.getChildren().setAll(pane);
    }

}
