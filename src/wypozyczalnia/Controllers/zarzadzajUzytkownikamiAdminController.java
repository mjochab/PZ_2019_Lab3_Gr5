package wypozyczalnia.Controllers;

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
import wypozyczalnia.DBConnector;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class zarzadzajUzytkownikamiAdminController implements Initializable  {
    @FXML
    private AnchorPane adminPane;
    private AnchorPane zarzadzajPojazdamiPane;


    @FXML
    private TableView<ModelTableUser> tabelka;
    @FXML
    private TableColumn<ModelTableUser, String> col_login;
    @FXML
    private TableColumn<ModelTableUser, String> col_haslo;
    @FXML
    private TableColumn<ModelTableUser, String> col_imie;
    @FXML
    private TableColumn<ModelTableUser, String> col_nazwisko;
    @FXML
    private TableColumn<ModelTableUser, Date> col_data;
    @FXML
    private TableColumn<ModelTableUser, String> col_miejscowosc;
    @FXML
    private TableColumn<ModelTableUser, String> col_tel;
    @FXML
    private TableColumn<ModelTableUser, String> col_mail;
    @FXML
    private TableColumn<ModelTableUser, Long> col_pesel;

    @FXML private TextField userLogin;
    @FXML private TextField userHaslo;
    @FXML private TextField userImie;
    @FXML private TextField userNazwisko;
    @FXML private TextField userData;
    @FXML private TextField userMiejscowosc;
    @FXML private TextField userTelefon;
    @FXML private TextField userMail;
    @FXML private TextField userPesel;
    ObservableList<ModelTableUser> oblist = FXCollections.observableArrayList();

    public void dodajUsera(ActionEvent event) throws IOException{

        String login = String.valueOf(userLogin.getCharacters());
        String haslo = String.valueOf(userHaslo.getCharacters());
        String imie = String.valueOf(userImie.getCharacters());
        String nazwisko = String.valueOf(userNazwisko.getCharacters());
        String data = String.valueOf(userData.getCharacters());
        String miejscowosc = String.valueOf(userMiejscowosc.getCharacters());
        String telefon = String.valueOf(userTelefon.getCharacters());
        String mail = String.valueOf(userMail.getCharacters());
        String pesel = String.valueOf(userPesel.getCharacters());


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/projekt_zespolowe?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            PreparedStatement stmt2 = con.prepareStatement("Select MAX(samochod_id) FROM user");
            ResultSet rs = stmt2.executeQuery("Select * FROM user");
            int i=1;
            while(rs.next()){
                i++;
            }
            String puste= " ";

            PreparedStatement stmt = con.prepareStatement("INSERT INTO user VALUES(?,?,?,?,?,?,?,?,?,?)");
            stmt.setInt(1, i);
            stmt.setString(2, login);
            stmt.setString(3, haslo);
            stmt.setString(4, imie);
            stmt.setString(5, nazwisko);
            stmt.setString(6, data);
            stmt.setString(7, miejscowosc);
            stmt.setString(8, telefon);
            stmt.setString(9, mail);
            stmt.setString(10, pesel);
            stmt.executeUpdate();

            rs = stmt2.executeQuery("SELECT * FROM `user` WHERE user_id = (SELECT MAX(user_id) FROM user)");
            if(rs.next()) {
                System.out.println(rs.getString(2));
              //  oblist.add(new ModelTableUser( rs.getString(2), rs.getString(3),rs.getString(4), rs.getString(5),rs.getString(6)));
            }

        }catch (Exception e)
        {
            System.out.println(e);
        };
    }
    public void logOut(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/login.fxml"));
        adminPane.getChildren().setAll(pane);
    }

    public void menuAdmin(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/menuAdmin.fxml"));
        adminPane.getChildren().setAll(pane);
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            Connection con = DBConnector.getConnection();

            ResultSet rs = con.createStatement().executeQuery("select * from user where Rodzaj = 'klient'");

            while (rs.next()){
                oblist.add(new ModelTableUser( rs.getString(2), rs.getString(3),rs.getString(4), rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10)));
            }


        }catch (SQLException ex){
            Logger.getLogger(zarzadzajUzytkownikamiAdminController.class.getName()).log(Level.SEVERE,null, ex);
        }


        col_login.setCellValueFactory(new PropertyValueFactory<>("login"));
        col_haslo.setCellValueFactory(new PropertyValueFactory<>("haslo"));
        col_imie.setCellValueFactory(new PropertyValueFactory<>("imie"));
        col_nazwisko.setCellValueFactory(new PropertyValueFactory<>("nazwisko"));
        col_data.setCellValueFactory(new PropertyValueFactory<>("data_urodzenia"));
        col_miejscowosc.setCellValueFactory(new PropertyValueFactory<>("miejscowosc"));
        col_tel.setCellValueFactory(new PropertyValueFactory<>("tel"));
        col_mail.setCellValueFactory(new PropertyValueFactory<>("mail"));
        col_pesel.setCellValueFactory(new PropertyValueFactory<>("pesel"));

        tabelka.setItems(oblist);



    }
}
