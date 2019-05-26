package wypozyczalnia.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import wypozyczalnia.DBConnector;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MojeWypozyczeniaController implements Initializable {

    @FXML
    private AnchorPane pracownikPane;
    private AnchorPane zarzadzajPojazdamiPane;

    @FXML
    private TableView<ModelTableWypozyczenia> tabelka_moje_wypozyczenia;
    @FXML
    private TableColumn<ModelTableWypozyczenia, String> col_marka;
    @FXML
    private TableColumn<ModelTableWypozyczenia, String> col_model;
    @FXML
    private TableColumn<ModelTableWypozyczenia, String> col_data_od;
    @FXML
    private TableColumn<ModelTableWypozyczenia, String> col_data_do;
    @FXML
    private TableColumn<ModelTableWypozyczenia, String> col_cena;



    ObservableList<ModelTableWypozyczenia> oblist5 = FXCollections.observableArrayList();


    public void logOut(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/login.fxml"));
        pracownikPane.getChildren().setAll(pane);
    }

    public void menuPracownik(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/menuPracownik.fxml"));
        pracownikPane.getChildren().setAll(pane);
    }

    /*
    public void modujAuto(ActionEvent event) throws IOException {
        System.out.println("-");

        TablePosition pozycja = tabelka_moje_wypozyczenia.getSelectionModel().getSelectedCells().get(0);
        int index = pozycja.getRow();

        String marka = String.valueOf(autoMarka.getCharacters());
        String model = String.valueOf(autoModel.getCharacters());
        String Rodzaj = String.valueOf(autoRodzaj.getValue());
        String Rocznik = String.valueOf(autoRocznik.getCharacters());
        String Paliwo = String.valueOf(autoPaliwo.getValue());
        String przebieg = String.valueOf(autoPrzebieg.getCharacters());
        String cena = String.valueOf(autoCena.getCharacters());
        String dostepnosc = String.valueOf(autoDostep.getValue());

        if (walidacjaPol() & walidacjaCena() & walidacajaRok() & walidacjaPrzebieg() & walidacjaMarka() & walidacjaModel())
            try {
                index++;
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/projekt_zespolowe?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");

                PreparedStatement stmt = con.prepareStatement("SELECT * FROM samochod");
                String zapytanie = "Select * FROM samochod ORDER BY samochod_id LIMIT " + index;
                ResultSet rs = stmt.executeQuery(zapytanie);
                String a = "0";
                int i = 0;
                while (rs.next()) {
                    a = rs.getString(1);
                    i++;
                }
                int numer = Integer.parseInt(a);
                System.out.println(numer);
                PreparedStatement stmt2 = con.prepareStatement("UPDATE `samochod` SET `marka`=(?),`model`=(?),`rodzaj`=(?),`rocznik`=(?),`paliwo`=(?),`przebieg`=(?),`Cena`=(?), `dostepnosc`=(?) WHERE samochod_id=(?)");
                stmt2.setString(1, marka);
                stmt2.setString(2, model);
                stmt2.setString(3, Rodzaj);
                stmt2.setString(4, Rocznik);
                stmt2.setString(5, Paliwo);
                stmt2.setString(6, przebieg);
                stmt2.setString(7, cena);
                stmt2.setString(8, dostepnosc);
                stmt2.setInt(9, numer);

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Informacja");
                alert.setHeaderText(null);
                alert.setContentText("Dane pojazdu zostały zmodyfikowane pomyślnie!");
                alert.showAndWait();

                stmt2.executeUpdate();
                tabelka_moje_wypozyczenia.refresh();


            } catch (Exception e) {
                System.out.println(e);
            }
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/zarzadzajPojazdami.fxml"));
        pracownikPane.getChildren().setAll(pane);

    }
    */
    @Override
    public void initialize(URL location, ResourceBundle resources) {



        try {
            Connection con = DBConnector.getConnection();


            ResultSet rs = con.createStatement().executeQuery("SELECT samochod.marka, samochod.model, wypozyczenie.data_od, wypozyczenie.data_do, samochod.cena, user.user_id\n" +
                    "                    FROM samochod\n" +
                    "                    JOIN wypozyczenie\n" +
                    "                    ON samochod.samochod_id = wypozyczenie.samochod_id\n" +
                    "                    JOIN user\n" +
                    "                    ON wypozyczenie.user_id = user.user_id\n" +
                    "                    WHERE user.rodzaj = \"worker\"" );
            //   "WHERE user.user_id= 47");


            while (rs.next()) {
                oblist5.add(new ModelTableWypozyczenia(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)+ " zł/dzień", rs.getString(6)));
            }


        } catch (SQLException ex) {
            Logger.getLogger(historiaWypozyczenController.class.getName()).log(Level.SEVERE, null, ex);
        }


        col_marka.setCellValueFactory(new PropertyValueFactory<>("marka"));
        col_model.setCellValueFactory(new PropertyValueFactory<>("model"));
        col_data_do.setCellValueFactory(new PropertyValueFactory<>("data_od"));
        col_data_od.setCellValueFactory(new PropertyValueFactory<>("data_do"));
        col_cena.setCellValueFactory(new PropertyValueFactory<>("cena"));


        tabelka_moje_wypozyczenia.setItems(oblist5);

        tabelka_moje_wypozyczenia.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                String abc;
                abc = tabelka_moje_wypozyczenia.toString();
                System.out.println(abc);
                ArrayList<String> dane = new ArrayList<String>();
                try {

                    TablePosition pozycja = tabelka_moje_wypozyczenia.getSelectionModel().getSelectedCells().get(0);
                    int index = pozycja.getRow();

                    index++;
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/projekt_zespolowe?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");

                    PreparedStatement stmt = con.prepareStatement("SELECT * FROM samochod");
                    String zapytanie = "Select * FROM wypozyczenie ORDER BY wypozyczenie_id LIMIT " + index;
                    ResultSet rs = stmt.executeQuery(zapytanie);
                    String a = "0";
                    int i=0;
                    while(rs.next()) {
                        a = rs.getString(1);
                        i++;
                    }
                    int numer = Integer.parseInt(a);
                    System.out.println(numer);

                    zapytanie = "Select * FROM wypozyczenie where wypozyczenie_id = " + numer;
                    ResultSet rs2 = stmt.executeQuery(zapytanie);
                    System.out.println(rs2);
                    if(rs2.next()) {
                        dane.add(rs2.getString("data_od"));
                        dane.add(rs2.getString("data_do"));


                        col_data_od.setValue(LocalDate.parse(dane.get(4)));
                        col_data_do.setValue(LocalDate.parse(dane.get(5)));

                    }


                }catch (Exception e)
                {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Informacja");
                    alert.setHeaderText(null);
                    alert.setContentText("Zaznacz linie!");
                    alert.showAndWait();
                };


            };

        });

    }
}
