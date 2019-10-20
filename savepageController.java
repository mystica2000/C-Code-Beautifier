package HELLOFX;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.FileChooser;

public class savepageController implements Initializable {

    @SuppressWarnings("exports")
	@FXML
    public JFXTextArea final_box;

    @SuppressWarnings("exports")
	@FXML
    public JFXButton save_clicked;

    @SuppressWarnings("exports")
	@FXML
    public JFXButton cancel_btn;

    @FXML
    public void cancelclieck(@SuppressWarnings("exports") ActionEvent event) {
         Platform.exit();
    }

    @FXML
    
    public void save_btclieck(@SuppressWarnings("exports") ActionEvent event) {
    	System.out.print("hello world");
    	FileChooser fileChooser = new FileChooser();
    	 
      //  Set extension filter for text files
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("c files (*.c)", "*.c");
        fileChooser.getExtensionFilters().add(extFilter);

        //Show save file dialog
    	 //FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showSaveDialog(null);
		
	
	      

	//	primaryStage.show();
        if (file != null) {
            String sampleText=final_box.getText();
			saveTextToFile(sampleText, file);
        }
    }
    
    public void saveTextToFile(String sampleText, File file) {
		// TODO Auto-generated method stub
    	try {
            FileWriter fileWriter = null;
             
            fileWriter = new FileWriter(file);
            fileWriter.write(sampleText);
            fileWriter.close();
        } catch (IOException ex) {
          //  Logger.getLogger(JavaFX_Text.class.getName()).log(Level.SEVERE, null, ex);
        	ex.printStackTrace();
        }
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		 try{    
	            FileInputStream fin=new FileInputStream("D:\\testout.txt");    
	            int i=0;    
	            StringBuilder str=new StringBuilder();
	            while((i=fin.read())!=-1){    
	                str.append((char)i);
	            }    
	            final_box.setText(str.toString());
	            fin.close();    
	          }catch(Exception e){System.out.println(e);}  
		 
	}
}
