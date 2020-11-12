package javaapplication7;
import java.awt.geom.Rectangle2D;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
public class firel{
    public ImageIcon[] om = new ImageIcon[8];
    public int x;
    public int y;
    public int count = 0;
    firel(){
        for(int i=0;i<om.length;i++){
            om[i] = new ImageIcon(this.getClass().getResource("fireL"+(i+1)+".png")); 
	}
    }
    public Rectangle2D getbound(){
    	    return (new Rectangle2D.Double(x,y,100,100));
	}
}
