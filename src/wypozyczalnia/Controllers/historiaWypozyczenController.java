package wypozyczalnia.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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

public class historiaWypozyczenController implements Initializable {

    @FXML
    private AnchorPane pracownikPane;
    private AnchorPane zarzadzajPojazdamiPane;

    @FXML
    private TableView<ModelTableWypozyczenia> tabela_wypozyczenia;
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

    @FXML
    public Label usernamedisplay_lbl;

    ObservableList<ModelTableWypozyczenia> oblist5 = FXCollections.observableArrayList();



    public void logOut(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/login.fxml"));
        pracownikPane.getChildren().setAll(pane);
    }

    public void menuPracownik(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/menuPracownik.fxml"));
        pracownikPane.getChildren().setAll(pane);
    }

    /*private void zaladujwypozyczenia() {
        nazwauzytkownika.setText(username);
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/projekt_zespolowe?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");


            ps = con.prepareStatement("SELECT * FROM h.historia_wypozyczen, k.klient WHERE k.klient_id=h.klient_id AND login = ?");

            ps.setString(1,System.getProperty("user.name"));
            rs = ps.executeQuery();




        } catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }

    }

    String username = System.getProperty("user.name");
*/

    String userid;
    public void displayName (String usernamedisplay){

        this.usernamedisplay_lbl.setText(usernamedisplay);
        this.userid=usernamedisplay;

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {



        try {
            Connection con = DBConnector.getConnection();


            ResultSet rs = con.createStatement().executeQuery("SELECT samochod.marka, samochod.model, wypozyczenie.data_od, wypozyczenie.data_do, samochod.cena, user.user_id\n" +
                    "                    FROM samochod\n" +
                    "                    JOIN wypozyczenie\n" +
                    "                    ON samochod.samochod_id = wypozyczenie.samochod_id\n" +
                    "                    JOIN user\n" +
                    "                    ON wypozyczenie.user_id = user.user_id\n" +
                    "                    WHERE user.rodzaj = \"worker\"" );
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


        tabela_wypozyczenia.setItems(oblist5);


    }

}


