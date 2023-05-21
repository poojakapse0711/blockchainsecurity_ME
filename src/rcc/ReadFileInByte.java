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

/**
 *
 * @author abhil
 */
public class ReadFileInByte {
    
    public byte[] readFile(String path) throws FileNotFoundException, IOException{
        File ff = new File(path);
        FileInputStream fis = new FileInputStream(ff);
        int filelength = fis.available();
        //System.out.println(filelength);
        byte bfile[] = new byte[filelength];
        fis.read(bfile);
        return bfile;
    }
}
