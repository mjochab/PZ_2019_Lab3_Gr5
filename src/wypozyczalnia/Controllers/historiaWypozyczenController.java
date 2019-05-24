package wypozyczalnia.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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
    private TableColumn<ModelTableWypozyczenia, String> col_wypozyczenie_id;
    @FXML
    private TableColumn<ModelTableWypozyczenia, String> col_user_id;
    @FXML
    private TableColumn<ModelTableWypozyczenia, String> col_data_od;
    @FXML
    private TableColumn<ModelTableWypozyczenia, String> col_data_do;
    @FXML
    private TableColumn<ModelTableWypozyczenia, String> col_samochod_id;


    ObservableList<ModelTableWypozyczenia> oblist5 = FXCollections.observableArrayList();


    public void logOut(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/login.fxml"));
        pracownikPane.getChildren().setAll(pane);
    }

    public void menuPracownik(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/menuPracownik.fxml"));
        pracownikPane.getChildren().setAll(pane);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            Connection con = DBConnector.getConnection();

            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM wypozyczenie");

            while (rs.next()) {
                oblist5.add(new ModelTableWypozyczenia(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
            }


        } catch (SQLException ex) {
            Logger.getLogger(historiaWypozyczenController.class.getName()).log(Level.SEVERE, null, ex);
        }


        col_wypozyczenie_id.setCellValueFactory(new PropertyValueFactory<>("wypozyczenie_id"));
        col_user_id.setCellValueFactory(new PropertyValueFactory<>("user_id"));
        col_data_do.setCellValueFactory(new PropertyValueFactory<>("data_od"));
        col_data_od.setCellValueFactory(new PropertyValueFactory<>("data_do"));
        col_samochod_id.setCellValueFactory(new PropertyValueFactory<>("samochod_id"));


        tabela_wypozyczenia.setItems(oblist5);


    }



/*
    public void initialize(URL location, ResourceBundle resources) {

        try {
            Connection con = DBConnector.getConnection();

            ResultSet rs = con.createStatement().executeQuery("select * from wypozyczenie");

            while (rs.next()) {
                oblist5.add(new ModelTableWypozyczenia(rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)));
            }


        } catch (SQLException ex) {
            Logger.getLogger(historiaWypozyczenController.class.getName()).log(Level.SEVERE, null, ex);
        }


        col_wypozyczenie_id.setCellValueFactory(new PropertyValueFactory<>("wypozyczenie_id"));
        col_user_id.setCellValueFactory(new PropertyValueFactory<>("user_id"));
        col_data_do.setCellValueFactory(new PropertyValueFactory<>("data_od"));
        col_data_od.setCellValueFactory(new PropertyValueFactory<>("data_do"));
        col_samochod_id.setCellValueFactory(new PropertyValueFactory<>("samochod_id"));


        tabela_wypozyczenia.setItems(oblist5);



    }
*/
/*    private void zaladujwypozyczenia() {
        nazwauzytkownika.setText(username);
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/projekt_zespolowe?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");


            ps = con.prepareStatement("SELECT * FROM w.wypozyczenie, u.user WHERE u.user_id=w.user_id AND login = ?");

            ps.setString(1,System.getProperty("user.name"));
            rs = ps.executeQuery();




        } catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }

    }

    String username = System.getProperty("user.name");

*/
}
