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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class zarzadzajWypozyczeniamiAdminController implements Initializable {
    @FXML
    private AnchorPane adminPane;



    @FXML private DatePicker TdataStart;
    @FXML private DatePicker TdataKoniec;

    @FXML
    private TableView<ModelTableWypozyczenie> tabelka_wypozyczenie;
    @FXML
    private TableColumn<ModelTableWypozyczenie, String> col_Imie;
    @FXML
    private TableColumn<ModelTableWypozyczenie, String> col_Nazwisko;
    @FXML
    private TableColumn<ModelTableWypozyczenie, String> col_DataPoczatkowa;
    @FXML
    private TableColumn<ModelTableWypozyczenie, String> col_DataKoncowa;
    @FXML
    private TableColumn<ModelTableWypozyczenie, String> col_cena;


    ObservableList<ModelTableWypozyczenie> oblist1 = FXCollections.observableArrayList();

    public void logOut(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/login.fxml"));
        adminPane.getChildren().setAll(pane);
    }

    public void menuAdmin(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/menuAdmin.fxml"));
        adminPane.getChildren().setAll(pane);
    }


    public void klik(ActionEvent event) throws  IOException{
        String abc;
        abc = tabelka_wypozyczenie.toString();
        System.out.println(abc);
        ArrayList<String> dane = new ArrayList<String>();
        try {
            TablePosition pozycja = tabelka_wypozyczenie.getSelectionModel().getSelectedCells().get(0);
            int index = pozycja.getRow();
            index++;
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println(index);

            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/projekt_zespolowe?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");

            PreparedStatement stmt = con.prepareStatement("SELECT * FROM wypozyczenie");
            String zapytanie = "Select * FROM wypozyczenie ORDER BY wypozyczenie_id LIMIT " + index;
            ResultSet rs = stmt.executeQuery(zapytanie);
            String a = "0";
            int i=0;
            while(rs.next()) {
                a = rs.getString(1);
                i++;
            }

            zapytanie = "Select data_od, data_do, user_id FROM wypozyczenie ORDER BY wypozyczenie_id LIMIT " + index;
            rs = stmt.executeQuery(zapytanie);
            if(rs.next()){

                TdataStart.setValue(LocalDate.parse(rs.getString(1)));
                TdataKoniec.setValue(LocalDate.parse(rs.getString(2)));

            }

            int numer = Integer.parseInt(a);
            System.out.println(numer);

            zapytanie = "Select * FROM wypozyczenie where wypozyczenie_id = " + numer;



            ResultSet rs2 = stmt.executeQuery(zapytanie);


            int j=0;

        }catch (Exception e)
        {
            System.out.println(e);
        };
    }


    public void modujWypo(ActionEvent event) throws  IOException{

        System.out.println("2");

        TablePosition pozycja = tabelka_wypozyczenie.getSelectionModel().getSelectedCells().get(0);
        int index = pozycja.getRow();

        String dataStart = TdataStart.getValue().toString();
        String dataStop = TdataKoniec.getValue().toString();
        if(walidacajaDataWypozyczenia()) {
            try {
                index++;
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/projekt_zespolowe?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");

                PreparedStatement stmt = con.prepareStatement("SELECT * FROM samochod");
                String zapytanie = "Select * FROM wypozyczenie ORDER BY wypozyczenie_id LIMIT " + index;
                ResultSet rs = stmt.executeQuery(zapytanie);
                String a = "0";
                int i = 0;
                while (rs.next()) {
                    a = rs.getString(1);
                    i++;
                }
                int numer = Integer.parseInt(a);
                System.out.println(numer);

                PreparedStatement stmt2 = con.prepareStatement("UPDATE `wypozyczenie` SET `data_od`=(?),`data_do`=(?) where `wypozyczenie_id`=(?)");
                stmt2.setString(1, dataStart);
                stmt2.setString(2, dataStop);
                stmt2.setString(3, a);
                stmt2.executeUpdate();


            } catch (Exception e) {
                System.out.println(e);
            }
            AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/zarzadzajWypozyczeniami.fxml"));
            adminPane.getChildren().setAll(pane);
        }

    }

    public void usunWypo(ActionEvent event) throws  IOException{

        System.out.println("2");

        TablePosition pozycja = tabelka_wypozyczenie.getSelectionModel().getSelectedCells().get(0);
        int index = pozycja.getRow();

        try {
            index++;
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/projekt_zespolowe?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");

            PreparedStatement stmt = con.prepareStatement("SELECT * FROM wypozyczenie");
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

            PreparedStatement stmt2 = con.prepareStatement("DELETE FROM wypozyczenie WHERE wypozyczenie_id = (?)");
            stmt2.setInt(1, numer);
            stmt2.executeUpdate();


        }catch (Exception e)
        {
            System.out.println(e);
        };
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/zarzadzajWypozyczeniami.fxml"));
        adminPane.getChildren().setAll(pane);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            Connection con = DBConnector.getConnection();
            ResultSet rs = con.createStatement().executeQuery("Select user.imie, user.nazwisko, wypozyczenie.data_od, wypozyczenie.data_do, samochod.cena from wypozyczenie inner join user on user.user_id = wypozyczenie.user_id inner join samochod on samochod.samochod_id = wypozyczenie.samochod_id;");

            while (rs.next()) {

                oblist1.add(new ModelTableWypozyczenie(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));

            }
            System.out.println(oblist1);


        } catch (SQLException ex) {
            Logger.getLogger(zarzadzajUzytkownikamiController.class.getName()).log(Level.SEVERE, null, ex);
        }

        col_Imie.setCellValueFactory(new PropertyValueFactory<>("Imie"));

        col_Nazwisko.setCellValueFactory(new PropertyValueFactory<>("Nazwisko"));

        col_DataPoczatkowa.setCellValueFactory(new PropertyValueFactory<>("data_poczatkowa"));

        col_DataKoncowa.setCellValueFactory(new PropertyValueFactory<>("data_koncowa"));

        col_cena.setCellValueFactory(new PropertyValueFactory<>("cena"));

        System.out.println(tabelka_wypozyczenie);

        tabelka_wypozyczenie.setItems(oblist1);

    }

    private boolean walidacajaDataWypozyczenia(){
        int i = TdataStart.getValue().getDayOfYear();
        int j = TdataStart.getValue().getYear();
        int k = TdataKoniec.getValue().getDayOfYear();
        int l = TdataKoniec.getValue().getYear();


        if(l<j){

        }else{
            if(k<i) {

            }else{
                return true;
            }
        }
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Informacja");
        alert.setHeaderText(null);
        alert.setContentText("Sprawdz daty");
        alert.showAndWait();

        return false;
    }
}