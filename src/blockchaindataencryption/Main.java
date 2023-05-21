/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blockchaindataencryption;

import java.awt.Dimension;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.Toolkit;
import javax.swing.UIManager;

/**
 *
 * @author 1450
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try { 
  
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName()); 
             Dimension d = Toolkit.getDefaultToolkit().getScreenSize();

             LoginFrame mf = new LoginFrame();
             mf.setVisible(true);
             mf.setSize(d);
             mf.setExtendedState(MAXIMIZED_BOTH);
        } 
        catch (Exception e) { 
            System.out.println("Look and Feel not set"); 
        } 
    }
    
}
