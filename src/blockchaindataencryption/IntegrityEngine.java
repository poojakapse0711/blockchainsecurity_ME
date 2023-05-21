/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package blockchaindataencryption;

import dropbox.DownLoadHelper;
import dropbox.DownloadFile;
import java.util.ArrayList;
import keygeneration.CurrentDate;
import keygeneration.KeyGen;
import keygeneration.SHA256;

import rcc.ReadFileInByte;


/**
 *
 * @author 1450
 */
public class IntegrityEngine extends Thread
{
    String str="";
    public ArrayList fileinfo=new ArrayList();
    
  
    int k=0;
    
    public void setFileInfo(ArrayList mas)
    {
        fileinfo=mas;
        System.out.println(fileinfo);
                            
    }
    
     public void run()
    {
        System.out.println("thread is running...");
        while(true)
        {
            
            for (int i = 0; i <fileinfo.size(); i++)
            {
               
                ArrayList row=(ArrayList) fileinfo.get(i);
                int srno=Integer.parseInt((String) row.get(0));
                String fname=(String) row.get(1);
                String orgheadkey=(String) row.get(2);
               
                try
                {
                    
                    new DownLoadHelper().intiateDownload(fname);
                   
                    String downpath = DownloadFile.Drive + "//" + fname;
                    byte enc_file_bytes[] = new ReadFileInByte().readFile(downpath);
                     
                     
                     String sha256key=new SHA256().getsha256(enc_file_bytes);;
                     
                            
                    String cont="";
                    
                 //  System.out.println("SRNO: "+srno);
                    if(srno==1)
                    {
                      
                        ArrayList userinfo=new UserDataExtractor().getUserData(LoginFrame.userid);
                      
                        String usersignkey=(String) userinfo.get(7);
                        cont=sha256key+usersignkey;
                      
                        
                    }
                    else if(srno>1)
                    {
                        
                        ArrayList prerow=(ArrayList) fileinfo.get(i-1);
                       
                      //  System.out.println("PreviousRowKey: "+prerow);
                        String preheadkey=(String) prerow.get(2);
                        cont=sha256key+preheadkey;
                    }
                    
                    String headkey=new KeyGen().getKey(cont);
                    
                     System.out.println("OrgHeadKey: "+orgheadkey);
                     System.out.println("HeadKey: "+headkey);
                     
                    if(!headkey.equals(orgheadkey))
                    {
                         
                        CurrentDate cd = new CurrentDate();
                        String dt = cd.getDateTime();
                        IntegrityFileDBInserter in = new IntegrityFileDBInserter();
                        in.uploadIntegrityFileinfo(fname, dt);
                        
                        String filename="Filename: "+fname +"   "+"Date & Time: "+dt;
                        str=str+"\n"+filename;
                        StartIntegrityFrame.jTextArea1.setText(str);
                        System.out.println("Integrity Violated Filename: "+fname);

                    }
                            
                }
                catch(Exception e)
                {
                    System.out.println("Exception in IntegrityEngine Class is: "+e);
                }
            }
            
            try {
                Thread.sleep(30000);
            } catch (Exception ex) {
                System.out.println("Exception in timing " + ex);
            }
        }
        
        
    }
    
}
