package GameX;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;



public class Keyboard extends KeyAdapter {
        private int[] key;
        private boolean availabkekey;
        public Keyboard(){
            key = new int[256];
            availabkekey=true;
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if(availabkekey)    key[e.getKeyCode()]++;
        }

        @Override
        public void keyReleased(KeyEvent e) {
            super.keyReleased(e);
            key[e.getKeyCode()] = 0;
        }

        public int getPressedFrame(int keyCode){
            return key[keyCode];
        }

    public boolean isAvailabkekey() {
        return availabkekey;
    }

    public void setAvailabkekey(boolean availabkekey) {
        this.availabkekey = availabkekey;
    }
}
