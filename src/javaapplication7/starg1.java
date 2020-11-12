package javaapplication7;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.Rectangle2D;
import java.net.URL;
import javax.swing.ImageIcon;
public class starg1 {
	Image img;
        public int start = (int) ((Math.random()*900));
        public int x=start;
        public int ran = 50;
	public int y= 0;
	public int count = 0;
        public int nn = 5;
        public int time = 10 ;
        boolean time1 = false;
        boolean time2 = false;
	starg1(){
                String imageLocation = "starg.png";
                URL imageURL = this.getClass().getResource(imageLocation);
		img = Toolkit.getDefaultToolkit().getImage(imageURL);
		runner.start();
	}
//        Thread paralyze = new Thread(new Runnable() {
//        public void run() {
//            while (true) {
//                if (time < 1) {
//                    time1 = false;
//                    time = 10;
//                }
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    });
//        Thread time22 = new Thread(new Runnable() {
//        public void run() {
//            while (true) {
//                if (time < 1) {
//                    time2 = false;
//                    time = 10;
//                }
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    });
	Thread runner = new Thread(new Runnable() {
            public void run() {
		while(true){
                    if(x > start+ran){
                       nn = -5; 
                    }
                    else if(x < start-ran){
                        nn = 5;
                    }

//                    time1 = true;
//                    if(time1){
//                       time--;
//                       x+=5;                     
//                    }      
//                    time2 = true;
//                    if(time2){
//                        time--;
//                        x-=5;
//                    }
                    x+=nn;
                    y+=5;                   
                    if(y >= 750){
			img = null;
			runner = null;
			start = (int) ((Math.random()*900));
                        x = start;
			y =  0;
                    }
                    try{
			runner.sleep(30);
                    }catch(InterruptedException e){}
                }
            }
	});
        
	
	public Image getImage(){
            return img;
	}
	
	public int getX(){
            return x;
	}
	public int getY(){
            return y;
	}
	public Rectangle2D getbound(){
    	    return (new Rectangle2D.Double(x,y,45,45));
	}
}
