package wypozyczalnia.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class historiaWypozyczenController {
    @FXML
    private AnchorPane pracownikPane;
    private AnchorPane zarzadzajPojazdamiPane;


    public void logOut(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../Fxml/login.fxml"));
        pracownikPane.getChildren().setAll(pane);
    }

    public void menuPracownik(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../Fxml/menuPracownik.fxml"));
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



}
