package wypozyczalnia.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class MenuPracownikController {

    @FXML
    public Label usernamedisplay_lbl;

    @FXML
    private AnchorPane pracownikPane;


    public void logOut(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/login.fxml"));
        pracownikPane.getChildren().setAll(pane);
    }

    public void menuPracownik(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/menuPracownik.fxml"));
        pracownikPane.getChildren().setAll(pane);
    }
    public void zarzadzajPojazdami(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/zarzadzajPojazdami.fxml"));
        pracownikPane.getChildren().setAll(pane);
    }
    public void zarzadzajUzytkownikami(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/zarzadzajUzytkownikami.fxml"));
        pracownikPane.getChildren().setAll(pane);
    }
    public void zarzadzajWypozyczeniami(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/zarzadzajWypozyczeniami.fxml"));
        pracownikPane.getChildren().setAll(pane);
    }

    public void historiaWypozyczen(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/historiaWypozyczen.fxml"));
        pracownikPane.getChildren().setAll(pane);
    }
    public void udostepnijPojazd(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/udostepnijPojazd.fxml"));
        pracownikPane.getChildren().setAll(pane);
    }
    public void terminPracownik(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/terminPracownik.fxml"));
        pracownikPane.getChildren().setAll(pane);
    }

    public void mojeWypozyczenia(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/mojeWypozyczenia.fxml"));
        pracownikPane.getChildren().setAll(pane);
    }

    public void displayName (String usernamedisplay){

        this.usernamedisplay_lbl.setText(usernamedisplay+"!");

    }
}
