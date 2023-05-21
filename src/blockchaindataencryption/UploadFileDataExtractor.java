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
public class UploadFileDataExtractor {
    
     public int RowCounofUploadFileData()
    {

       int count=0;
        try
        {

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/blockchaindatasecurity","root","root");
            Statement st=conn.createStatement();
            



            String query="Select count(*) from uploadfile";

            ResultSet rs1=st.executeQuery(query);
            
            rs1.next();
            count=rs1.getInt(1);
          
            
            st.close();
            


        }

        catch(Exception e)
        {
            System.out.println("Exception in UploadFileDataExtractor Class in RowCounofUploadFileData()is: "+e);

        }

       return count;
    }


       
       public ArrayList getUploadFileData()
    {

       ArrayList uploadfiledata=new ArrayList();

        try
        {

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/blockchaindatasecurity","root","root");
            Statement st=conn.createStatement();
            



            String query="Select *from uploadfile";

            ResultSet rs1=st.executeQuery(query);
             
             while(rs1.next())
            {

             ArrayList temp=new ArrayList();
             
             String sno=rs1.getString(1);
             String fname=rs1.getString(2);
             String headkey=rs1.getString(3);
             String datetime=rs1.getString(4);
            
             
             
              temp.add(sno);
              temp.add(fname);
              temp.add(headkey);
              temp.add(datetime);
             
              
             uploadfiledata.add(temp);

            }
//             
            
               st.close();

        }

        catch(Exception e)
        {
            System.out.println("Exception in UploadFileDataExtractor Class in getUploadFileData() is: "+e);

        }

       return uploadfiledata;
    }

      
}


     
      