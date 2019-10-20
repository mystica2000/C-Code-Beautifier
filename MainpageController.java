package HELLOFX;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class MainpageController {

    @SuppressWarnings("exports")
	@FXML
    public JFXTextArea input_box;

    @SuppressWarnings("exports")
	@FXML
    public JFXTextArea output_box;

    @SuppressWarnings("exports")
	@FXML
    public JFXButton beauty;

    @SuppressWarnings("exports")
	@FXML
    public JFXButton save;

    
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
    
    @FXML
    public void beauty_click(@SuppressWarnings("exports") ActionEvent event) {
    	   s1=input_box.getText();
    	      s=s1.split("");
    	      n=s1.length();     
    	
    	indent();
             
    }
    
    
    void indent()
    {
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
        output_box.setText(buf);
    }
    @FXML
    public void save_click(@SuppressWarnings("exports") ActionEvent event) {
              
    	FileChooser fileChooser = new FileChooser();
   	 
        //Set extension filter for text files
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("c files (*.c)", "*.c");
        fileChooser.getExtensionFilters().add(extFilter);

        //Show save file dialog
		File file = fileChooser.showSaveDialog(null);
		
		  String sampleText=output_box.getText();
        if (file != null) {
          
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

}
