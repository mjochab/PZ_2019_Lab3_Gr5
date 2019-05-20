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
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class zarzadzajUzytkownikamiController implements Initializable {
    @FXML
    private AnchorPane pracownikPane;
    private AnchorPane zarzadzajPojazdamiPane;

    @FXML
    private TableView<ModelTable> tabelka;
    @FXML
    private TableColumn<ModelTable, String> col_imie;
    @FXML
    private TableColumn<ModelTable, String> col_nazwisko;
    @FXML
    private TableColumn<ModelTable, Date> col_data;
    @FXML
    private TableColumn<ModelTable, String> col_miejscowosc;
    @FXML
    private TableColumn<ModelTable, String> col_pesel;
    @FXML
    private TableColumn<ModelTable, String> col_login;
    @FXML
    private TableColumn<ModelTable, String> col_haslo;
    @FXML
    private TableColumn<ModelTable, String> col_email;
    @FXML
    private TableColumn<ModelTable, String> col_telefon;


    ObservableList<ModelTable> oblist = FXCollections.observableArrayList();

    @FXML private TextField userImie;
    @FXML private TextField userNazwisko;
    @FXML private TextField userData;
    @FXML private TextField userMiejscowosc;
    @FXML private TextField userPesel;
    @FXML private TextField userEmail;
    @FXML private TextField userLogin;
    @FXML private TextField userHaslo;
    @FXML private TextField userTelefon;

    public void usunKlient(ActionEvent event) throws  IOException{
        TablePosition pozycja = tabelka.getSelectionModel().getSelectedCells().get(0);
        int index = pozycja.getRow();

        try {
            index++;
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/projekt_zespolowe?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");

            PreparedStatement stmt = con.prepareStatement("SELECT * FROM user");
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

            PreparedStatement stmt2 = con.prepareStatement("DELETE FROM user WHERE user_id = (?)");
            stmt2.setInt(1, numer);
            stmt2.executeUpdate();


        }catch (Exception e)
        {
            System.out.println(e);
        };
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/zarzadzajUzytkownikami.fxml"));
        pracownikPane.getChildren().setAll(pane);

        tabelka.refresh();
    }


    public void klik(ActionEvent event) throws  IOException{        //funkcja przenosi dane do tabelki po lewej stronie, jak tyknie sie wiersz w tabeli to przenosi
        //TablePosition pozycja = tabelka_pojazdy.getSelectionModel().getSelectedCells().get(0);
        //int index = pozycja.getRow();
        String abc;
        abc = tabelka.toString();
        System.out.println(abc);
        ArrayList<String> dane = new ArrayList<String>();
        try {
            TablePosition pozycja = tabelka.getSelectionModel().getSelectedCells().get(0);
            int index = pozycja.getRow();

            index++;
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/projekt_zespolowe?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");

            PreparedStatement stmt = con.prepareStatement("SELECT * FROM user");
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
                dane.add(rs2.getString("login"));
                dane.add(rs2.getString("haslo"));
                dane.add(rs2.getString("imie"));
                dane.add(rs2.getString("nazwisko"));
                dane.add(rs2.getString("data_urodzenia"));
                dane.add(rs2.getString("miejscowosc"));
                dane.add(rs2.getString("tel"));
                dane.add(rs2.getString("email"));
                dane.add(rs2.getString("pesel"));


                userLogin.setText(String.valueOf(dane.get(0)));
                userHaslo.setText(String.valueOf(dane.get(1)));
                userImie.setText(String.valueOf(dane.get(2)));
                userNazwisko.setText(String.valueOf(dane.get(3)));
                userData.setText(String.valueOf(dane.get(4)));
                userMiejscowosc.setText(String.valueOf(dane.get(5)));
                userTelefon.setText(String.valueOf(dane.get(6)));
                userEmail.setText(String.valueOf(dane.get(7)));
                userPesel.setText(String.valueOf(dane.get(8)));


            }


        }catch (Exception e)
        {
            System.out.println(e);
        };


    }

    public void modujUser(ActionEvent event) throws  IOException{
        System.out.println("-");

        TablePosition pozycja = tabelka.getSelectionModel().getSelectedCells().get(0);
        int index = pozycja.getRow();

        String login = String.valueOf(userLogin.getCharacters());
        String haslo = String.valueOf(userHaslo.getCharacters());
        String imie = String.valueOf(userImie.getCharacters());
        String nazwisko = String.valueOf(userNazwisko.getCharacters());
        String data = String.valueOf(userData.getCharacters());
        String miejscowosc = String.valueOf(userMiejscowosc.getCharacters());
        String tel = String.valueOf(userTelefon.getCharacters());
        String mail = String.valueOf(userEmail.getCharacters());
        String pesel = String.valueOf(userPesel.getCharacters());
        String rodzaj = "rodzaj";



        try {
            index++;
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/projekt_zespolowe?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");

            PreparedStatement stmt = con.prepareStatement("SELECT * FROM user");
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
            PreparedStatement stmt2 = con.prepareStatement("UPDATE `user` SET `login`=(?),`haslo`=(?),`imie`=(?),`nazwisko`=(?),`data_urodzenia`=(?),`miejscowosc`=(?),`tel`=(?), `email`=(?), `pesel`=(?), `rodzaj`=(?) WHERE user_id=(?)");
            stmt2.setString(1, login);
            stmt2.setString(2, haslo);
            stmt2.setString(3, imie);
            stmt2.setString(4, nazwisko);
            stmt2.setString(5, data);
            stmt2.setString(6, miejscowosc);
            stmt2.setString(7, tel);
            stmt2.setString(8, mail);
            stmt2.setString(9, pesel);
            stmt2.setString(10, rodzaj);
            stmt2.setInt(11, numer);
            stmt2.executeUpdate();
            tabelka.refresh();


        }catch (Exception e)
        {
            System.out.println(e);
        }
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/zarzadzajUzytkownikami.fxml"));
        pracownikPane.getChildren().setAll(pane);

    }


    public void logOut(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/login.fxml"));
        pracownikPane.getChildren().setAll(pane);
    }

    public void menuPracownik(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/menuPracownik.fxml"));
        pracownikPane.getChildren().setAll(pane);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            Connection con = DBConnector.getConnection();

            ResultSet rs = con.createStatement().executeQuery("select * from user");



            while (rs.next()){
                oblist.add(new ModelTable( rs.getString(4), rs.getString(5),rs.getString(6), rs.getString(7), rs.getString(10), rs.getString(8), rs.getString(3),rs.getString(9)));
            }


        }catch (SQLException ex){
            Logger.getLogger(zarzadzajUzytkownikamiAdminController.class.getName()).log(Level.SEVERE,null, ex);
        }


        col_imie.setCellValueFactory(new PropertyValueFactory<>("imie"));
        col_nazwisko.setCellValueFactory(new PropertyValueFactory<>("nazwisko"));
        col_login.setCellValueFactory(new PropertyValueFactory<>("login"));
        col_telefon.setCellValueFactory(new PropertyValueFactory<>("telefon"));
        col_data.setCellValueFactory(new PropertyValueFactory<>("data_urodzenia"));
        col_miejscowosc.setCellValueFactory(new PropertyValueFactory<>("miejscowosc"));
        col_email.setCellValueFactory(new PropertyValueFactory<>("email"));
        col_pesel.setCellValueFactory(new PropertyValueFactory<>("pesel"));

        tabelka.setItems(oblist);



    }
}