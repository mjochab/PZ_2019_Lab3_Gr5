package sample.Controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

import com.mysql.cj.protocol.Resultset;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import org.hibernate.jdbc.Expectation;

public class LoginController implements Initializable {

    @FXML
    private AnchorPane rootPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

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
        System.out.println("Nie ma jeszcze bazy danych!");

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/projekt_zespolowe?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "" );
        PreparedStatement stmt = con.prepareStatement("INSERT INTO klient VALUES(?,?,?,?,?,?,?,?)");
        stmt.setInt(1,3);
        stmt.setString(2,"AndrzejK");
        stmt.setString(3,"haslo");
        stmt.setString(4,"Andrzej");
        stmt.setString(5,"Kowalski");
        stmt.setString(6,"1997-04-04");
        stmt.setString(7,"Sanok");
        stmt.setString(8,"12345678901");
        stmt.executeUpdate();
        ResultSet rs = stmt.executeQuery("select * from klient");
        while(rs.next())
        {
            System.out.println(rs.getString(4));
        }


    }catch (Exception e)
    {
        System.out.println(e);
    };



    }
}
