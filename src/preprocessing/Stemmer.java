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
public class Stemmer {
    
    public String stemmer(String str)
    {
        
        ArrayList stem=new ArrayList();
        stem.add("ing");
        stem.add("ed");
        stem.add("ness");
        stem.add("ization");
        stem.add("ly");
        stem.add("s");
        
        
        for(int i=0;i<stem.size();i++)
        {
            String word=(String) stem.get(i);
            
            if(str.endsWith(word));
            {
                str=str.replaceAll(word, "");
            }
        }
        return str;
    }
    
}
