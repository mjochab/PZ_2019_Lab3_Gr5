package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class MenuPracownikController {
    @FXML
    private AnchorPane pracownikPane;


    public void logOut(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("login.fxml"));
        pracownikPane.getChildren().setAll(pane);
    }

    public void menuPracownik(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("menuPracownik.fxml"));
        pracownikPane.getChildren().setAll(pane);
    }
    public void zarzadzajPojazdami(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("zarzadzajPojazdami.fxml"));
        pracownikPane.getChildren().setAll(pane);
    }
    public void zarzadzajUzytkownikami(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("zarzadzajUzytkownikami.fxml"));
        pracownikPane.getChildren().setAll(pane);
    }
    public void zarzadzajWypozyczeniami(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("zarzadzajWypozyczeniami.fxml"));
        pracownikPane.getChildren().setAll(pane);
    }

    public void historiaWypozyczen(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("historiaWypozyczen.fxml"));
        pracownikPane.getChildren().setAll(pane);
    }
    public void udostepnijPojazd(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("udostepnijPojazd.fxml"));
        pracownikPane.getChildren().setAll(pane);
    }
    public void terminPracownik(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("terminPracownik.fxml"));
        pracownikPane.getChildren().setAll(pane);
    }

}
