/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication7;

import java.applet.Applet;
import java.awt.Graphics;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author ssp
 */
public class JavaApplication7 extends Applet {

     public void paint (Graphics g) {
         g.drawString("Welcome to Thailand", 30,30);
         g.drawString("สวัสดีเมืองไทย", 30,60);
} 
    public static void main(String[] args) {
         JFrame jf = new PlayGames();
            jf.setSize(1000,800);
            jf.setTitle("Superstar");
            jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
            jf.setVisible(true);
            jf.setLocationRelativeTo(null);
    }
    
}
