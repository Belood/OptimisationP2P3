package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class IHM extends Application {
	public static void main(String[] args) {
		launch(IHM.class,args);
		}
    public void start(Stage stage) throws Exception {
       Parent root = FXMLLoader.load(getClass().getResource("IHM.fxml"));
    
        Scene scene = new Scene(root, 1280, 800);
    
        stage.setTitle("Optimisation centrale hydroélectrique");
        stage.setScene(scene);
        stage.show();
    }
}
