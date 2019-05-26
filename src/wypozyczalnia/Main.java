package wypozyczalnia;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import wypozyczalnia.Controllers.SessionUser;


public class Main extends Application {

    public static SessionUser user;

    @Override
    public void start(Stage primaryStage) throws Exception{
        SessionUser user;
        Parent root = FXMLLoader.load(getClass().getResource("fxml/login.fxml"));
        primaryStage.setTitle("Wypożyczalnia samochodów");
        primaryStage.setScene(new Scene(root, 1400, 900));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
