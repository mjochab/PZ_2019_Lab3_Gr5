package sample.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML
    private ChoiceBox<String> role_cb;

    @FXML
    private PasswordField password_tf;

    @FXML
    private TextField login_tf;

    @FXML
    private AnchorPane rootPane;

    ObservableList list = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadDataToCheckBox();
    }

    private void loadDataToCheckBox(){
        list.removeAll(list);
        String k = "Klient";
        String p = "Pracownik";
        String a = "Admin";
        list.addAll(k, p, a);
        role_cb.getItems().addAll(list);
    }

    public void loadMenuAdmin(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../Fxml/menuAdmin.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    public void loadMenuPracownik(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../Fxml/menuPracownik.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    public void loadMenuKlient(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../Fxml/menuKlient.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    public void printHello(ActionEvent event){

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/projekt_zespolowe?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "" );
        PreparedStatement stmt = con.prepareStatement("INSERT INTO klient VALUES(?,?,?,?,?,?,?,?)");
        stmt.setInt(1,1);
        stmt.setString(2,"adik");
        stmt.setString(3,"adik");
        stmt.setString(4,"Jan");
        stmt.setString(5,"Kowalski");
        stmt.setString(6,"1999-01-01");
        stmt.setString(7,"Sanok");
        stmt.setFloat(8,12345678912F);
        stmt.executeUpdate();


        PreparedStatement stmt2 = con.prepareStatement("INSERT INTO pracownik VALUES(?,?,?,?,?,?,?)");
        stmt2.setInt(1,1);
        stmt2.setInt(2,1);
        stmt2.setString(3,"adik");
        stmt2.setString(4,"adik");
        stmt2.setString(5,"Jan");
        stmt2.setString(6,"Kowalski");
        stmt2.setFloat(7, 12345678912F);
        stmt2.executeUpdate();


        PreparedStatement stmt3 = con.prepareStatement("INSERT INTO administrator VALUES(?,?,?,?,?,?,?)");
        stmt3.setInt(1,1);
        stmt3.setInt(2,1);
        stmt3.setString(3,"adik");
        stmt3.setString(4,"adik");
        stmt3.setString(5,"Jan");
        stmt3.setString(6,"Kowalski");
        stmt3.setFloat(7,12345678912f);
        stmt3.executeUpdate();

        PreparedStatement stmt4 = con.prepareStatement("INSERT INTO samochod VALUES(?,?,?,?,?,?,?)");
        stmt4.setInt(1, 1);
        stmt4.setString(2, "Renault");
        stmt4.setString(3,"Laguna");
        stmt4.setString(4,"Sedan");
        stmt4.setString(5,"Diesel");
        stmt4.setString(6, "130000");
        stmt4.setString(7,"1500");
        stmt4.executeUpdate();

        PreparedStatement stmt5 = con.prepareStatement("INSERT INTO samochod VALUES(?,?,?,?,?,?,?)");
        stmt5.setInt(1, 2);
        stmt5.setString(2, "BMW");
        stmt5.setString(3,"Seria 1");
        stmt5.setString(4,"BMX");
        stmt5.setString(5,"Benzyna");
        stmt5.setString(6, "25000");
        stmt5.setString(7,"500");
        stmt5.executeUpdate();

        PreparedStatement stmt6 = con.prepareStatement("INSERT INTO samochod VALUES(?,?,?,?,?,?,?)");
        stmt6.setInt(1, 3);
        stmt6.setString(2, "Pegueot");
        stmt6.setString(3,"405");
        stmt6.setString(4,"Pick Up");
        stmt6.setString(5,"Diesel");
        stmt6.setString(6, "7000");
        stmt6.setString(7,"2000");
        stmt6.executeUpdate();

        PreparedStatement stmt7 = con.prepareStatement("INSERT INTO samochod VALUES(?,?,?,?,?,?,?)");
        stmt7.setInt(1, 4);
        stmt7.setString(2, "Jaguar");
        stmt7.setString(3,"Huracane");
        stmt7.setString(4,"Limousine");
        stmt7.setString(5,"Benzyna");
        stmt7.setString(6, "13000");
        stmt7.setString(7,"21000");
        stmt7.executeUpdate();

        PreparedStatement stmt8 = con.prepareStatement("INSERT INTO samochod VALUES(?,?,?,?,?,?,?)");
        stmt8.setInt(1, 5);
        stmt8.setString(2, "Renault");
        stmt8.setString(3,"Laguna");
        stmt8.setString(4,"Sedan");
        stmt8.setString(5,"Diesel");
        stmt8.setString(6, "130000");
        stmt8.setString(7,"1500");
        stmt8.executeUpdate();

        PreparedStatement stmt9 = con.prepareStatement("INSERT INTO samochod VALUES(?,?,?,?,?,?,?)");
        stmt9.setInt(1, 6);
        stmt9.setString(2, "BMW");
        stmt9.setString(3,"Seria 1");
        stmt9.setString(4,"BMX");
        stmt9.setString(5,"Benzyna");
        stmt9.setString(6, "25000");
        stmt9.setString(7,"500");
        stmt9.executeUpdate();

        PreparedStatement stmt10 = con.prepareStatement("INSERT INTO samochod VALUES(?,?,?,?,?,?,?)");
        stmt10.setInt(1, 7);
        stmt10.setString(2, "Pegueot");
        stmt10.setString(3,"405");
        stmt10.setString(4,"Pick Up");
        stmt10.setString(5,"Diesel");
        stmt10.setString(6, "7000");
        stmt10.setString(7,"2000");
        stmt10.executeUpdate();

        PreparedStatement stmt11 = con.prepareStatement("INSERT INTO samochod VALUES(?,?,?,?,?,?,?)");
        stmt11.setInt(1, 8);
        stmt11.setString(2, "Jaguar");
        stmt11.setString(3,"Huracane");
        stmt11.setString(4,"Limousine");
        stmt11.setString(5,"Benzyna");
        stmt11.setString(6, "13000");
        stmt11.setString(7,"21000");
        stmt11.executeUpdate();

        ResultSet rs = stmt2.executeQuery("select * from administrator");

        while(rs.next())
        {
            System.out.println("Pomyslnie dodano rekordy");
        }


    }catch (Exception e)
    {
        System.out.println(e);
    };



    }

    public void logIn(ActionEvent event) {

        String role = role_cb.getValue();

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/projekt_zespolowe?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "" );

            if(role == "Klient") {
                ps = con.prepareStatement("SELECT * FROM klient WHERE login = ? and haslo = ?");

                ps.setString(1, login_tf.getText());
                ps.setString(2, password_tf.getText());
                rs = ps.executeQuery();

                if (rs.next()) {
                    AnchorPane pane = null;
                    try {
                        pane = FXMLLoader.load(getClass().getResource("../Fxml/menuKlient.fxml"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    rootPane.getChildren().setAll(pane);
                } else {
                    System.out.println("Niepoprawny login lub hasło klienta!");
                }
            }else if(role == "Admin"){
                ps = con.prepareStatement("SELECT * FROM administrator WHERE login = ? and haslo = ?");

                ps.setString(1, login_tf.getText());
                ps.setString(2, password_tf.getText());
                rs = ps.executeQuery();

                if (rs.next()) {
                    AnchorPane pane = null;
                    try {
                        pane = FXMLLoader.load(getClass().getResource("../Fxml/menuAdmin.fxml"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    rootPane.getChildren().setAll(pane);
                } else {
                    System.out.println("Niepoprawny login lub hasło administratora!");
                }
            }else if(role == "Pracownik"){
                ps = con.prepareStatement("SELECT * FROM pracownik WHERE login = ? and haslo = ?");

                ps.setString(1, login_tf.getText());
                ps.setString(2, password_tf.getText());
                rs = ps.executeQuery();

                if (rs.next()) {
                    AnchorPane pane = null;
                    try {
                        pane = FXMLLoader.load(getClass().getResource("../Fxml/menuPracownik.fxml"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    rootPane.getChildren().setAll(pane);
                } else {
                    System.out.println("Niepoprawny login lub hasło pracownika!");
                }
            }else if(role == null){
                System.out.println("Nie wybrano roli!");
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
