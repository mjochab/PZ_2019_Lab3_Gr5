package wypozyczalnia.Controllers;

        import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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
    private TableColumn<ModelTablePojazdy, String> col_dostep;


    ObservableList<ModelTablePojazdy> oblist1 = FXCollections.observableArrayList();



    public void logOut(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/login.fxml"));
        pracownikPane.getChildren().setAll(pane);
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


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


}
