/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package blockchaindataencryption;
import java.sql.*;

/**
 *
 * @author Innovatus
 */
public class UserProfileUpdate {
    
    
    public boolean updateInfo(String name, String dob, String add,String email,String mob,String uid,String pass)
    {
        boolean flag=true;
        
        
        
        try
        {
            
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/blockchaindatasecurity","root","root");
            Statement st=conn.createStatement();
            
            String query="Update registerinfo set name='"+name+"',dob='"+dob+"',address='"+add+"',email='"+email+"',mob='"+mob+"',password='"+pass+"' where userid='"+uid+"'";


            
            int x=st.executeUpdate(query);
            if(x>0)
                flag=true;
            else
                flag=false;
            
            st.close();
            
        }
        
        catch(Exception e)
        {
            System.out.println("Exception in UserProfileUpdate Class is: "+e);
            flag=false;
        }
        
        
        
        
        return flag;
    }
    
}
