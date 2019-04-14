package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.Connectivity.ConnectionClass;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Fxml/login.fxml"));
        primaryStage.setTitle("Wypozyczalnia Samochodow");
        primaryStage.setScene(new Scene(root, 700, 400));
        primaryStage.show();
    }


    public static void main(String[] args) throws Exception{

        dodaj();
        launch(args);
    }

    public static void dodaj() throws Exception{
       try{
           ConnectionClass connectionClass = new ConnectionClass();
           Connection connection = connectionClass.getConnection();

           PreparedStatement dodaj = connection.prepareStatement("INSERT INTO administrator VALUES(1,1,'admin','admin','Jan','Kowalski',1234567889");
           dodaj.executeUpdate();
       }catch (Exception e)
       {
           System.out.println(e);
       }
       finally {
        System.out.println("Dodano");
    }
}

}
