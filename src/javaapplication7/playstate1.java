package javaapplication7;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import java.lang.Thread;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class playstate1 extends JPanel implements ActionListener {

    private final ImageIcon imgstate1 = new ImageIcon(this.getClass().getResource("bg1.png"));
    private final ImageIcon imgstate2 = new ImageIcon(this.getClass().getResource("bg2.png"));
    charl m = new charl();
    charr n = new charr();
    firel o = new firel();
    firer p = new firer();
    conl conq = new conl();
    conr conr = new conr();
    homegames hg = new homegames();
    private final ImageIcon feildover1 = new ImageIcon(this.getClass().getResource("over0.png"));
    private final ImageIcon feildover2 = new ImageIcon(this.getClass().getResource("over1.png"));
    private final ImageIcon win = new ImageIcon(this.getClass().getResource("win.jpg"));
    private JLabel score = new JLabel();

    public ArrayList<starg1> starg1 = new ArrayList<starg1>();
    public ArrayList<starr> starr = new ArrayList<starr>();
    public ArrayList<meteor1> meteor1 = new ArrayList<meteor1>();
    public ArrayList<green> green = new ArrayList<green>();
    public ArrayList<red> red = new ArrayList<red>();
    public ArrayList<fire> comet = new ArrayList<fire>();
    public int times;
    public int c = 0;
    public int HP = 3;
    public int rs1 = 1;
    public int rs2 = 2;
    boolean timestart = false;
    boolean startstage1;
    public int count = 9;
    public int l = 0;
    public int r = 0;
    public int check = 0;
    public int scor = 0;
    boolean fire1 = false;
    int time_fire = 3;
    public int s = 0;
    int time_con = 5;
    boolean conf1 = false;
    public int t1 = 5000;
    public int t2 = 10000;
    public int t3 = 10000;
    public int t4 = 10000;
    public int t5 = 20000;
    public int i;

    Thread time = new Thread(new Runnable() {
        public synchronized void run() {
            while (true) {
                try {
                    Thread.sleep(10);
                } catch (Exception e) {
                }
                if (timestart == false) {
                    repaint();
                }
            }
        }
    });
    Thread tstarg1 = new Thread(new Runnable() {
        public void run() {
            while (true) {
        try {
            if (startstage1 == false) {
                Thread.sleep(t1);
            }
        } catch (Exception e) {
        }
            if(startstage1 == false){
                starg1.add(new starg1());
            }
            }
        }
    });
    Thread tstarr = new Thread(new Runnable() {
        public void run() {
            while (true) {
                        try {
            if (startstage1 == false) {
                Thread.sleep(t5);
            }
        } catch (Exception e) {
        }
            if(startstage1 == false){
                starr.add(new starr());
            }
            }
        }
    });
    Thread tmeteor1 = new Thread(new Runnable() {
           public void run() {
            while (true) {
                try {
            if (startstage1 == false) {
                Thread.sleep(t2);
            }
        } catch (Exception e) {
        }
            if(startstage1 == false){
                meteor1.add(new meteor1());
            }
            }
        }
    });
    Thread tgreen = new Thread(new Runnable() {
        public void run() {
            while (true) {
                        try {
            if (startstage1 == false) {
                Thread.sleep(t4);
            }
        } catch (Exception e) {
        }
            if(startstage1 == false){
               green.add(new green());
            }
            }
        }
    });
    Thread tred = new Thread(new Runnable() {
        public void run() {
            while (true) {
                        try {
            if (startstage1 == false) {
                Thread.sleep(t4);
            }
        } catch (Exception e) {
        }
            if(startstage1 == false){
                red.add(new red());
            }
            }
        }
    });
    Thread fire = new Thread(new Runnable() {
        public void run() {
            while (true) {
                        try {
            if (startstage1 == false) {
                Thread.sleep(30000);
            }
        } catch (Exception e) {
        }
            if(startstage1 == false){
                comet.add(new fire());
            }
            }
        }
    });
    Thread paralyze = new Thread(new Runnable() {
        public void run() {
            while (true) {
                if (time_fire < 1) {
                    fire1 = false;
                    time_fire = 3;
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    });
    Thread conf = new Thread(new Runnable() {
        public void run() {
            while (true) {
                if (time_con < 1) {
                    conf1 = false;
                    if (conq.count == 0) {
//                        m.count = 0;
                    } else if (conr.count == 0) {
//                        n.count = 0;
                    }
                    time_con = 5;
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    });
    Thread t = new Thread(new Runnable() {
        public void run() {
            while (true) {
                if (timestart == false) {
                    if (c == 1) {
                        times += 5;
                        c = 0;
                    } else if (c == 2) {
                        times -= 5;
                        c = 0;
                    } else {
                        times = (times - 1);
                    }
                    if(times <= 50){
                    
                    }
                    if (fire1) {
                        time_fire--;
                        HP--;
                    }
                    if (conf1) {
                        time_con--;
                    }
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    );

    playstate1() {
        this.setFocusable(true);
        this.setLayout(null);
        this.add(score);
        this.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
//                m.count = count;
                int a = e.getKeyCode();
                if (conf1) {
                    if (a == KeyEvent.VK_LEFT) {
                        m.x += 10;
                        conq.count++;
                        if (conq.count >= 8) {
                            conq.count = 0;
                        }
                        l++;
                        r = 0;
                    } else if (a == KeyEvent.VK_RIGHT) {
                        m.x -= 10;
                        conr.count++;
                        if (conr.count >= 8) {
                            conr.count = 0;
                        }
                        r++;
                        l = 0;
                    }
                } else if (fire1) {
                    if (a == KeyEvent.VK_LEFT) {
                        m.x -= 10;
                        o.count++;
                        if (o.count >= 8) {
                            o.count = 0;
                        }
                        l++;
                        r = 0;
                    } else if (a == KeyEvent.VK_RIGHT) {
                        m.x += 10;
                        p.count++;
                        if (p.count >= 8) {
                            p.count = 0;
                        }
                        r++;
                        l = 0;
                    }
                } else {
                    if (a == KeyEvent.VK_LEFT) {
                        m.x -= 10;
                        n.count++;
                        if (n.count >= 8) {
                            n.count = 0;
                        }
                        l++;
                        r = 0;
                    } else if (a == KeyEvent.VK_RIGHT) {
                        m.x += 10;
                        m.count++;
                        if (m.count >= 8) {
                            m.count = 0;
                        }
                        r++;
                        l = 0;
                    }
                }
            }
        });
        m.x = 400;
        m.y = 500;
        time.start();
        t.start();
        paralyze.start();
        conf.start();
        tstarg1.start();
        tmeteor1.start();
        tstarr.start();
        tgreen.start();
        tred.start();
        fire.start();
        
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (times <= 0 || HP <= 0 && check == 1) {
            this.setLayout(null);
            g.drawImage(feildover2.getImage(), 0, 0, 1000, 800, this);
            g.setColor(Color.WHITE);
            g.setFont(new Font("Showcard Gothic", Font.BOLD, 60));
            g.drawString("SCORE   " + scor, 350, 400);
        time.stop();
        t.stop();
        paralyze.stop();
        conf.stop();
        tstarg1.stop();
        tmeteor1.stop();
        tstarr.stop();
        tgreen.stop();
        tred.stop();
        fire.stop();

        } else if (times <= 0 || HP <= 0 && check == 0) {
            this.setLayout(null);
            g.drawImage(feildover1.getImage(), 0, 0, 1000, 800, this);
            g.setColor(Color.WHITE);
            g.setFont(new Font("Showcard Gothic", Font.BOLD, 60));
            g.drawString("SCORE   " + scor, 350, 400);
        time.stop();
        t.stop();
        paralyze.stop();
        conf.stop();
        tstarg1.stop();
        tmeteor1.stop();
        tstarr.stop();
        tgreen.stop();
        tred.stop();
        fire.stop();
            
        } else if (scor > 100) {
            this.setLayout(null);
            g.drawImage(win.getImage(), 0, 0, 1000, 800, this);
            g.setColor(Color.red);
            g.setFont(new Font("Showcard Gothic", Font.BOLD, 40));
            g.drawString("SCORE   " + scor, 380, 200);
            g.setFont(new Font("Showcard Gothic", Font.BOLD, 60));
            g.setColor(Color.YELLOW);
            g.drawString("WIN!", 400, 150);
        time.stop();
        t.stop();
        paralyze.stop();
        conf.stop();
        tstarg1.stop();
        tmeteor1.stop();
        tstarr.stop();
        tgreen.stop();
        tred.stop();
        fire.stop();

        } else if (scor > 50) {
            check = 1;
            g.drawImage(imgstate2.getImage(), 0, 0, 1000, 800, this);
            if (conf1) {
                if (r == 0) {
                    g.drawImage(conq.qm[conq.count].getImage(), m.x, m.y, 110, 160, this);
                } else if (l == 0) {
                    g.drawImage(conr.rm[conr.count].getImage(), m.x, m.y, 110, 160, this);
                }
            } else if (fire1) {
                if (r == 0) {
                    g.drawImage(o.om[o.count].getImage(), m.x, m.y, 110, 160, this);
                } else if (l == 0) {
                    g.drawImage(p.pm[p.count].getImage(), m.x, m.y, 110, 160, this);
                }
            } else {
                if (l == 0) {
                    g.drawImage(m.lm[m.count].getImage(), m.x, m.y, 110, 160, this);
                } else if (r == 0) {
                    g.drawImage(n.rm[n.count].getImage(), m.x, m.y, 110, 160, this);
                }
            }
            if (m.x < 0) {
                m.x = this.getWidth() - 10;
            }
            if (m.x > this.getWidth()) {
                m.x = 20;
            }
            //===========starg================
            for (int i = 0; i < starg1.size(); i++) {
                g.drawImage(starg1.get(i).getImage(), starg1.get(i).getX(), starg1.get(i).getY(), 100, 100, this);
            }
            for (int j = 0; j < starg1.size(); j++) {
                if (Intersect(m.getbound(), starg1.get(j).getbound())) {
                    starg1.remove(j);
                    scor += 10;
                    g.drawString("+10", m.x + 100, m.y + 100); 
                }
            }
//            ==========starr================
            for (int i = 0; i < starr.size(); i++) {
                g.drawImage(starr.get(i).getImage(), starr.get(i).getX(), starr.get(i).getY(), 100, 100, this);
            }
            for (int j = 0; j < starr.size(); j++) {
                if (Intersect(m.getbound(), starr.get(j).getbound())) {
                    starr.remove(j);
                    scor -= 10;
                    g.drawString("-10", m.x + 100, m.y + 100);
                }
            }
//            =================================meteor=============
            for (int i = 0; i < meteor1.size(); i++) {
                g.drawImage(meteor1.get(i).getImage(), meteor1.get(i).getX(), meteor1.get(i).getY(), 100, 100, this);

            }
            for (int j = 0; j < meteor1.size(); j++) {
                if (Intersect(m.getbound(), meteor1.get(j).getbound())) {
                    meteor1.remove(j);
                    HP = HP - 1;
                    conr.count = 0;
                    conf1 = true;
                }
            }
            //========================================comet================= 
            for (int i = 0; i < comet.size(); i++) {
                g.drawImage(comet.get(i).getImage(), comet.get(i).getX(), comet.get(i).getY(), 100, 100, this);
            }
            for (int j = 0; j < comet.size(); j++) {
                if (Intersect(m.getbound(), comet.get(j).getbound())) {
                    comet.remove(j);
                    o.count = 0;
                    fire1 = true;
                }
            }
            g.setFont(new Font("Showcard Gothic", Font.BOLD, 25));
            g.setColor(Color.WHITE);
            g.drawString("Time " + times, 50, 130);
            g.drawString("SCORE =  " + scor, 50, 50);
            g.setColor(Color.RED);
            g.drawString("HP  " + HP, 50, 90);
            g.setFont(new Font("Showcard Gothic", Font.BOLD, 50));
            g.setColor(Color.WHITE);
            g.drawString("STATE " + rs1, 400, 75);
            
            /////////////////////score50//////////////////////
        } else {
            check = 0;
            g.drawImage(imgstate1.getImage(), 0, 0, 1000, 800, this);
            if (conf1) {
                if (r == 0) {
                    g.drawImage(conq.qm[conq.count].getImage(), m.x, m.y, 110, 160, this);
                } else if (l == 0) {
                    g.drawImage(conr.rm[conr.count].getImage(), m.x, m.y, 110, 160, this);
                }
            } else {
                if (l == 0) {
                    g.drawImage(m.lm[m.count].getImage(), m.x, m.y, 110, 160, this);
                } else if (r == 0) {
                    g.drawImage(n.rm[n.count].getImage(), m.x, m.y, 110, 160, this);
                }
            }
            if (m.x < 0) {
                m.x = this.getWidth() - 10;
            }
            if (m.x > this.getWidth()) {
                m.x = 20;
            }
            //========================================starg================= 
            for (int i = 0; i < starg1.size(); i++) {
                g.drawImage(starg1.get(i).getImage(), starg1.get(i).getX(), starg1.get(i).getY(), 100, 100, this);
            }
            for (int j = 0; j < starg1.size(); j++) {
                if (Intersect(m.getbound(), starg1.get(j).getbound())) {
                    starg1.remove(j);
                    scor += 10;
                    g.drawString("+10", m.x + 100, m.y + 100);
                }
            }
            //=================================meteor=============
            for (int i = 0; i < meteor1.size(); i++) {
                g.drawImage(meteor1.get(i).getImage(), meteor1.get(i).getX(), meteor1.get(i).getY(), 100, 100, this);
            }
            for (int j = 0; j < meteor1.size(); j++) {
                if (Intersect(m.getbound(), meteor1.get(j).getbound())) {
                    meteor1.remove(j);
                    HP = HP - 1;
                    conr.count = 0;
                    conf1 = true;
                }
            }
                        //========================================green================= 
            for (int i = 0; i < green.size(); i++) {
                g.drawImage(green.get(i).getImage(), green.get(i).getX(), green.get(i).getY(), 100, 100, this);
            }
            for (int j = 0; j < green.size(); j++) {
                if (Intersect(m.getbound(), green.get(j).getbound())) {
                    green.remove(j);
                    c = 1;
                }
            }
            g.setFont(new Font("Showcard Gothic", Font.BOLD, 25));
            g.setColor(Color.BLACK);
            g.drawString("Time " + times, 50, 130);
            g.drawString("SCORE =  " + scor, 50, 50);
            g.setColor(Color.RED);
            g.drawString("HP  " + HP, 50, 90);
            g.setFont(new Font("Showcard Gothic", Font.BOLD, 50));
            g.setColor(Color.WHITE);
            g.drawString("STATE " + rs1, 400, 75);
        }
    }

    public boolean Intersect(Rectangle2D a, Rectangle2D b) {
        return (a.intersects(b));
    }

    public void actionPerformed(ActionEvent e) {
    }
}
