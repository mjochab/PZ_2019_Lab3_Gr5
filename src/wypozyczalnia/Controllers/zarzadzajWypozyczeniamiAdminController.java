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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class zarzadzajWypozyczeniamiAdminController implements Initializable {
    @FXML
    private AnchorPane adminPane;

    @FXML private TextField userPesel;
    @FXML private TextField Tmarka;
    @FXML private TextField Tcena;
    @FXML private DatePicker TdataStart;
    @FXML private DatePicker TdataKoniec;
    @FXML private TextField Tmodel;
    @FXML
    private TableView<ModelTableWypozyczenie> tabelka_wypozyczenie;
    @FXML
    private TableColumn<ModelTableWypozyczenie, String> col_Pesel;
    @FXML
    private TableColumn<ModelTableWypozyczenie, String> col_Marka;
    @FXML
    private TableColumn<ModelTableWypozyczenie, String> col_Model;
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

            while(rs2.next()) {
                i = Integer.parseInt(rs2.getString(2));
                j = Integer.parseInt(rs2.getString(3));
            }


            zapytanie = "Select pesel FROM user where user_id = " + i;
            rs2 = stmt.executeQuery(zapytanie);
            if(rs2.next())
            {
                userPesel.setText(rs2.getString(1));
            }


            zapytanie = "Select marka, model, cena FROM samochod where samochod_id = " + j;
            rs2 = stmt.executeQuery(zapytanie);
            if(rs2.next()) {
                Tmarka.setText(rs2.getString(1));
                Tmodel.setText(rs2.getString(2));
                Tcena.setText(rs2.getString(3));
            }


        }catch (Exception e)
        {
            System.out.println(e);
        };
    }

    public void dodajWypo(ActionEvent event) throws IOException {

        String pesel = String.valueOf(this.userPesel.getCharacters());
        String marka = String.valueOf(this.Tmarka.getCharacters());
        String cena = String.valueOf(this.Tcena.getCharacters());
        String dataStart = TdataStart.getValue().toString();
        System.out.println(dataStart);

        String dataKoniec = TdataKoniec.getValue().toString();
        String model = String.valueOf(this.Tmodel.getCharacters());

        try {
            String idUser = "1";
            String idAuto = "1";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/projekt_zespolowe?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            PreparedStatement stmt2 = con.prepareStatement("Select MAX(wypozyczenie_id) FROM wypozyczenie");
            ResultSet rs = stmt2.executeQuery("Select * FROM wypozyczenie");



            int i;
            for (i = 1; rs.next(); ++i) {
            }
            System.out.println(i);

            PreparedStatement stm2 = con.prepareStatement("select user_id from user where pesel = (?) limit 1");
            stm2.setString(1, pesel);
            stm2.executeQuery();
            String zapytanie = "select user_id from user where pesel = " + pesel +" limit 1";
            rs = stm2.executeQuery(zapytanie);

            while(rs.next()) {
                idUser = rs.getString(1);
                i++;
            } //pobranie id usera

            PreparedStatement stm = con.prepareStatement("select samochod_id from samochod where marka = (?) and model = (?) limit 1");

            stm.setString(1, marka);

            stm.setString(2, model);

            stm.executeQuery();

            zapytanie = "select samochod_id from samochod where marka = '"+ marka + "' and model = '"+ model +"' limit 1";

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

        System.out.println("2");

        TablePosition pozycja = tabelka_wypozyczenie.getSelectionModel().getSelectedCells().get(0);
        int index = pozycja.getRow();

        String pesel = String.valueOf(userPesel.getCharacters());
        String marka = String.valueOf(Tmarka.getCharacters());
        String model = String.valueOf(Tmodel.getCharacters());
        String cena = String.valueOf(Tcena.getCharacters());
        String dataStart = TdataStart.getValue().toString();
        String dataStop = TdataKoniec.getValue().toString();
        if(walidacjaCena() && walidacjaPesel() && walidacjaPol() && walidacjaModel() && walidacjaMarka() && walidacajaDataWypozyczenia()) {
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

                String czlowiekID = "1";

                stmt = con.prepareStatement("SELECT * FROM samochod");
                rs = stmt.executeQuery("select user_id from user where pesel = '" + pesel + "'  limit 1");
                while (rs.next()) {
                    czlowiekID = rs.getString(1);
                    i++;
                }

                String autoID = "1";
                rs = stmt.executeQuery("select samochod_id from samochod where marka = '" + marka + "' and model='" + model + "' limit 1");
                while (rs.next()) {
                    autoID = rs.getString(1);
                    i++;
                }


                PreparedStatement stmt2 = con.prepareStatement("UPDATE `wypozyczenie` SET `user_id`=(?),`samochod_id`=(?),`data_od`=(?),`data_do`=(?) where `wypozyczenie_id`=(?)");
                stmt2.setString(1, czlowiekID);
                stmt2.setString(2, autoID);
                stmt2.setString(3, dataStart);
                stmt2.setString(4, dataStop);
                stmt2.setInt(5, index);
                stmt2.executeUpdate();


            } catch (Exception e) {
                System.out.println(e);
            }
            AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/zarzadzajWypozyczeniamiAdmin.fxml"));
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
            ResultSet rs = con.createStatement().executeQuery("Select user.pesel, samochod.marka, samochod.model, wypozyczenie.data_od, wypozyczenie.data_do, samochod.cena from wypozyczenie inner join user on user.user_id = wypozyczenie.user_id inner join samochod on samochod.samochod_id = wypozyczenie.samochod_id;");

            while (rs.next()) {

                oblist1.add(new ModelTableWypozyczenie(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));

            }

            System.out.println(oblist1);


        } catch (SQLException ex) {
            Logger.getLogger(zarzadzajUzytkownikamiController.class.getName()).log(Level.SEVERE, null, ex);
        }


        col_Pesel.setCellValueFactory(new PropertyValueFactory<>("Pesel"));

        col_Marka.setCellValueFactory(new PropertyValueFactory<>("Marka"));

        col_Model.setCellValueFactory(new PropertyValueFactory<>("Model"));

        col_DataPoczatkowa.setCellValueFactory(new PropertyValueFactory<>("data_poczatkowa"));

        col_DataKoncowa.setCellValueFactory(new PropertyValueFactory<>("data_koncowa"));

        col_cena.setCellValueFactory(new PropertyValueFactory<>("cena"));

        System.out.println(tabelka_wypozyczenie);

        tabelka_wypozyczenie.setItems(oblist1);

    }

    private boolean walidacjaPol() {
        if (Tcena.getText().isEmpty() | Tmarka.getText().isEmpty() | Tcena.getText().isEmpty()
                | Tmodel.getText().isEmpty() | TdataStart.getValue().toString().isEmpty() | TdataKoniec.getValue().toString().isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Informacja");
            alert.setHeaderText(null);
            alert.setContentText("Uzupełnij wszystkie pola");
            alert.showAndWait();


            return false;
        }
        return true;
    }

    private boolean walidacjaCena(){
        Pattern p = Pattern.compile("-?([1-9][0-9]*)?");
        Matcher m = p.matcher(Tcena.getText());

        if(m.find() && m.group().equals(Tcena.getText())){
            return true;
        }else
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Informacja");
            alert.setHeaderText(null);
            alert.setContentText("Wpisz koszt pojazdu w cyfrach");
            alert.showAndWait();

            return false;
        }

    }

    private boolean walidacjaPesel(){
        Pattern p = Pattern.compile("-?([1-9][0-9]*)?");
        Matcher m = p.matcher(Tcena.getText());

        if(m.find() && m.group().equals(userPesel.getText())){
            return true;
        }else
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Informacja");
            alert.setHeaderText(null);
            alert.setContentText("sprawdz pesel");
            alert.showAndWait();

            return false;
        }

    }

    private boolean walidacjaMarka(){
        Pattern p = Pattern.compile("([A-za-z0-9-/\"]+)");
        Matcher m = p.matcher(Tmarka.getText());

        if(m.find() && m.group().equals(Tmarka.getText())){
            return true;
        }else
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Informacja");
            alert.setHeaderText(null);
            alert.setContentText("Znaki specjalne w nazwie marki nie są obsługiwane");
            alert.showAndWait();

            return false;
        }

    }
    private boolean walidacjaModel(){
        Pattern p = Pattern.compile("([A-za-z0-9-/\"]+)");
        Matcher m = p.matcher(Tmodel.getText());

        if(m.find() && m.group().equals(Tmodel.getText())){
            return true;
        }else
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Informacja");
            alert.setHeaderText(null);
            alert.setContentText("Znaki specjalne w nazwie marki nie są obsługiwane");
            alert.showAndWait();

            return false;
        }

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