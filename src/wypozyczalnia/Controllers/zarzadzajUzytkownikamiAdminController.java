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

public class zarzadzajUzytkownikamiAdminController implements Initializable  {
    @FXML
    private AnchorPane adminPane;
    private AnchorPane zarzadzajPojazdamiPane;


    @FXML
    private TableView<ModelTable> tabelka;
    @FXML
    private TableColumn<ModelTablePracownicy, String> col_imie;
    @FXML
    private TableColumn<ModelTablePracownicy, String> col_nazwisko;
    @FXML
    private TableColumn<ModelTablePracownicy, String> col_pesel;
    @FXML
    private TableColumn<ModelTablePracownicy, String> col_miejscowosc;
    @FXML
    private TableColumn<ModelTablePracownicy, String> col_telefon;
    @FXML
    private TableColumn<ModelTablePracownicy, String> col_email;
    @FXML
    private TableColumn<ModelTablePracownicy, String> col_login;
    @FXML
    private TableColumn<ModelTablePracownicy, String> col_data;

    @FXML private TextField userImie;
    @FXML private TextField userNazwisko;
    @FXML private TextField userData;
    @FXML private TextField userMiejscowosc;
    @FXML private TextField userPesel;
    @FXML private TextField userLogin;
    @FXML private TextField userTelefon;
    @FXML private TextField userEmail;

    public void logOut(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/login.fxml"));
        adminPane.getChildren().setAll(pane);
    }

    public void menuAdmin(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/menuAdmin.fxml"));
        adminPane.getChildren().setAll(pane);
    }



    ObservableList<ModelTable> oblist = FXCollections.observableArrayList();

    public void dodajUsera(ActionEvent event) throws IOException{
        String imie = String.valueOf(userImie.getCharacters());
        String nazwisko = String.valueOf(userNazwisko.getCharacters());
        String data = String.valueOf(userData.getCharacters());
        String miejscowosc = String.valueOf(userMiejscowosc.getCharacters());
        String pesel = String.valueOf(userPesel.getCharacters());
        String login = String.valueOf(userLogin.getCharacters());
        String email = String.valueOf(userEmail.getCharacters());
        String telefon = String.valueOf(userTelefon.getCharacters());


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/projekt_zespolowe?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            PreparedStatement stmt2 = con.prepareStatement("Select MAX(user_id) FROM user");
            ResultSet rs = stmt2.executeQuery("SELECT * FROM `user` WHERE `rodzaj` = 'klient'");
            int i=1;
            while(rs.next()){
                i++;
            }
            String puste= " ";

            PreparedStatement stmt = con.prepareStatement("INSERT INTO user VALUES(?,?,?,?,?,?,?,?,?,?,?)");
            stmt.setInt(1, i);
            stmt.setString(2, puste);
            stmt.setString(3, puste);
            stmt.setString(4, imie);
            stmt.setString(5, nazwisko);
            stmt.setString(6, data);
            stmt.setString(7, miejscowosc);
            stmt.setString(8, pesel);
            stmt.setString(9,login);
            stmt.setString(10,telefon);
            stmt.setString(11,email);
            stmt.executeUpdate();

            rs = stmt2.executeQuery("SELECT * FROM `user` WHERE user_id = (SELECT MAX(user_id) FROM user)");
            if(rs.next()) {
                System.out.println(rs.getString(2));
                oblist.add(new ModelTable( rs.getString(4), rs.getString(5),rs.getString(6), rs.getString(7),""+ rs.getLong(8), rs.getString(10), rs.getString(9), rs.getString(11)));
            }

        }catch (Exception e)
        {
            System.out.println(e);
        }
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/zarzadzajUzytkownikamiAdmin.fxml"));
        adminPane.getChildren().setAll(pane);
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

            PreparedStatement stmt = con.prepareStatement("SELECT * FROM `user` WHERE `rodzaj` = 'klient'");
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


            String model, rodzaj, paliwo, przebieg, cena;
            zapytanie = "Select * FROM klient where klient_id = " + numer;
            ResultSet rs2 = stmt.executeQuery(zapytanie);
            System.out.println(rs2);
            if(rs2.next()) {
                dane.add(rs2.getString("imie"));
                dane.add(rs2.getString("nazwisko"));
                dane.add(rs2.getString("data_urodzenia"));
                dane.add(rs2.getString("miejscowosc"));
                dane.add(rs2.getString("pesel"));
                dane.add(rs2.getString("login"));
                dane.add(rs2.getString("telefon"));
                dane.add(rs2.getString("email"));

                userImie.setText(String.valueOf(dane.get(0)));
                userNazwisko.setText(String.valueOf(dane.get(1)));
                userData.setText(String.valueOf(dane.get(2)));
                userMiejscowosc.setText(String.valueOf(dane.get(3)));
                userPesel.setText(String.valueOf(dane.get(4)));
                userLogin.setText(String.valueOf(dane.get(5)));
                userTelefon.setText(String.valueOf(dane.get(6)));
                userEmail.setText(String.valueOf(dane.get(7)));

            }


        }catch (Exception e)
        {
            System.out.println(e);
        };

    }

    public void modujKlient(ActionEvent event) throws  IOException{
        System.out.println("-");

        TablePosition pozycja = tabelka.getSelectionModel().getSelectedCells().get(0);
        int index = pozycja.getRow();

        String imie = String.valueOf(userImie.getCharacters());
        String nazwisko = String.valueOf(userNazwisko.getCharacters());
        String data_urodzenia = String.valueOf(userData.getCharacters());
        String miejscowosc = String.valueOf(userMiejscowosc.getCharacters());
        String pesel = String.valueOf(userPesel.getCharacters());
        String login = String.valueOf(userLogin.getCharacters());
        String telefon = String.valueOf(userTelefon.getCharacters());
        String email = String.valueOf(userEmail.getCharacters());


        try {
            index++;
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/projekt_zespolowe?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");

            PreparedStatement stmt = con.prepareStatement("SELECT * FROM `user` WHERE `rodzaj` = 'klient'");
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
            PreparedStatement stmt2 = con.prepareStatement("UPDATE `user` SET `imie`=(?),`nazwisko`=(?),`login`=(?),`pesel`=(?),`data_urodzenia`=(?),`miejscowosc`=(?),`telefon`=(?),`email`=(?), WHERE user_id=(?)");
            stmt2.setString(1, imie);
            stmt2.setString(2, nazwisko);
            stmt2.setString(3, login);
            stmt2.setString(4, pesel);
            stmt2.setString(5, data_urodzenia);
            stmt2.setString(6, miejscowosc);
            stmt2.setString(7, telefon);
            stmt2.setString(8, email);
            stmt2.setInt(9, numer);

            stmt2.executeUpdate();


        }catch (Exception e)
        {
            System.out.println(e);
        }
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/zarzadzajUzytkownikamiAdmin.fxml"));
        adminPane.getChildren().setAll(pane);
        tabelka.refresh();

    }

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
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/zarzadzajUzytkownikamiAdmin.fxml"));
        adminPane.getChildren().setAll(pane);

        tabelka.refresh();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            Connection con = DBConnector.getConnection();

            ResultSet rs = con.createStatement().executeQuery("select * from klient");

            while (rs.next()){
                oblist.add(new ModelTable(rs.getString(4), rs.getString(5),rs.getString(2),rs.getString(10), rs.getString(6), rs.getString(7), rs.getString(9), rs.getString(8)));
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

        tabelka.setItems(oblist);



    }
}
