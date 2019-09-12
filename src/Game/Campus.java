package Game;

import javax.swing.*;

public class Campus extends Thread {
    JFrame jframe;
    Campus(JFrame frame){
        this.jframe=frame;
    }
    public  void run(){
        while(true){
            try {
                Thread.sleep(25);
                jframe.repaint();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
