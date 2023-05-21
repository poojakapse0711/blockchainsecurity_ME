/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rcc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author abhil
 */
public class WriteFile {
    
    public boolean writeFile(byte encfilebyte[], String writepath){
        
        boolean f = true;
        try {
            FileOutputStream fos = new FileOutputStream(new File(writepath));
            fos.write(encfilebyte);
            fos.close();
        } catch (Exception ex) {
            System.out.println("Excepiton in WriteFile Class is: "+ex);
            f = false;
        }
        
        return f;
    }
}
