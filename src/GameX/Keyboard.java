package GameX;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;



public class Keyboard extends KeyAdapter {
        private int[] key;

        public Keyboard(){
            key = new int[256];
        }

        @Override
        public void keyPressed(KeyEvent e) {
            key[e.getKeyCode()]++;
        }

        @Override
        public void keyReleased(KeyEvent e) {
            super.keyReleased(e);
            key[e.getKeyCode()] = 0;
        }

        public int getPressedFrame(int keyCode){
            return key[keyCode];
        }

}
