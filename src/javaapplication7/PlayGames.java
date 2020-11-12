package javaapplication7;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;

public class PlayGames extends JFrame implements ActionListener{  
	homegames homegames1 = new homegames();
	playstate1 state1 = new playstate1();
	public PlayGames(){
		this.setSize(1000,800);
		this.add(homegames1);
                homegames1.BStart.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
            if(e.getSource()== homegames1.BStart){
		this.setLocationRelativeTo(null);
		this.remove(homegames1);
                this.setSize(1000,800);
                this.add(state1);
                state1.requestFocusInWindow();
		state1.timestart = false;
		state1.scor=0;
		state1.HP = 3;
		state1.times = 60;
            }
            this.validate();
            this.repaint();
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
