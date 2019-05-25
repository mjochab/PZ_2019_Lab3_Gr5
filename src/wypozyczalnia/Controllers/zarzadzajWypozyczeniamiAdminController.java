package wypozyczalnia.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import wypozyczalnia.DBConnector;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class zarzadzajWypozyczeniamiAdminController implements Initializable {
    @FXML
    private AnchorPane adminPane;
    private AnchorPane zarzadzajWypozyczeniamiAdminPane;

    @FXML private TextField Tpesel;
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
    public void dodajWypo(ActionEvent event) throws IOException {
        System.out.println(1);


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
}