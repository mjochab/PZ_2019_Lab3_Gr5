package wypozyczalnia.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import wypozyczalnia.DBConnector;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class zarzadzajPojazdamiAdminController implements Initializable {
    @FXML
    private AnchorPane adminPane;

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
    @FXML
    private TableColumn<ModelTablePojazdy, Double> col_rocznik;
    @FXML
    private TableColumn<ModelTablePojazdy, Double> col_dostepnosc;

    ObservableList<ModelTablePojazdy> oblist1 = FXCollections.observableArrayList();

    @FXML private TextField autoMarka;
    @FXML private TextField autoModel;
    @FXML private ChoiceBox<String> autoRodzaj;
    @FXML private TextField autoRocznik;
    @FXML private ChoiceBox<String> autoPaliwo;
    @FXML private TextField autoPrzebieg;
    @FXML private TextField autoCena;
    @FXML private TextField autoDostepnosc;
    @FXML private ChoiceBox<String> autoDostep;

    public void logOut(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/login.fxml"));
        adminPane.getChildren().setAll(pane);
    }

    public void menuAdmin(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/menuAdmin.fxml"));
        adminPane.getChildren().setAll(pane);
    }

    public void klik(ActionEvent event) throws  IOException{        //funkcja przenosi dane do tabelki po lewej stronie, jak tyknie sie wiersz w tabeli to przenosi
        //TablePosition pozycja = tabelka_pojazdy.getSelectionModel().getSelectedCells().get(0);
        //int index = pozycja.getRow();
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


            String model, rodzaj, rocznik, paliwo, przebieg, cena;
            zapytanie = "Select * FROM samochod where samochod_id = " + numer;
            ResultSet rs2 = stmt.executeQuery(zapytanie);
            System.out.println(rs2);
            if(rs2.next()) {
                dane.add(rs2.getString("marka"));
                dane.add(rs2.getString("model"));
                dane.add(rs2.getString("rodzaj"));
                dane.add(rs2.getString("rocznik"));
                dane.add(rs2.getString("paliwo"));
                dane.add(rs2.getString("przebieg"));
                dane.add(rs2.getString("cena"));
                dane.add(rs2.getString("dostepnosc"));

                autoMarka.setText(String.valueOf(dane.get(0)));
                autoModel.setText(String.valueOf(dane.get(1)));
                autoRodzaj.setValue(String.valueOf(dane.get(2)));
                autoRocznik.setText(String.valueOf(dane.get(3)));
                autoPaliwo.setValue(String.valueOf(dane.get(4)));
                autoPrzebieg.setText(String.valueOf(dane.get(5)));
                autoCena.setText(String.valueOf(dane.get(6)));
                autoDostep.setValue(String.valueOf(dane.get(7)));
            }


        }catch (Exception e)
        {
            System.out.println(e);
        };


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
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/zarzadzajPojazdami.fxml"));
        adminPane.getChildren().setAll(pane);

        tabelka_pojazdy.refresh();
    }

    public void modujAuto(ActionEvent event) throws  IOException{
        System.out.println("-");

        TablePosition pozycja = tabelka_pojazdy.getSelectionModel().getSelectedCells().get(0);
        int index = pozycja.getRow();

        String marka = String.valueOf(autoMarka.getCharacters());
        String model = String.valueOf(autoModel.getCharacters());
        String Rodzaj = String.valueOf(autoRodzaj.getValue());
        String Rocznik = String.valueOf(autoRocznik.getCharacters());
        String Paliwo = String.valueOf(autoPaliwo.getValue());
        String przebieg = String.valueOf(autoPrzebieg.getCharacters());
        String cena = String.valueOf(autoCena.getCharacters());
        String dostepnosc = String.valueOf(autoDostepnosc.getCharacters());

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
            PreparedStatement stmt2 = con.prepareStatement("UPDATE `samochod` SET `marka`=(?),`model`=(?),`rodzaj`=(?),`rocznik`=(?),`paliwo`=(?),`przebieg`=(?),`Cena`=(?), `dostepnosc`=(?) WHERE samochod_id=(?)");
            stmt2.setString(1, marka);
            stmt2.setString(2, model);
            stmt2.setString(3, Rodzaj);
            stmt2.setString(4, Rocznik);
            stmt2.setString(5, Paliwo);
            stmt2.setString(6, przebieg);
            stmt2.setString(7, cena);
            stmt2.setString(8,dostepnosc);
            stmt2.setInt(9, numer);
            stmt2.executeUpdate();
            tabelka_pojazdy.refresh();


        }catch (Exception e)
        {
            System.out.println(e);
        }
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/zarzadzajPojazdami.fxml"));
        adminPane.getChildren().setAll(pane);

    }


    public void dodajAuto(ActionEvent event) throws IOException{
        String marka = String.valueOf(autoMarka.getCharacters());
        String model = String.valueOf(autoModel.getCharacters());
        String Rodzaj = String.valueOf(autoRodzaj.getValue());
        String rocznik = String.valueOf(autoRocznik.getCharacters());
        String Paliwo = String.valueOf(autoPaliwo.getValue());
        String przebieg = String.valueOf(autoPrzebieg.getCharacters());
        //int Przebieg = Integer.parseInt(przebieg);
        String cena = String.valueOf(autoCena.getCharacters());
        String dostepnosc = String.valueOf(autoDostepnosc.getCharacters());
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

            PreparedStatement stmt = con.prepareStatement("INSERT INTO samochod VALUES(?,?,?,?,?,?,?,?,?)");
            stmt.setInt(1, i);
            stmt.setString(2, marka);
            stmt.setString(3, model);
            stmt.setString(4, Rodzaj);
            stmt.setString(5, rocznik);
            stmt.setString(6, Paliwo);
            stmt.setString(7, przebieg);
            stmt.setString(8, cena);
            stmt.setString(9, dostepnosc);
            stmt.executeUpdate();

            rs = stmt2.executeQuery("SELECT * FROM `samochod` WHERE samochod_id = (SELECT MAX(samochod_id) FROM samochod)");
            if(rs.next()) {
                System.out.println(rs.getString(2));
                oblist1.add(new ModelTablePojazdy(rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7), rs.getString(8),rs.getString(9)));
            }

        }catch (Exception e)
        {
            System.out.println(e);
        };


    }

    public void czytaj(){
        System.out.println();
    }


    public void menuPracownik(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/menuPracownik.fxml"));
        adminPane.getChildren().setAll(pane);
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
        col_rocznik.setCellValueFactory(new PropertyValueFactory<>("rocznik"));
        col_paliwo.setCellValueFactory(new PropertyValueFactory<>("paliwo"));
        col_przebieg.setCellValueFactory(new PropertyValueFactory<>("przebieg"));
        col_cena.setCellValueFactory(new PropertyValueFactory<>("cena"));
        col_dostepnosc.setCellValueFactory(new PropertyValueFactory<>("dostepnosc"));

        tabelka_pojazdy.setItems(oblist1);

        autoDostep.getItems().addAll("TAK","NIE");


        autoDostep.getItems().addAll("TAK","NIE");
        autoPaliwo.getItems().addAll("Diesel","Benzyna","Gaz");
        autoRodzaj.getItems().addAll("Sedan","Kombi","Hatchback","Coupe","Limuzyna","Suv","Kabriolet","Roadster");

    }

    }
