/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rcc;

/**
 *
 * @author 1450
 */
public class RCCInit {
    
    public byte[] getEncryptedFile(String filepath)
    {
        byte enc_file_bytes[]=null;
        
        try
        {
        byte file_bytes[] = new ReadFileInByte().readFile(filepath);
        enc_file_bytes= new Encryption().encfile(file_bytes);
        }
        catch (Exception e)
        {
            System.out.println("Exception in RCCInit Class is: "+e);
        }
        
        return enc_file_bytes;
    }
    
    
}
