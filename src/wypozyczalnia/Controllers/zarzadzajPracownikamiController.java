package wypozyczalnia.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import wypozyczalnia.DBConnector;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class zarzadzajPracownikamiController implements Initializable {
    @FXML
    private AnchorPane adminPane;
    @FXML
    private TableView<ModelTablePracownicy> tabelka_pracownicy;
    @FXML
    private TableColumn<ModelTablePracownicy, String> col_imie;
    @FXML
    private TableColumn<ModelTablePracownicy, String> col_nazwisko;
    @FXML
    private TableColumn<ModelTablePracownicy, String> col_login;
    @FXML
    private TableColumn<ModelTablePracownicy, String> col_pesel;

    @FXML private TextField imie;
    @FXML private TextField nazwisko;
    @FXML private TextField dataUrodzenia;
    @FXML private TextField miejscowosc;
    @FXML private TextField nrTel;
    @FXML private TextField eMail;
    @FXML private TextField pesel;

    ObservableList<ModelTablePracownicy> oblist2 = FXCollections.observableArrayList();


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

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            Connection con = DBConnector.getConnection();

            ResultSet rs = con.createStatement().executeQuery("select * from pracownik");

            while (rs.next()){
                oblist2.add(new ModelTablePracownicy( rs.getString(5),rs.getString(6),rs.getString(3),rs.getString(7)));
            }


        }catch (SQLException ex){
            Logger.getLogger(zarzadzajUzytkownikamiAdminController.class.getName()).log(Level.SEVERE,null, ex);
        }



        col_imie.setCellValueFactory(new PropertyValueFactory<>("imie"));
        col_nazwisko.setCellValueFactory(new PropertyValueFactory<>("nazwisko"));
        col_login.setCellValueFactory(new PropertyValueFactory<>("login"));
        col_pesel.setCellValueFactory(new PropertyValueFactory<>("pesel"));


        tabelka_pracownicy.setItems(oblist2);


    }


}