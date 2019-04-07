package sample.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class MenuPracownikController {
    @FXML
    private AnchorPane pracownikPane;


    public void logOut(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../Fxml/login.fxml"));
        pracownikPane.getChildren().setAll(pane);
    }

    public void menuPracownik(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../Fxml/menuPracownik.fxml"));
        pracownikPane.getChildren().setAll(pane);
    }
    public void zarzadzajPojazdami(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../Fxml/zarzadzajPojazdami.fxml"));
        pracownikPane.getChildren().setAll(pane);
    }
    public void zarzadzajUzytkownikami(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../Fxml/zarzadzajUzytkownikami.fxml"));
        pracownikPane.getChildren().setAll(pane);
    }
    public void zarzadzajWypozyczeniami(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../Fxml/zarzadzajWypozyczeniami.fxml"));
        pracownikPane.getChildren().setAll(pane);
    }

    public void historiaWypozyczen(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../Fxml/historiaWypozyczen.fxml"));
        pracownikPane.getChildren().setAll(pane);
    }
    public void udostepnijPojazd(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../Fxml/udostepnijPojazd.fxml"));
        pracownikPane.getChildren().setAll(pane);
    }
    public void terminPracownik(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../Fxml/terminPracownik.fxml"));
        pracownikPane.getChildren().setAll(pane);
    }

    public void mojeWypozyczenia(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../Fxml/mojeWypozyczenia.fxml"));
        pracownikPane.getChildren().setAll(pane);
    }

}
