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
public class IntegrityFileDataExtractor {

       
       public ArrayList getIntegrityFileData()
    {

       ArrayList user=new ArrayList();

        try
        {

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/blockchaindatasecurity","root","root");
            Statement st1=conn.createStatement();
            



            String query="Select *from integrityinfo";

            ResultSet rs1=st1.executeQuery(query);
            

            
             
             while(rs1.next())
            {

             ArrayList temp=new ArrayList();
             String fname=rs1.getString(1);
             String dt=rs1.getString(2);
             
             
             


              
              temp.add(fname);
              temp.add(dt);
              
             user.add(temp);

            }
             
            


        }

        catch(Exception e)
        {
            System.out.println("Exeption in IntegrityFileDataExtractor Class is: "+e);

        }

       return user;
    }

      
}


     
      