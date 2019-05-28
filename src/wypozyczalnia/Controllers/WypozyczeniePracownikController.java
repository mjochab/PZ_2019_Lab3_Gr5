package wypozyczalnia.Controllers;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import wypozyczalnia.DBConnector;
import wypozyczalnia.UserSession;
import wypozyczalnia.UserSession;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WypozyczeniePracownikController implements Initializable {
    @FXML
    private AnchorPane pracownikPane;

    @FXML
    private TableView<ModelTablePojazdy> tabelka_pojazdy;
    @FXML
    private TableColumn<ModelTablePojazdy, String> col_marka;
    @FXML
    private TableColumn<ModelTablePojazdy, String> col_model;
    @FXML
    private TableColumn<ModelTablePojazdy, String> col_rodzaj;
    @FXML
    private TableColumn<ModelTablePojazdy, String> col_rocznik;
    @FXML
    private TableColumn<ModelTablePojazdy, String> col_paliwo;
    @FXML
    private TableColumn<ModelTablePojazdy, String> col_przebieg;
    @FXML
    private TableColumn<ModelTablePojazdy, Double> col_cena;
    @FXML
    private TableColumn<ModelTablePojazdy, String> col_dostepnosc;


    ObservableList<ModelTablePojazdy> oblist1 = FXCollections.observableArrayList();



    public void logOut(ActionEvent event) throws IOException {
        UserSession.cleanUserSession();
        Platform.exit();
    }



    public void menuPracownik(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/menuPracownik.fxml"));
        pracownikPane.getChildren().setAll(pane);
    }

    public void terminPracownik(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/terminPracownik.fxml"));
        pracownikPane.getChildren().setAll(pane);
    }
    public void podWynP(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/podWynP.fxml"));
        pracownikPane.getChildren().setAll(pane);
    }

    private boolean walidacjaDostepnosc(){

        String dostepnosc = tabelka_pojazdy.getSelectionModel().getSelectedItem().getDostepnosc();
        String tak = "TAK";


        if(dostepnosc == tak){
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        try {
            Connection con = DBConnector.getConnection();

            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM `samochod` WHERE `dostepnosc` = 'TAK'");

            while (rs.next()) {
                oblist1.add(new ModelTablePojazdy(rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7) + " km", rs.getInt(8) + " zł/dzień",rs.getString(9)));
            }



        } catch (SQLException ex) {
            Logger.getLogger(zarzadzajUzytkownikamiAdminController.class.getName()).log(Level.SEVERE, null, ex);
        }


        col_marka.setCellValueFactory(new PropertyValueFactory<>("marka"));
        col_model.setCellValueFactory(new PropertyValueFactory<>("model"));
        col_rodzaj.setCellValueFactory(new PropertyValueFactory<>("rodzaj"));
        col_rocznik.setCellValueFactory(new PropertyValueFactory<>("rocznik"));
        col_paliwo.setCellValueFactory(new PropertyValueFactory<>("paliwo"));
        col_przebieg.setCellValueFactory(new PropertyValueFactory<>("przebieg"));
        col_cena.setCellValueFactory(new PropertyValueFactory<>("cena"));
        col_dostepnosc.setCellValueFactory(new PropertyValueFactory<>("dostepnosc"));

        tabelka_pojazdy.setItems(oblist1);

    }

}
