package GameX;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;


public class TitlePanelA extends AGamePanel {
    public TitlePanelA(IChangeScene changeScene) {
        super(changeScene);
        add(new JLabel("ENTER START"));
        super.setVisible(true);
        super.setFocusable(true);
    }

    @Override
    public boolean initialize() {
        return true;
    }

    @Override
    public void update() {
        if(GameManager.keyboard.getPressedFrame(KeyEvent.VK_ENTER) > 0) {
            scene.changeScene(EGameScene.eField);
        }

    }

    @Override
    public void destroy() {
       setVisible(false);
       remove(this);
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.clearRect(0, 0, getWidth(), getHeight());
    }
}
