package wypozyczalnia.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;
public class MenuAdminController {

    @FXML
    public Label usernamedisplay_lbl;

    @FXML
    private AnchorPane adminPane;


    public void logOut(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/login.fxml"));
        adminPane.getChildren().setAll(pane);
    }

    public void menuAdmin(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/menuAdmin.fxml"));
        adminPane.getChildren().setAll(pane);
    }

    public void zarzadzajUzytkownikamiAdmin(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/zarzadzajUzytkownikamiAdmin.fxml"));
        adminPane.getChildren().setAll(pane);
    }

    public void zarzadzajPojazdamiAdmin(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/zarzadzajPojazdamiAdmin.fxml"));
        adminPane.getChildren().setAll(pane);
    }

    public void zarzadzajWypozyczeniamiAdmin(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/zarzadzajWypozyczeniamiAdmin.fxml"));
        adminPane.getChildren().setAll(pane);
    }

    public void zarzadzajPracownikami(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/zarzadzajPracownikami.fxml"));
        adminPane.getChildren().setAll(pane);
    }

    public void displayName (String usernamedisplay){

        this.usernamedisplay_lbl.setText(usernamedisplay);

    }

}
