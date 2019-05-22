package wypozyczalnia.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import wypozyczalnia.DBConnector;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class zarzadzajWypozyczeniamiController {
    @FXML
    private AnchorPane pracownikPane;
    private AnchorPane zarzadzajPojazdamiPane;

    ObservableList<ModelTableWypozyczenie> oblist1 = FXCollections.observableArrayList();
    ObservableList<ModelTable> oblist2 = FXCollections.observableArrayList();
    @FXML private TextField Tpesel;
    @FXML private TextField Tmarka;
    @FXML private TextField Tcena;
    @FXML private TextField TdataStart;
    @FXML private TextField TdataKoniec;
    @FXML private TextField Tmodel;

   @FXML
    private TableView<ModelTableWypozyczenie> tabelka_wypozyczenie;
    @FXML
    private TableColumn<ModelTablePojazdy, String> col_user_id;
    @FXML
    private TableColumn<ModelTablePojazdy, String> samochod_id;
    @FXML
    private TableColumn<ModelTablePojazdy, String> col_odkiedy;
    @FXML
    private TableColumn<ModelTablePojazdy, String> col_dokiedy;
    @FXML
    private TableColumn<ModelTablePojazdy, String> col_wypozyczenie_id;
    @FXML
    private TableColumn<ModelTablePojazdy, String> col_przebieg;
    @FXML
    private TableColumn<ModelTablePojazdy, String> col_cena;
    @FXML
    private TableColumn<ModelTablePojazdy, String> col_dostepnosc;

    public void logOut(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/login.fxml"));
        pracownikPane.getChildren().setAll(pane);
    }
    public void uruchom1(ActionEvent event) throws IOException {


    }
    public void menuPracownik(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/menuPracownik.fxml"));
        pracownikPane.getChildren().setAll(pane);
    }

    public void alamakota(ActionEvent event) throws  IOException{

    }
    public void dodajWypo(ActionEvent event) throws IOException {
        System.out.println("2");
        String pesel = String.valueOf(this.Tpesel.getCharacters());
        String marka = String.valueOf(this.Tmarka.getCharacters());
        String cena = String.valueOf(this.Tcena.getCharacters());
        String dataStart = String.valueOf(this.TdataStart.getCharacters());
        String dataKoniec = String.valueOf(this.TdataKoniec.getCharacters());
        String model = String.valueOf(this.Tmodel.getCharacters());

        try {
            String idUser = "1";
            String idAuto = "1";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/projekt_zespolowe?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            PreparedStatement stmt2 = con.prepareStatement("Select MAX(wypozyczenie_id) FROM wypozyczenie");
            ResultSet rs = stmt2.executeQuery("Select * FROM wypozyczenia");

            int i;
            for (i = 1; rs.next(); ++i) {
            }
            System.out.println(i);

            PreparedStatement stm2 = con.prepareStatement("select user_id from user where pesel = (?) limit 1");
            stm2.setString(1, pesel);
            stm2.executeQuery();
            String zapytanie = "select user_id from user where pesel = " + pesel +" limit 1";
            rs = stm2.executeQuery("select user_id from user where pesel = + + limit 1");
            while(rs.next()) {
                idUser = rs.getString(1);
                i++;
            } //pobranie id usera

            PreparedStatement stm = con.prepareStatement("select samochod_id from samochod where marka = (?) and model = (?) limit 1");
            stm.setString(1, marka);
            stm.setString(2, model);
            stm.executeQuery();                 //pobranie id auta
            zapytanie = "select samochod_id from samochod where marka = "+ marka + " and model = "+ model +" limit 1";
            rs = stm.executeQuery(zapytanie);
            while(rs.next()) {
                idAuto = rs.getString(1);
                i++;
            }   //pobranie id auta



            PreparedStatement stmt = con.prepareStatement("INSERT INTO wypozyczenie VALUES(?,?,?, ?,?)");
            stmt.setInt(1, i);
            stmt.setString(2, idUser);
            stmt.setString(3, idAuto);
            stmt.setString(4, dataStart);
            stmt.setString(5, dataKoniec);
            stmt.executeUpdate();


        } catch (Exception var14) {
            System.out.println(var14);
        }

    }

    public void modujWypo(ActionEvent event) throws  IOException{

        TablePosition pozycja = tabelka_wypozyczenie.getSelectionModel().getSelectedCells().get(0);
        int index = pozycja.getRow();

        String pesel = String.valueOf(Tpesel.getCharacters());
        String marka = String.valueOf(Tmarka.getCharacters());
        String model = String.valueOf(Tmodel.getCharacters());
        String cena = String.valueOf(Tcena.getCharacters());
        String dataStart = String.valueOf(TdataStart.getCharacters());
        String dataStop = String.valueOf(TdataStart.getCharacters());

        try {
            index++;
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/projekt_zespolowe?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");

            PreparedStatement stmt = con.prepareStatement("SELECT * FROM samochod");
            String zapytanie = "Select * FROM wypozyczenie ORDER BY wypozyczenie_id LIMIT " + index;
            ResultSet rs = stmt.executeQuery(zapytanie);
            String a = "0";
            int i=0;
            while(rs.next()) {
                a = rs.getString(1);
                i++;
            }
            int numer = Integer.parseInt(a);
            System.out.println(numer);

            String czlowiekID = "1";

            stmt = con.prepareStatement("SELECT * FROM samochod");
            rs = stmt.executeQuery("select user_id from user where pesel = + + limit 1");
            while(rs.next()) {
                czlowiekID = rs.getString(1);
                i++;
            }

            String autoID ="1";
            rs = stmt.executeQuery("select samochod_id from samochod where pesel = + + limit 1");
            while(rs.next()) {
                autoID = rs.getString(1);
                i++;
            }



            PreparedStatement stmt2 = con.prepareStatement("UPDATE `wypozyczenie` SET `user_id`=(?),`samochod_id`=(?),`data_od`=(?),`dataStop`=(?), wypozyczenie_id=(?)");
            stmt2.setString(1, czlowiekID);
            stmt2.setString(2, autoID);
            stmt2.setString(3, dataStart);
            stmt2.setString(4, dataStop);
            stmt2.setInt(5, numer);
            stmt2.executeUpdate();


        }catch (Exception e)
        {
            System.out.println(e);
        }
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/zarzadzajPojazdami.fxml"));
        pracownikPane.getChildren().setAll(pane);

    }


    //@Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            Connection con = DBConnector.getConnection();

            ResultSet rs = con.createStatement().executeQuery("select * from wypozyczenie");

            while (rs.next()) {
                //oblist1.add(new ModelTablePojazdy(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));
                //oblist1.add(new ModelTablePojazdy(rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7), rs.getString(8),rs.getString(9)));
            }


        } catch (SQLException ex) {
            Logger.getLogger(zarzadzajUzytkownikamiAdminController.class.getName()).log(Level.SEVERE, null, ex);
        }


        //col_marka.setCellValueFactory(new PropertyValueFactory<>("marka"));
        //col_model.setCellValueFactory(new PropertyValueFactory<>("model"));
        //col_rodzaj.setCellValueFactory(new PropertyValueFactory<>("rodzaj"));
        //col_rocznik.setCellValueFactory(new PropertyValueFactory<>("rocznik"));
        //col_paliwo.setCellValueFactory(new PropertyValueFactory<>("paliwo"));
        //col_przebieg.setCellValueFactory(new PropertyValueFactory<>("przebieg"));
        //col_cena.setCellValueFactory(new PropertyValueFactory<>("cena"));
        //col_dostepnosc.setCellValueFactory(new PropertyValueFactory<>("dostepnosc"));

        //tabelka_pojazdy.setItems(oblist1);

    }


}
