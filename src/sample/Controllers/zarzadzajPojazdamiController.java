package sample.Controllers;

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
import sample.DBConnector;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class zarzadzajPojazdamiController implements Initializable {
    @FXML
    private AnchorPane pracownikPane;
    private AnchorPane zarzadzajPojazdamiPane;

    @FXML
    private TableView<ModelTablePojazdy> tabelka_pojazdy;
    @FXML
    private TableColumn<ModelTablePojazdy, String> col_marka;
    @FXML
    private TableColumn<ModelTablePojazdy, String> col_model;
    @FXML
    private TableColumn<ModelTablePojazdy, String> col_rodzaj;
    @FXML
    private TableColumn<ModelTablePojazdy, String> col_paliwo;
    @FXML
    private TableColumn<ModelTablePojazdy, String> col_przebieg;
    @FXML
    private TableColumn<ModelTablePojazdy, Double> col_cena;

    @FXML private TextField autoMarka;
    @FXML private TextField autoModel;
    @FXML private TextField autoRodzaj;
    @FXML private TextField autoRocznik;
    @FXML private TextField autoPaliwo;
    @FXML private TextField autoPrzebieg;
    @FXML private TextField autoCena;




    ObservableList<ModelTablePojazdy> oblist1 = FXCollections.observableArrayList();


    public void dodajAuto(ActionEvent event) throws IOException{
        String marka = String.valueOf(autoMarka.getCharacters());
        String model = String.valueOf(autoModel.getCharacters());
        String Rodzaj = String.valueOf(autoRodzaj.getCharacters());
        String Rocznik = String.valueOf(autoRocznik.getCharacters());
        String Paliwo = String.valueOf(autoPaliwo.getCharacters());
        String przebieg = String.valueOf(autoPrzebieg.getCharacters());
        //int Przebieg = Integer.parseInt(przebieg);
        String cena = String.valueOf(autoCena.getCharacters());
        //float Cena = Float.parseFloat(cena);
        /*System.out.println(marka);
        System.out.println(model);
        System.out.println(Rodzaj);
        System.out.println(Rocznik);
        System.out.println(Paliwo);
        System.out.println(przebieg);*/

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/projekt_zespolowe?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            PreparedStatement stmt2 = con.prepareStatement("Select MAX(samochod_id) FROM samochod");
            ResultSet rs = stmt2.executeQuery("Select * FROM samochod");
            int i=1;
            while(rs.next()){
                i++;
            }

            PreparedStatement stmt = con.prepareStatement("INSERT INTO samochod VALUES(?,?,?,?,?,?,?)");
            stmt.setInt(1, i);
            stmt.setString(2, marka);
            stmt.setString(3, model);
            stmt.setString(4, Rodzaj);
            stmt.setString(5, Paliwo);
            stmt.setString(6, przebieg);
            stmt.setString(7, cena);
            stmt.executeUpdate();

            rs = stmt2.executeQuery("SELECT * FROM `samochod` WHERE samochod_id = (SELECT MAX(samochod_id) FROM samochod)");
            if(rs.next()) {
                System.out.println(rs.getString(2));
                oblist1.add(new ModelTablePojazdy(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));
            }

        }catch (Exception e)
        {
            System.out.println(e);
        };
    }

    public void czytaj(){
        System.out.println();
    }

    public void logOut(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../Fxml/login.fxml"));
        pracownikPane.getChildren().setAll(pane);
    }

    public void menuPracownik(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../Fxml/menuPracownik.fxml"));
        pracownikPane.getChildren().setAll(pane);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            Connection con = DBConnector.getConnection();

            ResultSet rs = con.createStatement().executeQuery("select * from samochod");

            while (rs.next()) {
                oblist1.add(new ModelTablePojazdy(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));
            }


        } catch (SQLException ex) {
            Logger.getLogger(zarzadzajUzytkownikamiAdminController.class.getName()).log(Level.SEVERE, null, ex);
        }


        col_marka.setCellValueFactory(new PropertyValueFactory<>("marka"));
        col_model.setCellValueFactory(new PropertyValueFactory<>("model"));
        col_rodzaj.setCellValueFactory(new PropertyValueFactory<>("rodzaj"));
        col_paliwo.setCellValueFactory(new PropertyValueFactory<>("paliwo"));
        col_przebieg.setCellValueFactory(new PropertyValueFactory<>("przebieg"));
        col_cena.setCellValueFactory(new PropertyValueFactory<>("Cena"));

        tabelka_pojazdy.setItems(oblist1);


    }

}
