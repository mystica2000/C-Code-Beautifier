package HELLOFX;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FirstPageController implements Initializable {

    @FXML
    public JFXComboBox<String> combo1;

    @SuppressWarnings("exports")
	@FXML
    public JFXButton go_next;

    @SuppressWarnings("exports") 
    @FXML
    public void click_on_go(ActionEvent event) {
    	 String selected=combo1.getValue();
    	 System.out.print("hello "+selected);
    	 if(selected.equals("TYPE CODE"))
    	 {
    		 Stage primaryStage=new Stage();
    			URL url = getClass().getResource("main.fxml");
                if (url == null) {
                    System.out.println("Can't load FXML file");
                    Platform.exit();
                }
                Parent root = null;
    			
				try {
					root = FXMLLoader.load(url);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
         
              
        		
        		primaryStage.setTitle("Hello World");
            primaryStage.setScene(new Scene( root));
            primaryStage.show();
    	 }
    	 if(selected.equals("UPLOAD FILE"))
    	 {
    		 Stage primaryStage=new Stage();
 			URL url = getClass().getResource("upfile.fxml");
             if (url == null) {
                 System.out.println("Can't load FXML file");
                 Platform.exit();
             }
             Parent root = null;
			try {
				root = FXMLLoader.load(url);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
             
				try {
					root = FXMLLoader.load(url);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				primaryStage.setTitle("Hello World");
	            primaryStage.setScene(new Scene( root));
	            primaryStage.show();
    	 }
    	
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		//combo1=new JFXComboBox<>();
		combo1.getItems().add("TYPE CODE");
		combo1.getItems().add("UPLOAD FILE");
	}

}
