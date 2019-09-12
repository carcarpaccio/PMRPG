package Game;
import java.awt.event.*;

public class MoveController extends KeyAdapter {

        private  GamePanel gamepanel;
        //コンストラクタ
        public MoveController(GamePanel gamepanel) {
            this.gamepanel = gamepanel;
        }

        // キーが押された際に呼び出される
        public void keyPressed(KeyEvent e) {
            // if 入力されたキーが「上」
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                // ボールを上 (-y) 方向へ 1 マス移動
                this.gamepanel.Update(0, -1);
            }
            // else if 入力されたキーが「下」
            else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                // ボールを下 (+y) 方向へ 1 マス移動
                this.gamepanel.Update(0, +1);
                System.out.println("a");
            }
            // else if 入力されたキーが「左」
            else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                // ボールを左 (-x) 方向へ 1 マス移動
                this.gamepanel.Update(-1, 0);
            }
            // else if 入力されたキーが「右」
            else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                // ボールを右 (+x) 方向へ 1 マス移動
                this.gamepanel.Update(+1, 0);
            }
        }
    }
