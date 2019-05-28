package wypozyczalnia.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import wypozyczalnia.UserSession;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private Label notyfikacja_lbl;

    @FXML
    private PasswordField password_tf;

    @FXML
    private TextField login_tf;

    @FXML
    private AnchorPane rootPane;

    @FXML
    private Button dodajInserty;

    @FXML
    private Button pracPane;
    @FXML
    private Button adminPane;
    @FXML
    private Button klientPane;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        notyfikacja_lbl.setVisible(false);
        pracPane.setVisible(false);
        klientPane.setVisible(false);
        adminPane.setVisible(false);
    }

    public void loadMenuAdmin(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/menuAdmin.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    public void loadMenuPracownik(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/menuPracownik.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    public void loadMenuKlient(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/menuKlient.fxml"));
        rootPane.getChildren().setAll(pane);
    }


    public void logIn(ActionEvent actionEvent) {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/projekt_zespolowe?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");

            ps = con.prepareStatement("SELECT * FROM user WHERE login = ? AND haslo = ?");

            ps.setString(1, login_tf.getText());
            ps.setString(2, password_tf.getText());
            rs = ps.executeQuery();

            if (rs.next()) {
                if (rs.getString("rodzaj").equals("klient")) {
                    UserSession.getInstance(rs.getString("login"), rs.getString("haslo"), rs.getString("rodzaj"), rs.getInt("user_id"));
                    FXMLLoader Loader = new FXMLLoader();
                    Loader.setLocation(getClass().getResource("../fxml/menuKlient.fxml"));
                    try {
                        Loader.load();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    MenuKlientController display = Loader.getController();
                    display.displayName(rs.getString("imie"));

                    Node source = (Node) actionEvent.getSource();
                    Stage stage1 = (Stage) source.getScene().getWindow();
                    stage1.close();

                    Parent p = Loader.getRoot();
                    Stage stage = new Stage();
                    stage.setScene(new Scene(p));
                    stage.show();
                } else if (rs.getString("rodzaj").equals("admin")) {
                    UserSession.getInstance(rs.getString("login"), rs.getString("haslo"), rs.getString("rodzaj"), rs.getInt("user_id"));
                    FXMLLoader Loader = new FXMLLoader();
                    Loader.setLocation(getClass().getResource("../fxml/menuAdmin.fxml"));
                    try {
                        Loader.load();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    MenuAdminController display = Loader.getController();
                    display.displayName(rs.getString("imie"));

                    Node source = (Node) actionEvent.getSource();
                    Stage stage1 = (Stage) source.getScene().getWindow();
                    stage1.close();

                    Parent p = Loader.getRoot();
                    Stage stage = new Stage();
                    stage.setScene(new Scene(p));
                    stage.show();
                } else if (rs.getString("rodzaj").equals("worker")) {
                    UserSession.getInstance(rs.getString("login"), rs.getString("haslo"), rs.getString("rodzaj"), rs.getInt("user_id"));
                    FXMLLoader Loader = new FXMLLoader();
                    Loader.setLocation(getClass().getResource("../fxml/menuPracownik.fxml"));
                    try {
                        Loader.load();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    MenuPracownikController display = Loader.getController();
                    display.displayName(rs.getString("imie"));

                    Node source = (Node) actionEvent.getSource();
                    Stage stage1 = (Stage) source.getScene().getWindow();
                    stage1.close();

                    Parent p = Loader.getRoot();
                    Stage stage = new Stage();
                    stage.setScene(new Scene(p));
                    stage.show();
                }
            } else {
                notyfikacja_lbl.setVisible(true);
                notyfikacja_lbl.setText("NIEPOPRAWNY LOGIN LUB HASŁO!");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Błąd logowania");
                alert.setHeaderText("Niepoprawny login lub hasło");
                alert.setContentText("Proszę spróbować ponownie!");
                alert.showAndWait();
            }


        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void dodajInserty(ActionEvent event) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/projekt_zespolowe?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");

            PreparedStatement stmt = con.prepareStatement("INSERT INTO samochod VALUES(?,?,?,?,?,?,?,?,?,?)");

            stmt.setInt(1, 0);
            stmt.setString(2, "Ferrari");
            stmt.setString(3, "Enzo");
            stmt.setString(4, "Coupe");
            stmt.setInt(5, 2008);
            stmt.setString(6, "Benzyna");
            stmt.setInt(7, 25000);
            stmt.setInt(8, 5979);
            stmt.setString(9, "TAK");
            stmt.setInt(10, 51);
            stmt.executeUpdate();

            PreparedStatement stmt2 = con.prepareStatement("INSERT INTO samochod VALUES(?,?,?,?,?,?,?,?,?,?)");

            stmt2.setInt(1, 0);
            stmt2.setString(2, "Lamborghini");
            stmt2.setString(3, "Hurracan");
            stmt2.setString(4, "Coupe");
            stmt2.setInt(5, 2016);
            stmt2.setString(6, "Benzyna");
            stmt2.setInt(7, 34532);
            stmt2.setInt(8, 5979);
            stmt2.setString(9, "TAK");
            stmt2.setInt(10, 51);
            stmt2.executeUpdate();

            PreparedStatement stmt3 = con.prepareStatement("INSERT INTO samochod VALUES(?,?,?,?,?,?,?,?,?,?)");

            stmt3.setInt(1, 0);
            stmt3.setString(2, "Lada");
            stmt3.setString(3, "Samara");
            stmt3.setString(4, "Hatchback");
            stmt3.setInt(5, 1995);
            stmt3.setString(6, "Benzyna");
            stmt3.setInt(7, 350500);
            stmt3.setInt(8, 59);
            stmt3.setString(9, "TAK");
            stmt3.setInt(10, 51);
            stmt3.executeUpdate();

            PreparedStatement stmt4 = con.prepareStatement("INSERT INTO samochod VALUES(?,?,?,?,?,?,?,?,?,?)");

            stmt4.setInt(1, 0);
            stmt4.setString(2, "Pagani");
            stmt4.setString(3, "Zonda");
            stmt4.setString(4, "Coupe");
            stmt4.setInt(5, 2008);
            stmt4.setString(6, "Benzyna");
            stmt4.setInt(7, 5000);
            stmt4.setInt(8, 9755);
            stmt4.setString(9, "TAK");
            stmt4.setInt(10, 51);
            stmt4.executeUpdate();

            PreparedStatement stmt5 = con.prepareStatement("INSERT INTO samochod VALUES(?,?,?,?,?,?,?,?,?,?)");

            stmt5.setInt(1, 0);
            stmt5.setString(2, "Honda");
            stmt5.setString(3, "CRX");
            stmt5.setString(4, "Hatchback");
            stmt5.setInt(5, 1996);
            stmt5.setString(6, "Benzyna");
            stmt5.setInt(7, 255600);
            stmt5.setInt(8, 125);
            stmt5.setString(9, "TAK");
            stmt5.setInt(10, 51);
            stmt5.executeUpdate();

            PreparedStatement stmt6 = con.prepareStatement("INSERT INTO user VALUES(?,?,?,?,?,?,?,?,?,?,?)");

            stmt6.setInt(1, 0);
            stmt6.setString(2, "pracownik1000");
            stmt6.setString(3, "pracownik1000");
            stmt6.setString(4, "Ryszard");
            stmt6.setString(5, "Nowak");
            stmt6.setString(6, "1991-05-20");
            stmt6.setString(7, "Warszawa");
            stmt6.setInt(8, 773050222);
            stmt6.setString(9, "pracownik1000@email.com");
            stmt6.setString(10, "91052012345");
            stmt6.setString(11, "worker");
            stmt6.executeUpdate();

            PreparedStatement stmt7 = con.prepareStatement("INSERT INTO user VALUES(?,?,?,?,?,?,?,?,?,?,?)");

            stmt7.setInt(1, 0);
            stmt7.setString(2, "klient1000");
            stmt7.setString(3, "klient1000");
            stmt7.setString(4, "Piotr");
            stmt7.setString(5, "Pawlikowski");
            stmt7.setString(6, "1992-03-26");
            stmt7.setString(7, "Warszawa");
            stmt7.setInt(8, 773050333);
            stmt7.setString(9, "klient1000@email.com");
            stmt7.setString(10, "92032612345");
            stmt7.setString(11, "worker");
            stmt7.executeUpdate();

            PreparedStatement stmt8 = con.prepareStatement("INSERT INTO user VALUES(?,?,?,?,?,?,?,?,?,?,?)");

            stmt8.setInt(1, 0);
            stmt8.setString(2, "admin1000");
            stmt8.setString(3, "admin1000");
            stmt8.setString(4, "Piotr");
            stmt8.setString(5, "Pawlikowski");
            stmt8.setString(6, "1984-08-11");
            stmt8.setString(7, "Warszawa");
            stmt8.setInt(8, 773050444);
            stmt8.setString(9, "admin1000@email.com");
            stmt8.setString(10, "84081112345");
            stmt8.setString(11, "worker");
            stmt8.executeUpdate();


            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Informacja");
            alert.setHeaderText(null);
            alert.setContentText("Pomyślnie dodano rekordy do bazy!");
            alert.showAndWait();

            int zmienna = 1;
            zmienna++;
            if (zmienna > 1) {
                dodajInserty.setVisible(false);
            }


        } catch (Exception e) {
            System.out.println(e);
        }
        ;
    }
}