package GameX;
import java.awt.*;
import java.awt.event.KeyEvent;

public class FieldPanelA extends AGamePanel {
    boolean key_availavle;

    Hero hero;
    Hero man;

    public FieldPanelA(IChangeScene changeScene){
        super(changeScene);
        setVisible(true);
        System.out.println("Field画面");
        hero=new Hero();
        man = new Hero();
        man.setX(man.getX()+100);
        key_availavle=true;
    }

    @Override
    public boolean initialize() {
        if(!hero.initialize()) System.out.println("へろ読めねー");
        return true;
    }

    @Override
    public void update() {
        if(key_availavle) {
            key_availavle=false;
            for(int i=0;i<40;i++) {
                if (GameManager.keyboard.getPressedFrame(KeyEvent.VK_UP) > 0) {
                    hero.setY(hero.getY() - 1);
                    hero.setDirection(EDirection.eUp);
                } else if (GameManager.keyboard.getPressedFrame(KeyEvent.VK_DOWN) > 0) {
                    hero.setY(hero.getY() + 1);
                    hero.setDirection(EDirection.eDown);
                } else if (GameManager.keyboard.getPressedFrame(KeyEvent.VK_RIGHT) > 0) {
                    hero.setX(hero.getX() + 1);
                    hero.setDirection(EDirection.eRight);
                } else if (GameManager.keyboard.getPressedFrame(KeyEvent.VK_LEFT) > 0) {
                    hero.setX(hero.getX() - 1);
                    hero.setDirection(EDirection.eLeft);
                }
            }
            key_availavle=true;
        }
            if (hero.overlapTo(man)) {
                System.out.println("できた");
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
        if(hero.getDirection()==EDirection.eDown)           g.drawImage(hero.getImage(),0+(int)hero.getX(),0+(int)hero.getY(),40+(int)hero.getX(),40+(int)hero.getY(),32,0,64,32,this);
        else if(hero.getDirection()==EDirection.eLeft)        g.drawImage(hero.getImage(),0+(int)hero.getX(),0+(int)hero.getY(),40+(int)hero.getX(),40+(int)hero.getY(),32,32,64,64,this);
        else if(hero.getDirection()==EDirection.eRight)     g.drawImage(hero.getImage(),0+(int)hero.getX(),0+(int)hero.getY(),40+(int)hero.getX(),40+(int)hero.getY(),32,64,64,96,this);
        else if(hero.getDirection()==EDirection.eUp)      g.drawImage(hero.getImage(),0+(int)hero.getX(),0+(int)hero.getY(),40+(int)hero.getX(),40+(int)hero.getY(),32,96,64,128,this);
    }
}
