package javaapplication7;
import java.awt.geom.Rectangle2D;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
public class firer{
    public ImageIcon[] pm = new ImageIcon[8];
    public int x;
    public int y;
    public int count = 0;
    firer(){
        for(int i=0;i<8;i++){
            pm[i] = new ImageIcon(this.getClass().getResource("fireR"+(i+1)+".png")); 
	}
    }
    public Rectangle2D getbound(){
    	    return (new Rectangle2D.Double(x,y,100,100));
	}
}
