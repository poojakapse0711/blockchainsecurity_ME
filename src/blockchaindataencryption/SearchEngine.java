/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package blockchaindataencryption;

import com.dropbox.core.DbxException;
import com.dropbox.core.v2.files.UploadErrorException;
import dropbox.DownLoadHelper;
import dropbox.FileListHelper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author DILIP SINGH
 */
public class SearchEngine {
    
    public static String path="";
    
    public ArrayList getSearchFile(ArrayList ebucket) throws DbxException, UploadErrorException, IOException
    {
        
        ArrayList filename=new ArrayList();
        
         ArrayList filelist=new FileListHelper().getFileList();
         
                System.out.println(filelist);
               
                
                for(int i=0;i<filelist.size();i++)
                {
                    String fname=(String) filelist.get(i);
                    System.out.println("File List: "+fname);
                    new DownLoadHelper().intiateDownload(fname);
                        
                    
                 String cont = new FileReader().getFileContent(path);
                       
                 System.out.println("Feature File Content: "+cont);
                 
                   ArrayList temp=new ArrayList();
                   for(int j=0;j<cont.length();j++)
                   {
                       String contst[]=cont.split(" ");
                       
                      
                       for(int k=0;k<ebucket.size();k++)
                       {
                           ArrayList temp1=(ArrayList) ebucket.get(k);
                           String st1=(String) temp1.get(1);
                           
                         //  System.out.println("String 1: "+st1);
                           for(int l=0;l<contst.length;l++)
                           {
                               String st2=contst[l];
                               
                               st1=st1.trim();
                               st2=st2.trim();
                            //   System.out.println("String 2: "+st2);
                               if(st2.contains(st1))
                               {
                                   filename.add(fname);
                                  
                                   
                               }
                           }
                       }
                       
                       
                   }
                   
                   
                 
                 
                }
                
                
                 HashSet hs=new HashSet();
                 hs.addAll(filename);
                 hs.toString();
                 ArrayList<String> list = new ArrayList<String>(hs);
                 
        return list;
    }
    
}
