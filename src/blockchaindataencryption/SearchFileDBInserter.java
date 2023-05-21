/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package blockchaindataencryption;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author Innovatus
 */
public class SearchFileDBInserter {
    
     public boolean searchFileinfo( String dt, String keyword, String fname, String userid)
    {
        boolean flag=true;
        
        try
        {
            
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/blockchaindatasecurity","root","root");
            Statement st=conn.createStatement();
            
            String query="Insert into searchinfo values('"+dt+"','"+keyword+"','"+fname+"', '"+userid+"')";
            
//            
            
            int x=st.executeUpdate(query);
            if(x>0)
                flag=true;
            else
                flag=false;
            
        }
        
        catch(Exception e)
        {
            System.out.println("Exception in SearchFileDBInserter Class is: "+e);
            flag=false;
        }
        
        
        
        
        return flag;
    }
    
    
}
