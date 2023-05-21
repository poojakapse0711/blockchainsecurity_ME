package blockchaindataencryption;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author welcome
 */
public class UserDataExtractor {

       
       public ArrayList getUserData(String usid)
    {

       ArrayList user=new ArrayList();

        try
        {

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/blockchaindatasecurity","root","root");
            Statement st1=conn.createStatement();
            



            String query="Select *from registerinfo where userid='"+usid+"'";

            ResultSet rs1=st1.executeQuery(query);
            

            
             if(rs1.next())
            {


             String name=rs1.getString(1);
             String dob=rs1.getString(2);
             String add=rs1.getString(3);
             String email=rs1.getString(4);
             String mob=rs1.getString(5);
             String uid=rs1.getString(6);
             String pass=rs1.getString(7);
             String usersignkey=rs1.getString(8);
            
             
    
              user.add(name);
              user.add(dob);
              user.add(add);
              user.add(email);
              user.add(mob);
              user.add(uid);
              user.add(pass);
              user.add(usersignkey);
              


            }
             
             st1.close();

        }

        catch(Exception e)
        {
            System.out.println("Exception in UserDataExtractor Class is: "+e);

        }

       return user;
    }

      
}


     
      