package GameX;

import java.awt.*;

import static java.awt.event.KeyEvent.*;

public class FieldPanelA extends AGamePanel {
    private Counter counter;
    private MapChip mapChip;
    private EDirection direction;
    private int waitTime;

    public FieldPanelA(IChangeScene changeScene) {
        super(changeScene);
        setVisible(true);
        System.out.println("Field画面");

        mapChip = new MapChip();
        counter = new Counter();
        direction = EDirection.eNone;
        waitTime = 0;
    }

    @Override
    public boolean initialize() {
        mapChip.loadImage("src\\GameX\\A.jpg");
        return true;
    }

    @Override
    public void update() {
        if (GameManager.keyboard.getPressedFrame(VK_UP) > 0) {
            direction = EDirection.eUp;
        }
        else if (GameManager.keyboard.getPressedFrame(VK_DOWN) > 0) {
            direction = EDirection.eDown;
        }
        else if (GameManager.keyboard.getPressedFrame(VK_RIGHT) > 0) {
            direction = EDirection.eRight;
        }
        else if (GameManager.keyboard.getPressedFrame(VK_LEFT) > 0) {
            direction = EDirection.eLeft;
        }else{
            direction = EDirection.eNone;
        }

        if(direction != EDirection.eNone && waitTime == 0){
            switch (direction){
                case eRight:
                    mapChip.setX(mapChip.getX()+64);
                    break;
                case eDown:
                    mapChip.setY(mapChip.getY()+64);
                    break;
                case eLeft:
                    mapChip.setX(mapChip.getX()-64);
                    break;
                case eUp:
                    mapChip.setY(mapChip.getY()-64);
                    break;
            }
            direction = EDirection.eNone;
            waitTime = 10;
        }
        if(waitTime > 0)waitTime--;

        counter.update();
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
        g.drawImage(Toolkit.getDefaultToolkit().getImage("src/Game/街.PNG"), 0, 0, 64 * 10, 64 * 10, this);
        g.drawImage(mapChip.getImage(), mapChip.getX(), mapChip.getY(), 64, 64, this);
    }
}
