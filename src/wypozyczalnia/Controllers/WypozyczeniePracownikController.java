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
import wypozyczalnia.UserSession;
import wypozyczalnia.RentID;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class WypozyczeniePracownikController implements Initializable {

    @FXML
    private AnchorPane pracownikPane;

    @FXML
    private TableView<ModelTableWypPoj> tabelka_pojazdy;
    @FXML
    private TableColumn<ModelTableWypPoj, String> col_marka;
    @FXML
    private TableColumn<ModelTableWypPoj, String> col_model;
    @FXML
    private TableColumn<ModelTableWypPoj, String> col_rodzaj;
    @FXML
    private TableColumn<ModelTableWypPoj, String> col_rocznik;
    @FXML
    private TableColumn<ModelTableWypPoj, String> col_paliwo;
    @FXML
    private TableColumn<ModelTableWypPoj, String> col_przebieg;
    @FXML
    private TableColumn<ModelTableWypPoj, String> col_cena;
    @FXML
    private TableColumn<ModelTableWypPoj, String> col_dostepnosc;
    @FXML
    private Label marka_lbl;
    @FXML
    private Label model_lbl;
    @FXML
    private Label dostep_lbl;
    @FXML
    private Label samochod_id_lbl;
    @FXML
    private Button wypozycz;
    String samochod_id;
    String marka;



    public void wypozycz(ActionEvent event) throws IOException {

        AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/terminPracownik.fxml"));
        pracownikPane.getChildren().setAll(pane);
    }

    ObservableList<ModelTableWypPoj> oblist1 = FXCollections.observableArrayList();
    public void logOut(ActionEvent event) throws IOException {
        UserSession.cleanUserSession();
        Platform.exit();
    }

    public void menuPracownik(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/menuPracownik.fxml"));
        pracownikPane.getChildren().setAll(pane);
    }

    public void podWynP(ActionEvent event) throws IOException {
        if(walidacjaDostep()) {
            String aaa = samochod_id_lbl.getText();

            RentID.getInstance(Integer.parseInt(aaa));

            AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/podWynP.fxml"));
            pracownikPane.getChildren().setAll(pane);
        }
    }

    private boolean walidacjaDostep(){


        if(dostep_lbl.getText().equals("TAK")){
            return true;
        }else
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Informacja");
            alert.setHeaderText(null);
            alert.setContentText("Nie można wypożyczyć samochodu, jest niedostępny!");
            alert.showAndWait();

            return false;
        }
    }




    @Override
    public void initialize(URL location, ResourceBundle resources) {

        dostep_lbl.setVisible(false);

        String marka = marka_lbl.getText();

        try {
            Connection con = DBConnector.getConnection();

            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM `samochod` WHERE `dostepnosc` = 'TAK'");

            while (rs.next()) {
                //oblist1.add(new ModelTableWypPoj(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));
                oblist1.add(new ModelTableWypPoj(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7) , rs.getString(8)+" zł/dzień",rs.getString(9)));
            }


        } catch (SQLException ex) {
            Logger.getLogger(zarzadzajUzytkownikamiAdminController.class.getName()).log(Level.SEVERE, null, ex);
        }


        col_marka.setCellValueFactory(new PropertyValueFactory<>("marka"));
        col_model.setCellValueFactory(new PropertyValueFactory<>("model"));
        col_rodzaj.setCellValueFactory(new PropertyValueFactory<>("rodzaj"));
        col_rocznik.setCellValueFactory(new PropertyValueFactory<>("rocznik"));
        col_paliwo.setCellValueFactory(new PropertyValueFactory<>("paliwo"));
        col_przebieg.setCellValueFactory(new PropertyValueFactory<>("przebieg"));
        col_cena.setCellValueFactory(new PropertyValueFactory<>("cena"));
        col_dostepnosc.setCellValueFactory(new PropertyValueFactory<>("dostepnosc"));

        tabelka_pojazdy.setItems(oblist1);


        tabelka_pojazdy.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                String abc;
                abc = tabelka_pojazdy.toString();
                System.out.println(abc);
                ArrayList<String> dane = new ArrayList<String>();
                try {

                    TablePosition pozycja = tabelka_pojazdy.getSelectionModel().getSelectedCells().get(0);
                    int index = pozycja.getRow();

                    index++;
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/projekt_zespolowe?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");

                    PreparedStatement stmt = con.prepareStatement("SELECT * FROM samochod");
                    String zapytanie = "Select * FROM samochod WHERE dostepnosc = 'TAK' ORDER BY samochod_id LIMIT " + index;
                    ResultSet rs = stmt.executeQuery(zapytanie);
                    String a = "0";
                    int i=0;
                    while(rs.next()) {
                        a = rs.getString(1);
                        i++;
                    }
                    int numer = Integer.parseInt(a);
                    System.out.println(numer);

                    zapytanie = "Select * FROM samochod where samochod_id = " + numer;
                    ResultSet rs2 = stmt.executeQuery(zapytanie);
                    System.out.println(rs2);
                    if(rs2.next()) {
                        dane.add(rs2.getString("samochod_id"));
                        dane.add(rs2.getString("marka"));
                        dane.add(rs2.getString("model"));
                        dane.add(rs2.getString("dostepnosc"));

                        samochod_id_lbl.setText(String.valueOf(dane.get(0)));
                        marka_lbl.setText(String.valueOf(dane.get(1)));
                        model_lbl.setText(String.valueOf(dane.get(2)));
                        dostep_lbl.setText(String.valueOf(dane.get(3)));



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
    };



}

