package javaapplication7;
import java.awt.geom.Rectangle2D;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
public class conl{
    public ImageIcon[] qm = new ImageIcon[8];
    public int x;
    public int y;
    public int count = 0;
    conl(){
        for(int i=0;i<qm.length;i++){
            qm[i] = new ImageIcon(this.getClass().getResource("conl"+(i+1)+".png")); 
	}
    }
    public Rectangle2D getbound(){
    	    return (new Rectangle2D.Double(x,y,100,100));
	}
}
