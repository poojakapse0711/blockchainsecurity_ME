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
public class SearchFileDataExtractor {

       
       public ArrayList getSearchFileData(String usid)
    {

       ArrayList fileinfo=new ArrayList();

        try
        {

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/blockchaindatasecurity","root","root");
            Statement st1=conn.createStatement();
            



            String query="Select *from searchinfo where userid='"+usid+"'";

            ResultSet rs1=st1.executeQuery(query);
            

            
             while(rs1.next())
            {

             ArrayList temp=new ArrayList();
             String dt=rs1.getString(1);
             String keyword=rs1.getString(2);
             String fname=rs1.getString(3);
             
             
             


              temp.add(dt);
              temp.add(keyword);
              temp.add(fname);
              
              
              fileinfo.add(temp);


            }


        }

        catch(Exception e)
        {
            System.out.println("Exeption in SearchFileDataExtractor Class is: "+e);

        }

       return fileinfo;
    }

      
}


     
      