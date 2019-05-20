package wypozyczalnia.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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

    @FXML private TextField imiePracownik;
    @FXML private TextField nazwiskoPracownik;
    @FXML private TextField loginPracownik;
    @FXML private TextField peselPracownik;


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


    public void dodajPracownika(ActionEvent event) throws IOException{
        String imie = String.valueOf(imiePracownik.getCharacters());
        String nazwisko = String.valueOf(nazwiskoPracownik.getCharacters());
        String login = String.valueOf(loginPracownik.getCharacters());
        String pesel = String.valueOf(peselPracownik.getCharacters());



        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/projekt_zespolowe?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            PreparedStatement stmt2 = con.prepareStatement("Select MAX(samochod_id) FROM klient");
            ResultSet rs = stmt2.executeQuery("Select * FROM pracownik");
            int i=1;
            int n=1;
            while(rs.next()){
                i++;
            }
            Integer puste= i+1;
            String haslo= "haslo";

            PreparedStatement stmt = con.prepareStatement("INSERT INTO pracownik VALUES(?,?,?,?,?,?,?)");
            stmt.setInt(1, i);
            stmt.setInt(2, puste);
            stmt.setString(3, login);
            stmt.setString(4, haslo);
            stmt.setString(5, imie);
            stmt.setString(6, nazwisko);
            stmt.setString(7, pesel);
            stmt.executeUpdate();

            rs = stmt2.executeQuery("SELECT * FROM `pracownik` WHERE pracownik_id = (SELECT MAX(pracownik_id) FROM pracownik)");
            if(rs.next()) {
                System.out.println(rs.getString(2));
                oblist2.add(new ModelTablePracownicy(rs.getString(5), rs.getString(6),rs.getString(3),""+rs.getLong(5)));
            }

        }catch (Exception e)
        {
            System.out.println(e);
        }
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/zarzadzajPracownikami.fxml"));
        adminPane.getChildren().setAll(pane);
        tabelka_pracownicy.refresh();

    }

    public void klik(ActionEvent event) throws  IOException{        //funkcja przenosi dane do tabelki po lewej stronie, jak tyknie sie wiersz w tabeli to przenosi
        //TablePosition pozycja = tabelka_pojazdy.getSelectionModel().getSelectedCells().get(0);
        //int index = pozycja.getRow();
        String abc;
        abc = tabelka_pracownicy.toString();
        System.out.println(abc);
        ArrayList<String> dane = new ArrayList<String>();
        try {
            TablePosition pozycja = tabelka_pracownicy.getSelectionModel().getSelectedCells().get(0);
            int index = pozycja.getRow();

            index++;
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/projekt_zespolowe?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");

            PreparedStatement stmt = con.prepareStatement("SELECT * FROM pracownik");
            String zapytanie = "Select * FROM pracownik ORDER BY pracownik_id LIMIT " + index;
            ResultSet rs = stmt.executeQuery(zapytanie);
            String a = "0";
            int i=0;
            while(rs.next()) {
                a = rs.getString(1);
                i++;
            }
            int numer = Integer.parseInt(a);
            System.out.println(numer);


            zapytanie = "Select * FROM pracownik where pracownik_id = " + numer;
            ResultSet rs2 = stmt.executeQuery(zapytanie);
            System.out.println(rs2);
            if(rs2.next()) {
                dane.add(rs2.getString("imie"));
                dane.add(rs2.getString("nazwisko"));
                dane.add(rs2.getString("login"));
                dane.add(rs2.getString("pesel"));
                imiePracownik.setText(String.valueOf(dane.get(0)));
                nazwiskoPracownik.setText(String.valueOf(dane.get(1)));
                loginPracownik.setText(String.valueOf(dane.get(2)));
                peselPracownik.setText(String.valueOf(dane.get(3)));
            }


        }catch (Exception e)
        {
            System.out.println(e);
        };

    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            Connection con = DBConnector.getConnection();

            ResultSet rs = con.createStatement().executeQuery("select * from pracownik");

            while (rs.next()){
                oblist2.add(new ModelTablePracownicy( rs.getString(5),rs.getString(6),rs.getString(3),""+ rs.getLong(7)));
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