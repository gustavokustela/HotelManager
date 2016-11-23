import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main extends Application{
    public static void main(String[] args) {
        Application.launch(Main.class, (java.lang.String[])null);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            Pane root = FXMLLoader.load(getClass().getResource("/View/PrincipalView.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("HotelManager");
            primaryStage.show();
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}