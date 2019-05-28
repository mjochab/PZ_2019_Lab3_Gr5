package wypozyczalnia.Controllers;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import wypozyczalnia.DBConnector;
import wypozyczalnia.ShareCar;
import wypozyczalnia.UserSession;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class udostepnijPojazdKController {

    @FXML
    private AnchorPane klientPane;

    @FXML
    private TextField autoMarka;
    @FXML
    private TextField autoModel;
    @FXML
    private TextField autoRodzaj;
    @FXML
    private TextField autoPaliwo;
    @FXML
    private TextField autoPrzebieg;
    @FXML
    private TextField autoCena;

    public void clearFields(ActionEvent event) throws IOException {
        autoMarka.clear();
        autoModel.clear();
        autoCena.clear();
        autoPaliwo.clear();
        autoPrzebieg.clear();
        autoRodzaj.clear();
    }


    public void logOut(ActionEvent event) throws IOException {
        UserSession.cleanUserSession();
        Platform.exit();
    }

    public void menuKlient(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/menuKlient.fxml"));
        klientPane.getChildren().setAll(pane);
    }



    public void dodajAuto(ActionEvent event) throws IOException {
        String marka = String.valueOf(autoMarka.getCharacters());
        String model = String.valueOf(autoModel.getCharacters());
        String rodzaj = String.valueOf(autoRodzaj.getCharacters());
        String paliwo = String.valueOf(autoPaliwo.getCharacters());
        int przebieg = Integer.valueOf(autoPrzebieg.getText());
        int cena = Integer.valueOf(autoCena.getText());
        ShareCar.getInstance("","", marka, model, rodzaj, paliwo, przebieg, cena, 2012);




        AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/menuKlient.fxml"));
        klientPane.getChildren().setAll(pane);
        ;
    }

}