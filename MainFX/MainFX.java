package MainFX;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class MainFX extends Application {
    
    public void start(Stage stage) throws Exception {
    	System.out.println(getClass().getResource("/view/Usuario.fxml"));
        Pane layout = (Pane) FXMLLoader.load(getClass().getResource("/view/Usuario.fxml"));
        
        Scene scene = new Scene(layout, 800, 700);
        

        stage.setTitle("MENU");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

