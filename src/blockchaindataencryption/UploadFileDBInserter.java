/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package blockchaindataencryption;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Innovatus
 */
public class UploadFileDBInserter {
    
     public boolean uploadFileinfo(String sno, String fname, String headkey,String datetime)
    {
        boolean flag=true;
        
        try
        {
            
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/blockchaindatasecurity","root","root");
            Statement st=conn.createStatement();
            
            String query="Insert into uploadfile values('"+sno+"','"+fname+"','"+headkey+"','"+datetime+"')";
            
//            
            
            int x=st.executeUpdate(query);
            if(x>0)
                flag=true;
            else
                flag=false;
            
            st.close();
            
        }
        
        
        
        catch(Exception e)
        {
            System.out.println("Exception in UploadFileDBInserter Class is: "+e);
            
            flag=false;
        }
        
        
        
        
        return flag;
    }
    
    
}
