package HELLOFX;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

import com.jfoenix.controls.JFXButton;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class UploadFileController {

	
	public int n,flag=0,j,i,flag1=0,fn,tab=0,semi=0,dq=0;
	public String[] s=new String[500];
	public String[] flg = new String[100];
	public String buf="",s1,fs="";
	public String[] sym={"=","<",">","+","-","*","/","!","|","?",":","&"}; 
	public String line = "\n";
	public String space = "  ";
	public String right = ",";
	public String[] newline = {"{","}",";"};
	public String[] nospace = {")","(","[","]","."," ","_","'"};
	
	
	
    @SuppressWarnings("exports")
	@FXML
    public JFXButton browse;

    @SuppressWarnings("exports")
	@FXML
    public JFXButton back_btn_;

    @SuppressWarnings("exports")
	@FXML
    public Label file_name;

    @SuppressWarnings("exports")
	@FXML
    public JFXButton next_btn;
    
    StringBuilder a;
    
    File selectedItem;

    @SuppressWarnings("exports")
	@FXML
    public void back_clicked(ActionEvent event) {

    }
    
    @SuppressWarnings({ "exports", "null" })
    @FXML
    public void browse_file(ActionEvent event) {
    	FileChooser filechoose=new FileChooser();
		filechoose.setTitle("Select C file");
		filechoose.setInitialDirectory(new File("D:\\"));
		filechoose.getExtensionFilters().addAll(
			     new FileChooser.ExtensionFilter("C Files", "*.c"));
			selectedItem=
					filechoose.showOpenDialog(null);
			   file_name.setText(selectedItem.getAbsolutePath());
			   
			   
			  
    }
    
    @SuppressWarnings("exports")
    @FXML
    public void next_page(ActionEvent event) {
    	String path=file_name.getText();
    	if(path.equals("No file Selected"))
    	{
    		Alert a=new Alert(AlertType.ERROR);
    		a.setHeaderText("SELECT THE PATH OF THE FILE");
    		a.setContentText("SELECT FILE THROUGH BROWSE");
    		a.showAndWait();
    	}
    	else
    	{
    		//File fp=new File(selectedItem);
    		System.out.print(" "+selectedItem);
    		
    		 try{    
    			 a=new StringBuilder();
    	            FileInputStream fin=new FileInputStream(selectedItem);    
    	            int i=0;    
    	            while((i=fin.read())!=-1){    
    	             a.append((char)i);  
    	            }    
    	            fin.close();    
    	          }catch(Exception e){System.out.println(e);}    
    	         }  
    	           s1=a.toString(); 
    	       s=s1.split("");
               n=s1.length();
               indent();
    		
    		 try{    
                 FileOutputStream fout=new FileOutputStream("D:\\testout.txt");    
                 byte b[]=buf.getBytes();//converting string into byte array    
                 fout.write(b);    
                 fout.close();    
                 System.out.println("success...");    
                }catch(Exception e){System.out.println(e);}    
          }    
    		
    		private void indent() {
		// TODO Auto-generated method stub
    			flg[0]=fs;tab=0;
    	        for(i=1;i<10;i++)
    	        {
    	            fs=fs+"   ";
    	            flg[i]=fs;
    	           // System.out.println("\n"+flg[i]);
    	        }
    	        char c;
    	        String m=""+'"';
    	        for(i=0;i<n;i++)
    	        {
    	            c=s1.charAt(i);
    	            if(Character.isLetterOrDigit(c))
    	            {
    	                buf=buf+c;
    	            } 
    	            else
    	            {
    	                flag=0;
    	                if(s[i].equals("#"))
    	                {
    	                    fn=1;
    	                    buf=buf+s[i];
    	                }
    	                else
    	                {
    	                    if(fn==1)
    	                    {
    	                        if(s[i].equals(">"))
    	                        {
    	                           // buf=buf+space;
    	                            buf=buf+s[i];
    	                            buf=buf+line;
    	                            flag=1;
    	                           fn=0;
    	                        }
    	                        else if(s[i].equals("<"))
    	                        {
    	                            buf=buf+s[i];
    	                           flag=1;
    	                        }
    	                        
    	                        
    	                    }
    	                }
    	                if(dq==1 && flag==0)
    	                {
    	                    if(s[i].equals(m))
    	                    {
    	                        
    	                        buf=buf+m;
    	                        dq=0;flag=1;
    	                    }
    	                    else if(s[i].equals("%"))
    	                    {
    	                        buf=buf+"%";flag=1;
    	                    }
    	                    else
    	                    {
    	                        buf=buf+s[i];flag=1;
    	                    }
    	                }
    	                for(j=0;j<sym.length;j++)
    	                {   
    	                    if((s[i].equals(sym[j])) && (flag!=1))
    	                    {
    	                        for(int k=0;k<sym.length;k++)
    	                        {
    	                            if(s[i+1].equals(sym[k]))
    	                            {
    	                                flag1=1;
    	                            }
    	                        }
    	                        if(flag1==1)
    	                        {  
    	                            buf=buf+s[i];
    	                            i=i+1;
    	                            buf=buf+s[i];
    	                            flag1=0;
    	                        }
    	                        else
    	                        {
    	                          //  buf=buf+space;
    	                            buf=buf+s[i];
    	                            //buf=buf+space;
    	                        }
    	                        flag=1;
    	                    }
    	                }    
    	                for(j=0;j<nospace.length;j++)
    	                {
    	                    if(s[i].equals(nospace[j])&&flag!=1)
    	                    {
    	                        buf=buf+s[i];
    	                        if(s[i].equals(")") && s[i+1].equals("{"))
    	                        {
    	                           // buf=buf+line;
    	                            buf=buf+flg[tab];
    	                        }
    	                        flag=1;
    	                    }
    	                }
    	                if(s[i].equals(m) && flag==0)
    	                {
    	                    dq=1;
    	                    buf=buf+m;
    	                    flag=1;
    	                }
    	                if(s[i].equals(right) && flag!=1)
    	                {
    	                    buf=buf+s[i];
    	                    buf=buf+space;
    	                    flag=1;
    	                }
    	                for(j=0;j<newline.length;j++)
    	                {
    	                    if((s[i].equals(newline[j]))&&(flag!=1))
    	                    {
    	                        if(s[i].equals("{"))
    	                        {
    	                            buf=buf+line+line;
    	                            buf=buf+flg[tab];
    	                            buf=buf+s[i];
    	                            buf=buf+line;
    	                            tab=tab+1;
    	                            buf=buf+line+flg[tab];
    	                        }
    	                        
    	                        else if(s[i].equals("}"))//&&(s[i+1].equals(";")))
    	                        {
    	                            buf=buf+line+line;
    	                            tab=tab-1;
    	                            buf=buf+flg[tab];buf=buf+s[i]+line+flg[tab];
    	                        }
    	                        else if((s[i].equals("}"))&&(s[i+1].equals(";")))
    	                        {
    	                    	    tab=tab-1;
    	                            buf=buf+line+flg[tab]+s[i]+s[i+1];
    	                            flag=1;
    	                        }

    	                                                  //buf=buf+line;
    	                            //tab=tab-1;
    	                           // tab=tab-1;
    	                            //buf=buf+flg[tab];*/
    	                            //buf=buf+line;
    	                            //tab=tab-1;
    	                           // buf=buf+line+space;
    	                       
    	                            //buf=buf+line+flg[tab];
    	                            //buf=buf+s[i];
    	                            //buf=buf+line+flg[tab];
    	                            //tab=tab-1;
    	                            //buf=buf+flg[tab]+s[i]+line;//+flg[tab];
    	                        
    	                        else
    	                        {
    	                            if((s[i].equals(";"))&&((s[i-2].equals("+"))||(s[i-2].equals("-"))||(s[i-2].equals("="))||(s[i-2].equals("<"))||(s[i-2].equals(">"))))
    	                            {
    	                                
    	                                buf=buf+s[i];
    	                                //buf=buf+space;
    	                               // buf=buf+flg[tab];
    	                            }
    	                            else if((s[i].equals(";"))&&(!s[i+1].equals("}")))
    	                                    
    	                            {
    	                                    //flag=1;
    	                                    buf=buf+s[i];
    	                                    buf=buf+line;
    	                                    buf=buf+flg[tab];
    	                            }
    	                            
    	                            else{
    	                                buf=buf+s[i];
    	                            }
    	                        }
    	                        flag=1;
    	                    }
    	                }
    	            }
    	        }

			URL url = getClass().getResource("save.fxml");
	            if (url == null) {
	                System.out.println("Can't load FXML file");
	                Platform.exit();
	            }
	            Node root = null;
			try {
				root = FXMLLoader.load(url);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    		
	    		Stage primaryStage = new Stage();
				primaryStage.setTitle("Hello World");
	        primaryStage.setScene(new Scene( (Parent) root));
	        primaryStage.show();
    	}

}
