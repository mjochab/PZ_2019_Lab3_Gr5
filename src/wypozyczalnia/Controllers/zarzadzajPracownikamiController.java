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
    @FXML
    private TableColumn<ModelTablePracownicy, String> col_miejscowosc;
    @FXML
    private TableColumn<ModelTablePracownicy, String> col_email;
    @FXML
    private TableColumn<ModelTablePracownicy, String> col_telefon;
    @FXML
    private TableColumn<ModelTablePracownicy, String> col_data;

    @FXML private TextField imiePracownik;
    @FXML private TextField nazwiskoPracownik;
    @FXML private TextField loginPracownik;
    @FXML private TextField peselPracownik;
    @FXML private TextField dataPracownik;
    @FXML private TextField miejscowoscPracownik;
    @FXML private TextField telefonPracownik;
    @FXML private TextField emailPracownik;


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
        String pesel = String.valueOf(peselPracownik.getText());
        String data_urodzenia = String.valueOf(dataPracownik.getCharacters());
        String miejscowosc = String.valueOf(miejscowoscPracownik.getCharacters());
        String telefon = String.valueOf(telefonPracownik.getCharacters());
        String email = String.valueOf(emailPracownik.getCharacters());



        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/projekt_zespolowe?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            PreparedStatement stmt2 = con.prepareStatement("Select MAX(user_id) FROM `user` WHERE `rodzaj` = 'worker'");
            ResultSet rs = stmt2.executeQuery("SELECT * FROM `user` WHERE `rodzaj` = 'worker'");
            int i=1;
            int n=1;
            while(rs.next()){
                i++;
            }
            Integer puste= i+1;
            String haslo= "haslo";
            String rodzaj = "worker";

            PreparedStatement stmt = con.prepareStatement("INSERT INTO user VALUES(?,?,?,?,?,?,?,?,?,?,?)");
            stmt.setInt(1, i);
            stmt.setString(2, login);
            stmt.setString(3, haslo);
            stmt.setString(4, imie);
            stmt.setString(5, nazwisko);
            stmt.setString(6, data_urodzenia);
            stmt.setString(7, miejscowosc);
            stmt.setString(8, telefon);
            stmt.setString(9, email);
            stmt.setString(10, pesel);
            stmt.setString(11,rodzaj);
            stmt.executeUpdate();

            rs = stmt2.executeQuery("SELECT * FROM `user` WHERE user_id = (SELECT MAX(user_id) FROM user)");
            if(rs.next()) {
                System.out.println(rs.getString(2));
                oblist2.add(new ModelTablePracownicy(rs.getString(4), rs.getString(5),rs.getString(2), rs.getString(10), rs.getString(6), rs.getString(7), rs.getString(9), rs.getString(8)));
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

            PreparedStatement stmt = con.prepareStatement("SELECT * FROM `user` WHERE `rodzaj` = 'worker'");
            String zapytanie = "Select * FROM user ORDER BY user_id LIMIT " + index;
            ResultSet rs = stmt.executeQuery(zapytanie);
            String a = "0";
            int i=0;
            while(rs.next()) {
                a = rs.getString(1);
                i++;
            }
            int numer = Integer.parseInt(a);
            System.out.println(numer);


            zapytanie = "Select * FROM user where user_id = " + numer;
            ResultSet rs2 = stmt.executeQuery(zapytanie);
            System.out.println(rs2);
            if(rs2.next()) {
                dane.add(rs2.getString("imie"));
                dane.add(rs2.getString("nazwisko"));
                dane.add(rs2.getString("login"));
                dane.add(rs2.getString("pesel"));
                dane.add(rs2.getString("data_urodzenia"));
                dane.add(rs.getString("miejscowosc"));
                dane.add(rs.getString("telefon"));
                dane.add(rs.getString("email"));
                imiePracownik.setText(String.valueOf(dane.get(0)));
                nazwiskoPracownik.setText(String.valueOf(dane.get(1)));
                loginPracownik.setText(String.valueOf(dane.get(2)));
                peselPracownik.setText(String.valueOf(dane.get(3)));
                dataPracownik.setText(String.valueOf(dane.get(4)));
                miejscowoscPracownik.setText(String.valueOf(dane.get(5)));
                telefonPracownik.setText(String.valueOf(dane.get(6)));
                emailPracownik.setText(String.valueOf(dane.get(7)));

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

            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM `user` WHERE `rodzaj` = 'worker'");

            while (rs.next()){
                oblist2.add(new ModelTablePracownicy(rs.getString(4), rs.getString(5),rs.getString(2),rs.getString(10), rs.getString(6), rs.getString(7), rs.getString(9), rs.getString(8)));
            }


        }catch (SQLException ex){
            Logger.getLogger(zarzadzajUzytkownikamiAdminController.class.getName()).log(Level.SEVERE,null, ex);
        }



        col_imie.setCellValueFactory(new PropertyValueFactory<>("imie"));
        col_nazwisko.setCellValueFactory(new PropertyValueFactory<>("nazwisko"));
        col_login.setCellValueFactory(new PropertyValueFactory<>("login"));
        col_pesel.setCellValueFactory(new PropertyValueFactory<>("pesel"));
        col_data.setCellValueFactory(new PropertyValueFactory<>("data urodzenia"));
        col_miejscowosc.setCellValueFactory(new PropertyValueFactory<>("miejscowosc"));
        col_telefon.setCellValueFactory(new PropertyValueFactory<>("telefon"));
        col_email.setCellValueFactory(new PropertyValueFactory<>("email"));

        tabelka_pracownicy.setItems(oblist2);


    }


}