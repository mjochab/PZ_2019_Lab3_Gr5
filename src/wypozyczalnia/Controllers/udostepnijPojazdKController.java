package wypozyczalnia.Controllers;

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

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class udostepnijPojazdKController implements Initializable {

    @FXML
    private AnchorPane klientPane;

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

    ObservableList<ModelTablePojazdy> oblist1 = FXCollections.observableArrayList();

    @FXML private TextField autoMarka;
    @FXML private TextField autoModel;
    @FXML private TextField autoRodzaj;
    @FXML private TextField autoPaliwo;
    @FXML private TextField autoPrzebieg;
    @FXML private TextField autoCena;

    public void clearFields(ActionEvent event) throws IOException {
        autoMarka.clear();
        autoModel.clear();
        autoCena.clear();
        autoPaliwo.clear();
        autoPrzebieg.clear();
        autoRodzaj.clear();
    }


    public void logOut(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/login.fxml"));
        klientPane.getChildren().setAll(pane);
    }

    public void menuKlient(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/menuKlient.fxml"));
        klientPane.getChildren().setAll(pane);
    }

    public void wypozyczenieKlient(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/wypozyczenieKlient.fxml"));
        klientPane.getChildren().setAll(pane);
    }

    public void usunAuto(ActionEvent event) throws  IOException{
        TablePosition pozycja = tabelka_pojazdy.getSelectionModel().getSelectedCells().get(0);
        int index = pozycja.getRow();

        try {
            index++;
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/projekt_zespolowe?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");

            PreparedStatement stmt = con.prepareStatement("SELECT * FROM samochod");
            String zapytanie = "Select * FROM samochod ORDER BY samochod_id LIMIT " + index;
            ResultSet rs = stmt.executeQuery(zapytanie);
            String a = "0";
            int i=0;
            while(rs.next()) {
                a = rs.getString(1);
                i++;
            }
            int numer = Integer.parseInt(a);
            System.out.println(numer);

            PreparedStatement stmt2 = con.prepareStatement("DELETE FROM samochod WHERE samochod_id = (?)");
            stmt2.setInt(1, numer);
            stmt2.executeUpdate();


        }catch (Exception e)
        {
            System.out.println(e);
        };
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/udostepnijPojazdK.fxml"));
        klientPane.getChildren().setAll(pane);

        tabelka_pojazdy.refresh();
    }

    public void modujAuto(ActionEvent event) throws  IOException{
        System.out.println("-");

        TablePosition pozycja = tabelka_pojazdy.getSelectionModel().getSelectedCells().get(0);
        int index = pozycja.getRow();

        String marka = String.valueOf(autoMarka.getCharacters());
        String model = String.valueOf(autoModel.getCharacters());
        String Rodzaj = String.valueOf(autoRodzaj.getCharacters());
        String Paliwo = String.valueOf(autoPaliwo.getCharacters());
        String przebieg = String.valueOf(autoPrzebieg.getCharacters());
        String cena = String.valueOf(autoCena.getCharacters());

        try {
            index++;
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/projekt_zespolowe?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");

            PreparedStatement stmt = con.prepareStatement("SELECT * FROM samochod");
            String zapytanie = "Select * FROM samochod ORDER BY samochod_id LIMIT " + index;
            ResultSet rs = stmt.executeQuery(zapytanie);
            String a = "0";
            int i=0;
            while(rs.next()) {
                a = rs.getString(1);
                i++;
            }
            int numer = Integer.parseInt(a);
            System.out.println(numer);
            PreparedStatement stmt2 = con.prepareStatement("UPDATE `samochod` SET `marka`=(?),`model`=(?),`rodzaj`=(?),`paliwo`=(?),`przebieg`=(?),`Cena`=(?) WHERE samochod_id=(?)");
            stmt2.setString(1, marka);
            stmt2.setString(2, model);
            stmt2.setString(3, Rodzaj);
            stmt2.setString(4, Paliwo);
            stmt2.setString(5, przebieg);
            stmt2.setString(6, cena);
            stmt2.setInt(7, numer);
            stmt2.executeUpdate();
            tabelka_pojazdy.refresh();


        }catch (Exception e)
        {
            System.out.println(e);
        }
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/udostepnijPojazdK.fxml"));
        klientPane.getChildren().setAll(pane);
    }

    public void dodajAuto(ActionEvent event) throws IOException{
        String marka = String.valueOf(autoMarka.getCharacters());
        String model = String.valueOf(autoModel.getCharacters());
        String Rodzaj = String.valueOf(autoRodzaj.getCharacters());
        String Paliwo = String.valueOf(autoPaliwo.getCharacters());
        String przebieg = String.valueOf(autoPrzebieg.getCharacters());
        //int Przebieg = Integer.parseInt(przebieg);
        String cena = String.valueOf(autoCena.getCharacters());
        //float Cena = Float.parseFloat(cena);
        /*System.out.println(marka);
        System.out.println(model);
        System.out.println(Rodzaj);
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
                oblist1.add(new ModelTablePojazdy(rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9)));            }


        }catch (Exception e)
        {
            System.out.println(e);
        };
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            Connection con = DBConnector.getConnection();

            ResultSet rs = con.createStatement().executeQuery("select * from samochod");

            while (rs.next()) {
                oblist1.add(new ModelTablePojazdy(rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9)));            }



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
                    String zapytanie = "Select * FROM samochod ORDER BY samochod_id LIMIT " + index;
                    ResultSet rs = stmt.executeQuery(zapytanie);
                    String a = "0";
                    int i=0;
                    while(rs.next()) {
                        a = rs.getString(1);
                        i++;
                    }
                    int numer = Integer.parseInt(a);
                    System.out.println(numer);


                    String model, rodzaj, paliwo, przebieg, cena;
                    zapytanie = "Select * FROM samochod where samochod_id = " + numer;
                    ResultSet rs2 = stmt.executeQuery(zapytanie);
                    System.out.println(rs2);
                    if(rs2.next()) {
                        dane.add(rs2.getString("marka"));
                        dane.add(rs2.getString("model"));
                        dane.add(rs2.getString("rodzaj"));
                        dane.add(rs2.getString("paliwo"));
                        int wartosc = rs2.getInt("przebieg");
                        dane.add(String.valueOf(wartosc));
                        long wartosc2 = rs2.getLong("cena");
                        dane.add(String.valueOf(wartosc2));
                        autoMarka.setText(String.valueOf(dane.get(0)));
                        autoModel.setText(String.valueOf(dane.get(1)));
                        autoRodzaj.setText(String.valueOf(dane.get(2)));
                        autoPaliwo.setText(String.valueOf(dane.get(3)));
                        autoPrzebieg.setText(String.valueOf(dane.get(4)));
                        autoCena.setText(String.valueOf(dane.get(5)));
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
