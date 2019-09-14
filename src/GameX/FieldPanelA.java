package GameX;
import java.awt.*;
import java.awt.event.KeyEvent;

public class FieldPanelA extends AGamePanel {

    int length;
    DirectionDrawableComponent hero=new DirectionDrawableComponent();

    public FieldPanelA(IChangeScene changeScene){
        super(changeScene);
        setVisible(true);
        System.out.println("Field画面");
        length=40;
    }

    @Override
    public boolean initialize() {
        if(!hero.initialize()) System.out.println("へろ読めねー");
        return true;
    }

    @Override
    public void update() {
                if (GameManager.keyboard.getPressedFrame(KeyEvent.VK_UP) > 0) {
                    hero.setY(hero.getY() - length);
                    hero.setDirection(EDirection.eUp);
                } else if (GameManager.keyboard.getPressedFrame(KeyEvent.VK_DOWN) > 0) {
                    hero.setY(hero.getY() + length);
                    hero.setDirection(EDirection.eDown);
                } else if (GameManager.keyboard.getPressedFrame(KeyEvent.VK_RIGHT) > 0) {
                    hero.setX(hero.getX() + length);
                    hero.setDirection(EDirection.eRight);
                } else if (GameManager.keyboard.getPressedFrame(KeyEvent.VK_LEFT) > 0) {
                    hero.setX(hero.getX() - length);
                    hero.setDirection(EDirection.eLeft);

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
        //g.drawImage(hero.getImage(),(int)hero.getX(),(int) hero.getY(),40,40,this);
        g.drawImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\yarn_\\IdeaProjects\\ProjectMember\\src\\Game\\街.PNG"),  0,0,400,400,this);
        switch (hero.getDirection()){

            case eRight:
                g.drawImage(hero.getImage(),hero.getX(),hero.getY(),length+hero.getX(),length+hero.getY(),32,64,64,96,this);
                break;
            case eLeft:
                g.drawImage(hero.getImage(),hero.getX(),hero.getY(),length+hero.getX(),length+hero.getY(),32,32,64,64,this);
                break;
            case eUp:
                g.drawImage(hero.getImage(),hero.getX(),hero.getY(),length+hero.getX(),length+hero.getY(),32,96,64,128,this);
                break;
            case eDown:
                g.drawImage(hero.getImage(),hero.getX(),hero.getY(),length+hero.getX(),length+hero.getY(),32,0,64,32,this);
                break;
            case eNone:
                break;
        }
    }
}
