package Game;
import java.awt.*;
import javax.swing.*;
public class GameFrame extends JFrame{
    static GameFrame gameFrame;
    JPanel gamepanel;
    GameFrame(JPanel gamePanel){

        this.gamepanel=gamePanel;
        add(this.gamepanel);
        setTitle("RPG");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack(); // setPreferredSize() が定義されていれば、pack メソッドで自動的にサイズを調整
        setVisible(true); //フレームの表示


        //描画のインスタンス化＆描写スレッドstart
        Thread campus=new Campus(this);
        campus.start();



    }

    void ChangeFrame(JPanel GamePanel) {    //画面遷移クラス
        this.gamepanel.setVisible(false);//前の画面を消す
        remove(gamepanel);
        this.gamepanel = GamePanel;         //次の画面情報を取得
        add(this.gamepanel);                //同上
        this.gamepanel.setVisible(true);    //次の画面を表示
    }

    public Dimension getPreferredSize() {
        // return 180x180
        return new Dimension(435, 455);
    }
}

