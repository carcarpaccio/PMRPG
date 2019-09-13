package GameX;
import java.awt.*;
import java.awt.event.KeyEvent;


public class TitlePanelA extends AGamePanel {
    public TitlePanelA(IChangeScene changeScene) {
        super(changeScene);
        super.setVisible(true);
        super.setFocusable(true);
        System.out.println("Title画面");
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
        g.drawImage(Toolkit.getDefaultToolkit().getImage("src\\Game\\街.PNG"),  10,10,400,400,this);
    }
}
