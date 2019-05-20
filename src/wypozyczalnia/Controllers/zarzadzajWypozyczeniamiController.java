package wypozyczalnia.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class zarzadzajWypozyczeniamiController {
    @FXML
    private AnchorPane pracownikPane;
    private AnchorPane zarzadzajPojazdamiPane;

    ObservableList<ModelTablePojazdy> oblist1 = FXCollections.observableArrayList();
    ObservableList<ModelTable> oblist2 = FXCollections.observableArrayList();
    @FXML private TextField userPesel;
    @FXML private TextField marka;
    @FXML private TextField cena;
    @FXML private TextField dataStart;
    @FXML private TextField dataKoniec;
    @FXML private TextField model;

    public void logOut(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/login.fxml"));
        pracownikPane.getChildren().setAll(pane);
    }

    public void menuPracownik(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/menuPracownik.fxml"));
        pracownikPane.getChildren().setAll(pane);
    }

    public void alamakota(ActionEvent event) throws  IOException{

    }
    public void dodajWypozyczenie(ActionEvent event) throws IOException {
        System.out.println("2");
        String pesel = String.valueOf(this.userPesel.getCharacters());
        String marka = String.valueOf(this.marka.getCharacters());
        String cena = String.valueOf(this.cena.getCharacters());
        String dataStart = String.valueOf(this.dataStart.getCharacters());
        String dataKoniec = String.valueOf(this.dataKoniec.getCharacters());
        String model = String.valueOf(this.model.getCharacters());

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/projekt_zespolowe?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            PreparedStatement stmt2 = con.prepareStatement("Select MAX(samochod_id) FROM samochod");
            ResultSet rs = stmt2.executeQuery("Select * FROM historia_wypozyczen");

            int i;
            for (i = 1; rs.next(); ++i) {
            }
            System.out.println(i);

            PreparedStatement stmt = con.prepareStatement("INSERT INTO historia_wypozyczen VALUES(?,?,?, ?,?)");
            stmt.setInt(1, i);
            stmt.setString(2, " ");
            stmt.setString(3, " ");
            stmt.setString(4, dataStart);
            stmt.setString(5, dataKoniec);
            stmt.executeUpdate();


        } catch (Exception var14) {
            System.out.println(var14);
        }

    }


}
