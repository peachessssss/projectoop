package javaapplication7;
import java.awt.geom.Rectangle2D;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
public class conr{
    public ImageIcon[] rm = new ImageIcon[8];
    public int x;
    public int y;
    public int count = 0;
    conr(){
        for(int i=0;i<rm.length;i++){
            rm[i] = new ImageIcon(this.getClass().getResource("conr"+(i+1)+".png")); 
	}
    }
    public Rectangle2D getbound(){
    	    return (new Rectangle2D.Double(x,y,100,100));
	}
}
