package sample.Controllers;

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
import sample.DBConnector;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
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
    private TableColumn<ModelTable, Long> col_pesel;

    ObservableList<ModelTable> oblist = FXCollections.observableArrayList();

    @FXML private TextField userImie;
    @FXML private TextField userNazwisko;
    @FXML private TextField userData;
    @FXML private TextField userMiejscowosc;
    @FXML private TextField userTelefon;
    @FXML private TextField userMail;
    @FXML private TextField userPesel;


    public void dodajUsera(ActionEvent event) throws IOException{
        String imie = String.valueOf(userImie.getCharacters());
        String nazwisko = String.valueOf(userNazwisko.getCharacters());
        String data = String.valueOf(userImie.getCharacters());
        String rocznik = String.valueOf(userData.getCharacters());
        String miejscowosc = String.valueOf(userMiejscowosc.getCharacters());
        String telefon = String.valueOf(userTelefon.getCharacters());
        String mail = String.valueOf(userMail.getCharacters());
        String pesel = String.valueOf(userPesel.getCharacters());


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/projekt_zespolowe?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            PreparedStatement stmt2 = con.prepareStatement("Select MAX(samochod_id) FROM klient");
            ResultSet rs = stmt2.executeQuery("Select * FROM klient");
            int i=1;
            while(rs.next()){
                i++;
            }
            String puste= " ";

            PreparedStatement stmt = con.prepareStatement("INSERT INTO klient VALUES(?,?,?,?,?,?,?,?)");
            stmt.setInt(1, i);
            stmt.setString(2, puste);
            stmt.setString(3, puste);
            stmt.setString(4, imie);
            stmt.setString(5, nazwisko);
            stmt.setString(6, rocznik);
            stmt.setString(7, miejscowosc);
            stmt.setString(8, pesel);
            stmt.executeUpdate();

            rs = stmt2.executeQuery("SELECT * FROM `klient` WHERE klient_id = (SELECT MAX(klient_id) FROM klient)");
            if(rs.next()) {
                System.out.println(rs.getString(2));
                oblist.add(new ModelTable( rs.getString(4), rs.getString(5),rs.getString(6), rs.getString(7),""+ rs.getLong(8)));
            }

        }catch (Exception e)
        {
            System.out.println(e);
        };
    }


    public void updateUser()
    {

        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/projekt_zespolowe?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            PreparedStatement updateQuery = con.prepareStatement("UPDATE klient set login=?, haslo=?, imie=?, nazwisko=?, data_urodzenia=?, miejscowosc=?, pesel=?");

            updateQuery.setString(2, userImie.getText());
            updateQuery.setString(3, userNazwisko.getText());
            updateQuery.setString(4, userData.getText());
            updateQuery.setString(5, userMiejscowosc.getText());
            updateQuery.setString(6, userTelefon.getText());
            updateQuery.setString(7, userPesel.getText());

            updateQuery.executeUpdate();





        }catch (Exception e)
        {
            System.out.println(e);
        }
    }

    public void showOnClick()
    {
        try {

            ModelTable modelTable = (ModelTable) tabelka.getSelectionModel().getSelectedItem();
            String showquery = "SELECT * FROM klient";

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/projekt_zespolowe?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            PreparedStatement updateQuery = con.prepareStatement(showquery);


            userImie.setText(modelTable.getImie());
            userNazwisko.setText(modelTable.getNazwisko());
            userData.setText(modelTable.getData_urodzenia());
            userMiejscowosc.setText(modelTable.getMiejscowosc());
            userPesel.setText(modelTable.getPesel());

            updateQuery.close();
        }
            catch (Exception e)
        {
            System.out.println(e);

        }
    }

    public void deleteUser()
    {

        String imie = null;
        try {

            ModelTable modelTable = (ModelTable) tabelka.getSelectionModel().getSelectedItem();
            String showquery = "DELETE FROM klient where imie=?";

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/projekt_zespolowe?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            PreparedStatement updateQuery = con.prepareStatement(showquery);
            updateQuery.setString(1, modelTable.getImie());
            imie=modelTable.getImie();
            updateQuery.executeUpdate();

            updateQuery.close();
        }
        catch (Exception e)
        {
            System.out.println(e);

        }
    }



    public void logOut(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../Fxml/login.fxml"));
        pracownikPane.getChildren().setAll(pane);
    }

    public void menuPracownik(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../Fxml/menuPracownik.fxml"));
        pracownikPane.getChildren().setAll(pane);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            Connection con = DBConnector.getConnection();

            ResultSet rs = con.createStatement().executeQuery("select * from klient");

            while (rs.next()){
                oblist.add(new ModelTable( rs.getString(4), rs.getString(5),rs.getString(6), rs.getString(7),""+ rs.getLong(8)));
            }


        }catch (SQLException ex){
            Logger.getLogger(zarzadzajUzytkownikamiAdminController.class.getName()).log(Level.SEVERE,null, ex);
        }



        col_imie.setCellValueFactory(new PropertyValueFactory<>("imie"));
        col_nazwisko.setCellValueFactory(new PropertyValueFactory<>("nazwisko"));
        col_data.setCellValueFactory(new PropertyValueFactory<>("data_urodzenia"));
        col_miejscowosc.setCellValueFactory(new PropertyValueFactory<>("miejscowosc"));
        col_pesel.setCellValueFactory(new PropertyValueFactory<>("pesel"));

        tabelka.setItems(oblist);



    }
    public void loadData()
    {
        {

            try {
                Connection con = DBConnector.getConnection();

                ResultSet rs = con.createStatement().executeQuery("select * from klient");

                while (rs.next()) {
                    oblist.add(new ModelTable(rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), "" + rs.getLong(8)));
                }


            } catch (SQLException ex) {
                Logger.getLogger(zarzadzajUzytkownikamiAdminController.class.getName()).log(Level.SEVERE, null, ex);
            }


            tabelka.setItems(oblist);


        }
    }
}