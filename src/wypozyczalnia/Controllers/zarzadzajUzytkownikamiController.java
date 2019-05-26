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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class zarzadzajUzytkownikamiController implements Initializable {
    @FXML
    private AnchorPane pracownikPane;
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

    @FXML private TextField userImie;
    @FXML private TextField userNazwisko;
    @FXML private DatePicker userData;
    @FXML private TextField userMiejscowosc;
    @FXML private TextField userPesel;
    @FXML private TextField userEmail;
    @FXML private TextField userLogin;
    @FXML private TextField userHaslo;
    @FXML private TextField userTelefon;


    ObservableList<ModelTable> oblist2 = FXCollections.observableArrayList();

    public void clearFields(ActionEvent event) throws IOException {
        userLogin.clear();
        userHaslo.clear();
        userData.setValue(null);
        userEmail.clear();
        userMiejscowosc.clear();
        userNazwisko.clear();
        userImie.clear();
        userPesel.clear();
        userTelefon.clear();
    }

    public void logOut(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/login.fxml"));
        pracownikPane.getChildren().setAll(pane);
    }

    public void menuPracownik(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/menuPracownik.fxml"));
        pracownikPane.getChildren().setAll(pane);
    }

    private boolean walidacjaPol() {
        if (userImie.getText().isEmpty() | userNazwisko.getText().isEmpty() | userLogin.getText().isEmpty()
                | userEmail.getText().isEmpty() | userTelefon.getText().isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Informacja");
            alert.setHeaderText(null);
            alert.setContentText("Uzupełnij wszystkie pola");
            alert.showAndWait();


            return false;
        }
        if (userMiejscowosc.getText().isEmpty() | userPesel.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Informacja");
            alert.setHeaderText(null);
            alert.setContentText("Uzupełnij wszystkie pola");
            alert.showAndWait();

            return false;
        }
        return true;
    }


    private boolean walidacjaImie(){
        Pattern p = Pattern.compile("[A-ZĄĘŁŃÓŚŹŻ][a-ząćęłńóśźż]+");
        Matcher m = p.matcher(userImie.getText());

        if(m.find() && m.group().equals(userImie.getText())){
            return true;
        }else
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Informacja");
            alert.setHeaderText(null);
            alert.setContentText("Znaki specjalne w imieniu nie są obsługiwane");
            alert.showAndWait();

            return false;
        }
    }

    private boolean walidacjaNazwisko(){
        Pattern p = Pattern.compile("[A-ZĄĘŁŃÓŚŹŻ][a-ząćęłńóśźż]+");
        Matcher m = p.matcher(userNazwisko.getText());

        if(m.find() && m.group().equals(userNazwisko.getText())){
            return true;
        }else
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Informacja");
            alert.setHeaderText(null);
            alert.setContentText("Znaki specjalne w nazwisku nie są obsługiwane");
            alert.showAndWait();

            return false;
        }
    }

    private boolean walidacjaMiejscowosc(){
        Pattern p = Pattern.compile("[A-ZĄĘŁŃÓŚŹŻ][a-ząćęłńóśźż]+");
        Matcher m = p.matcher(userMiejscowosc.getText());

        if(m.find() && m.group().equals(userMiejscowosc.getText())){
            return true;
        }else
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Informacja");
            alert.setHeaderText(null);
            alert.setContentText("Znaki specjalne w nazwie miejscowości nie są obsługiwane");
            alert.showAndWait();

            return false;
        }

    }

    private boolean walidacjaEmail(){
        Pattern p = Pattern.compile("^(.+)@(.+)$");
        Matcher m = p.matcher(userEmail.getText());

        if(m.find() && m.group().equals(userEmail.getText())){
            return true;
        }else
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Informacja");
            alert.setHeaderText(null);
            alert.setContentText("Email niepoprawny");
            alert.showAndWait();

            return false;
        }

    }

    private boolean walidacjaPesel(){
        Pattern p = Pattern.compile("^[0-9]{11}$");
        Matcher m = p.matcher(userPesel.getText());

        if(m.find() && m.group().equals(userPesel.getText())){
            return true;
        }else
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Informacja");
            alert.setHeaderText(null);
            alert.setContentText("PESEL niepoprawny");
            alert.showAndWait();

            return false;
        }

    }

    public void modujUser(ActionEvent event) throws  IOException {
        System.out.println("-");
        String imie = String.valueOf(userImie.getCharacters());
        String nazwisko = String.valueOf(userNazwisko.getCharacters());
        String login = String.valueOf(userLogin.getCharacters());
        String pesel = String.valueOf(userPesel.getText());
        String data_urodzenia = userData.getValue().toString();
        String miejscowosc = String.valueOf(userMiejscowosc.getCharacters());
        String telefon = String.valueOf(userTelefon.getCharacters());
        String email = String.valueOf(userEmail.getCharacters());
        String haslo = String.valueOf(userHaslo.getCharacters());


        TablePosition pozycja = tabelka.getSelectionModel().getSelectedCells().get(0);
        int index = pozycja.getRow();

        if (walidacjaPol() & walidacjaImie() & walidacjaNazwisko() & walidacjaMiejscowosc() & walidacjaEmail() & walidacjaPesel() )
            try {
                index++;
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/projekt_zespolowe?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");

                PreparedStatement stmt = con.prepareStatement("SELECT * FROM user");
                String zapytanie = "Select * FROM user ORDER BY user_id LIMIT " + index;
                ResultSet rs = stmt.executeQuery(zapytanie);
                String a = "0";
                int i = 0;
                while (rs.next()) {
                    a = rs.getString(1);
                    i++;
                }
                int numer = Integer.parseInt(a);

                System.out.println(numer);
                PreparedStatement stmt2 = con.prepareStatement("UPDATE `user` SET `imie`=(?),`nazwisko`=(?),`login`=(?),`haslo`=(?),`pesel`=(?),`data_urodzenia`=(?),`miejscowosc`=(?),`tel`=(?), `email`=(?) WHERE user_id=(?)");
                stmt2.setString(1, imie);
                stmt2.setString(2, nazwisko);
                stmt2.setString(3, login);
                stmt2.setString(4, haslo);
                stmt2.setString(5, pesel);
                stmt2.setString(6, data_urodzenia);
                stmt2.setString(7, miejscowosc);
                stmt2.setString(8, telefon);
                stmt2.setString(9, email);
                stmt2.setInt(10, numer);

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Informacja");
                alert.setHeaderText(null);
                alert.setContentText("Dane klienta zostały zmodyfikowane pomyślnie!");
                alert.showAndWait();

                stmt2.executeUpdate();
                tabelka.refresh();


            } catch (Exception e) {
                System.out.println(e);
            }
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/zarzadzajUzytkownikami.fxml"));
        pracownikPane.getChildren().setAll(pane);

    }

    public void usunKlient(ActionEvent event) throws IOException {
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

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Informacja");
            alert.setHeaderText(null);
            alert.setContentText("Pomyślnie usunięto klienta!");
            alert.showAndWait();


            stmt2.executeUpdate();


        }catch (Exception e)
        {
            System.out.println(e);
        };
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/zarzadzajUzytkownikami.fxml"));
        pracownikPane.getChildren().setAll(pane);

        tabelka.refresh();
    }

    public void datazpeselu (MouseEvent event) throws  IOException{

        String pesel1 = String.valueOf(userPesel.getText());
        Character data_r1 = pesel1.charAt(0);
        Character data_r2 = pesel1.charAt(1);
        Character data_m1 = pesel1.charAt(2);
        Character data_m2 = pesel1.charAt(3);
        Character data_d1 = pesel1.charAt(4);
        Character data_d2 = pesel1.charAt(5);
        String datarok = "";

        String data_rok = data_r1.toString() + data_r2.toString();
        int data_rok_int = Integer.parseInt(data_rok);
        if(data_rok_int>10)
        {
            datarok = "19"+data_rok_int;
        }

        String data_msc = data_m1.toString() + data_m2.toString();
        String data_dzien = data_d1.toString() + data_d2.toString();
        String data_urodzenia = datarok +"-"+data_msc+"-"+data_dzien;
        userData.setValue(LocalDate.parse(data_urodzenia));

    }

    public void dodajKlienta(ActionEvent event) throws IOException{

        String imie = String.valueOf(userImie.getCharacters());
        String nazwisko = String.valueOf(userNazwisko.getCharacters());
        String login = String.valueOf(userLogin.getCharacters());
        String pesel = String.valueOf(userPesel.getText());
        String data_urodzenia = userData.getValue().toString();
        String miejscowosc = String.valueOf(userMiejscowosc.getCharacters());
        String telefon = String.valueOf(userTelefon.getCharacters());
        String email = String.valueOf(userEmail.getCharacters());

        if (walidacjaPol() & walidacjaImie() & walidacjaNazwisko() & walidacjaMiejscowosc() & walidacjaEmail() & walidacjaPesel())
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/projekt_zespolowe?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
                PreparedStatement stmt2 = con.prepareStatement("Select MAX(user_id) FROM `user` WHERE `rodzaj` = 'klient'");
                ResultSet rs = stmt2.executeQuery("SELECT * FROM `user` WHERE `rodzaj` = 'klient'");
                int i=1;
                int n=1;
                while(rs.next()){
                    i++;
                }
                Integer puste= i+1;
                String haslo= "haslo";
                String rodzaj = "klient";

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
                    oblist2.add(new ModelTable( rs.getString(4),rs.getString(5),rs.getString(6), rs.getString(7), rs.getString(10), rs.getString(8), rs.getString(2), rs.getString(9)));
                }

            }catch (Exception e)
            {
                System.out.println(e);
            }
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/zarzadzajUzytkownikami.fxml"));
        pracownikPane.getChildren().setAll(pane);
        tabelka.refresh();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            Connection con = DBConnector.getConnection();

            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM `user` WHERE `rodzaj` = 'klient'");



            while (rs.next()){
                oblist2.add(new ModelTable(rs.getString(4), rs.getString(5),rs.getString(6), rs.getString(7), rs.getString(10), rs.getString(8), rs.getString(2),rs.getString(9)));
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

        tabelka.setItems(oblist2);


        tabelka.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
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
                    String zapytanie = "Select * FROM user WHERE `rodzaj` = 'klient' ORDER BY user_id LIMIT " + index;
                    ResultSet rs = stmt.executeQuery(zapytanie);
                    String a = "0";
                    int i=0;
                    while(rs.next()) {
                        a = rs.getString(1);
                        i++;
                    }
                    int numer = Integer.parseInt(a);
                    System.out.println(numer);

                    zapytanie = "SELECT * FROM `user` WHERE `rodzaj` = 'klient' AND `user_id` = " + numer;
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
                        userData.setValue(LocalDate.parse(dane.get(4)));
                        userMiejscowosc.setText(String.valueOf(dane.get(5)));
                        userTelefon.setText(String.valueOf(dane.get(6)));
                        userEmail.setText(String.valueOf(dane.get(7)));
                        userPesel.setText(String.valueOf(dane.get(8)));

                    }


                }catch (Exception e)
                {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Informacja");
                    alert.setHeaderText(null);
                    alert.setContentText("Zaznacz linie!");
                    alert.showAndWait();
                };

            }
        }  );


    }}


