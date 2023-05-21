/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package preprocessing;

import java.util.ArrayList;

/**
 *
 * @author DILIP SINGH
 */
public class FactorFormation {
    
    public ArrayList getFactor(String str)
    {
        str=str.toLowerCase();
        str=str.trim();
        
        ArrayList bucket=new ArrayList();
        
       String str1[]=str.split(" ");
       
       for(int i=0;i<str1.length;i++)
       {
                    
           String nstr=str1[i];
            System.out.println(nstr);
            
           
                   if(nstr.length()>3)
        {
            for(int j=2;j<nstr.length();j++)
        {
            String sub=nstr.substring(0, j+1);
            
           // System.out.println("buckket: "+sub);
            
            
                 bucket.add(sub);
            
           
        }
            
        }
        else 
        {
            bucket.add(nstr);
        }
        
       }
     
       

        
        return bucket;
    }
    
}
