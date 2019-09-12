package GameX;import javax.swing.*;
import java.awt.*;


public class GameManager extends Thread implements IChangeScene {
    private JFrame frame;
    private AGamePanel panel;
    public static Keyboard keyboard;
    private EGameScene nextGameScene;//画面遷移後パネル

    public GameManager() {
        nextGameScene = EGameScene.eNone;
        keyboard = new Keyboard();
        frame = new JFrame();
        frame.addKeyListener(keyboard);
        frame.setBounds(0, 0, 400, 400);

        frame.setVisible(true);

        this.panel = new TitlePanelA(this);
        frame.add(panel);

    }

    public void run() {
        while (true) {
            if(nextGameScene != EGameScene.eNone) {
                panel.destroy();    //前ぺージ削除
                switch (nextGameScene) {
                    case eField:
                        panel = new FieldPanelA(this);
                        break;
                    case eTitle:
                        panel = new TitlePanelA(this);
                        break;
                }
                panel.initialize();     //次ページの画像描写
                nextGameScene=EGameScene.eNone;
                frame.add(panel);
                frame.setVisible(true);
            }

            try {
                panel.update();
                frame.repaint();
                Thread.sleep(25);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public void changeScene(EGameScene gameScene) {
        this.nextGameScene = gameScene;
    }
}
