package HELLOFX;

import java.net.URL;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @SuppressWarnings("exports")
	@Override
    public void start(Stage primaryStage) throws Exception{
    	try {
        /*Loading the fxml file for the first page*/
    		URL url = getClass().getResource("firstever.fxml");
            if (url == null) {
                System.out.println("Can't load FXML file");
                Platform.exit();
            }
           
    		primaryStage.setTitle("C Beautifier");
        primaryStage.setScene(new Scene(FXMLLoader.load(url)));
        primaryStage.show();
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }


    public static void main(String[] args) {
        launch(args);
    }
}
