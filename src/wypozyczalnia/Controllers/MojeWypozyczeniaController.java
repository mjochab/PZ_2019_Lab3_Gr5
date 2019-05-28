package wypozyczalnia.Controllers;

import javafx.application.Platform;
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
import wypozyczalnia.UserSession;
import wypozyczalnia.RentCar;


import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MojeWypozyczeniaController implements Initializable {

    @FXML
    private AnchorPane pracownikPane;
    private AnchorPane zarzadzajPojazdamiPane;

    @FXML
    private DatePicker dpDataOd;

    @FXML
    private DatePicker dpDataDo;

    @FXML
    private TableView<ModelTableWypozyczenia> tabelka_moje_wypozyczenia;
    @FXML
    private TableColumn<ModelTableWypozyczenia, String> col_marka;
    @FXML
    private TableColumn<ModelTableWypozyczenia, String> col_model;
    @FXML
    private TableColumn<ModelTableWypozyczenia, String> col_data_od;
    @FXML
    private TableColumn<ModelTableWypozyczenia, String> col_data_do;
    @FXML
    private TableColumn<ModelTableWypozyczenia, String> col_cena;



    ObservableList<ModelTableWypozyczenia> oblist5 = FXCollections.observableArrayList();

    public void clearFields(ActionEvent event) throws IOException {
        dpDataDo.setValue(null);
        dpDataOd.setValue(null);

    }


    public void logOut(ActionEvent event) throws IOException {
        UserSession.cleanUserSession();
        Platform.exit();
    }

    public void menuPracownik(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/menuPracownik.fxml"));
        pracownikPane.getChildren().setAll(pane);
    }


    private boolean walidacjaData()
    {
        if(dpDataOd.getValue().toEpochDay()>=(dpDataDo.getValue().toEpochDay()))
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Błąd!");
            alert.setHeaderText(null);
            alert.setContentText("Wybierz odpowiednie daty!");
            alert.showAndWait();

            return false;
        }
        return true;
    }

       public void edytujWypozyczenie(ActionEvent event) throws  IOException {

        String data_od = dpDataOd.getValue().toString();
        String data_do = dpDataDo.getValue().toString();

        TablePosition pozycja = tabelka_moje_wypozyczenia.getSelectionModel().getSelectedCells().get(0);
        int index = pozycja.getRow();

           if(walidacjaData()) {
               try {
                   index++;
                   Class.forName("com.mysql.cj.jdbc.Driver");
                   Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/projekt_zespolowe?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");

                   PreparedStatement stmt = con.prepareStatement("SELECT * FROM wypozyczenie");
                   String zapytanie = "Select * FROM wypozyczenie WHERE `user_id` = " + UserSession.getID() + " ORDER BY user_id LIMIT " + index;
                   ResultSet rs = stmt.executeQuery(zapytanie);
                   String a = "0";
                   int i = 0;
                   while (rs.next()) {
                       a = rs.getString(1);
                       i++;
                   }
                   int numer = Integer.parseInt(a);

                   PreparedStatement stmt2 = con.prepareStatement("UPDATE `wypozyczenie` SET `data_od`=(?),`data_do`=(?) WHERE `wypozyczenie_id` =(?)");

                   stmt2.setString(1, data_od);
                   stmt2.setString(2, data_do);
                   stmt2.setInt(3, numer);

                   Alert alert = new Alert(Alert.AlertType.INFORMATION);
                   alert.setTitle("Informacja");
                   alert.setHeaderText(null);
                   alert.setContentText("Daty wypożyczenia zostały zaktualizowane!");
                   alert.showAndWait();

                   stmt2.executeUpdate();
                   tabelka_moje_wypozyczenia.refresh();


               } catch (Exception e) {
                   System.out.println(e);
               }
               AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/mojeWypozyczenia.fxml"));
               pracownikPane.getChildren().setAll(pane);

           }}




    @Override
    public void initialize(URL location, ResourceBundle resources) {


        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = new java.util.Date();
        //  System.out.println("Current Date : " + dateFormat.format(date));


        try {
            Connection con = DBConnector.getConnection();


            ResultSet rs = con.createStatement().executeQuery("SELECT samochod.marka, samochod.model, wypozyczenie.data_od, wypozyczenie.data_do, samochod.cena, user.user_id\n" +
                    "                    FROM samochod\n" +
                    "                    JOIN wypozyczenie\n" +
                    "                    ON samochod.samochod_id = wypozyczenie.samochod_id\n" +
                    "                    JOIN user\n" +
                    "                    ON wypozyczenie.user_id = user.user_id\n" +
                    "                    AND user.rodzaj = \"worker\" AND wypozyczenie.user_id=" +UserSession.getID()+
                    "                    AND wypozyczenie.data_do >"+"'"+dateFormat.format(date)+"'" );
            //   "WHERE user.user_id= 47");


            while (rs.next()) {
                oblist5.add(new ModelTableWypozyczenia(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)+ " zł/dzień", rs.getString(6)));
            }


        } catch (SQLException ex) {
            Logger.getLogger(historiaWypozyczenController.class.getName()).log(Level.SEVERE, null, ex);
        }



        col_marka.setCellValueFactory(new PropertyValueFactory<>("marka"));
        col_model.setCellValueFactory(new PropertyValueFactory<>("model"));
        col_data_od.setCellValueFactory(new PropertyValueFactory<>("data_od"));
        col_data_do.setCellValueFactory(new PropertyValueFactory<>("data_do"));
        col_cena.setCellValueFactory(new PropertyValueFactory<>("cena"));


        tabelka_moje_wypozyczenia.setItems(oblist5);


        tabelka_moje_wypozyczenia.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                ArrayList<String> dane = new ArrayList<String>();
                try {

                    TablePosition pozycja = tabelka_moje_wypozyczenia.getSelectionModel().getSelectedCells().get(0);
                    int index = pozycja.getRow();

                    index++;
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/projekt_zespolowe?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");

                    PreparedStatement stmt = con.prepareStatement("SELECT * FROM `wypozyczenie` WHERE `user_id`='"+UserSession.getID()+"'");
                    String zapytanie = "Select * FROM wypozyczenie WHERE `user_id` = "+UserSession.getID()+" ORDER BY user_id LIMIT "+index;
                    ResultSet rs = stmt.executeQuery(zapytanie);
                    String a = "0";
                    int i=0;
                    while(rs.next()) {
                        a = rs.getString(1);
                        i++;
                    }
                    int numer = Integer.parseInt(a);


                    zapytanie = "Select * FROM wypozyczenie where wypozyczenie_id = " + numer;
                    ResultSet rs2 = stmt.executeQuery(zapytanie);

                    if(rs2.next()) {
                        dane.add(rs2.getString("data_od"));
                        dane.add(rs2.getString("data_do"));

                        dpDataOd.setValue(LocalDate.parse(dane.get(0)));
                        dpDataDo.setValue(LocalDate.parse(dane.get(1)));


                    }


                }catch (Exception e)
                {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Informacja");
                    alert.setHeaderText(null);
                    alert.setContentText("Zaznacz linie!");
                    alert.showAndWait();
                };


            };

        });

    }
}
