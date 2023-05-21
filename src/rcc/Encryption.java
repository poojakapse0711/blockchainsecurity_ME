/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rcc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author abhil
 */
public class Encryption {
    
    public byte[] encfile(byte ssbyte[]) throws FileNotFoundException, IOException{
       
            int n = 10;
            int key = 11;
            int count = 1;
          
            byte storeencbytes[] = new byte[ssbyte.length];
            int ind=0;
            LinkedList<Byte> ll = new LinkedList<Byte>();
            for(int i=0; i<ssbyte.length; i++)
            {
                System.out.println("ssbyte[i]: "+ssbyte[i]);
                byte temp_addkey = (byte) (ssbyte[i]+key);
                ll.add(temp_addkey);
                if(ll.size()==n)
                {
                    count = count % n;
                    for(int j=0; j<count; j++)
                    {
                        byte lastele = ll.removeLast();
                        ll.addFirst(lastele);
                    }

                    for(int k=0; k<ll.size(); k++)
                    {
                        storeencbytes[ind++] = ll.get(k);
                    } 
                    count++;
                    ll = new LinkedList<Byte>();
                }

            }
            
            
            count = count % ll.size();
            for(int j=0; j<count; j++)
            {
                byte lastele = ll.removeLast();
                ll.addFirst(lastele);
            }
            for(int j=0; j<ll.size(); j++){
                storeencbytes[ind++] = ll.get(j);                
            }

        return storeencbytes;
    }
}
