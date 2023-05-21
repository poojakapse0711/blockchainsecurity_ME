/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package preprocessing;

/**
 *
 * @author DILIP SINGH
 */
public class Preprocessor {
    
    public String textProcessing(String str)
    {
        String nstr="";
        
        String words[]=str.split(" ");
        
        
        for(int i=0;i<words.length;i++)
        {
            String w=words[i];
            
               w=w.replace("\"", "");
               w=w.replace("\'", "");
               w=w.replace(",", "");
               w=w.replace("!", "");
               w=w.replace(":", "");
               w=w.replace("  ", " ");
               w=w.replace("    ", " ");
               w=w.replace("(", "");
               w=w.replace(")", "");
               w=w.replace("[", "");
               w=w.replace("]", "");
               w=w.replace("{", "");
               w=w.replace("}", "");
               w=w.replace("?", "");
               w=w.replace("<", "");
               w=w.replace(">", "");
               w=w.replace("=", "");
               w=w.replace(".", "");
               w=w.replace("-", "");
               
               boolean value=new StopWords().getWords(w);
              // System.out.println("Returning value is .................."+value);
        
        if(value==false)
        {
            nstr=nstr+w+" ";
        }
        
        }
        
        
        System.out.println(" Stop Word Result is -------------------- :"+nstr);

        Stemmer sm=new Stemmer();
        
        String sw[]=nstr.split(" ");
        String text="";
        
        for(int i=0;i<sw.length;i++)
        {
           String st=sw[i]; 
           String st1=sm.stemmer(st);
           text=text+st1+" ";
        }
        
        System.out.println(" Stemming Word Result is ------------------------- :"+text);
        return text;
    }
    
}
