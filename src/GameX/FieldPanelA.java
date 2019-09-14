package GameX;
import java.awt.*;
import java.awt.event.KeyEvent;

public class FieldPanelA extends AGamePanel {

    Hero hero;
    Hero man;

    public FieldPanelA(IChangeScene changeScene){

        super(changeScene);
        setVisible(true);
        System.out.println("Field画面");
        hero=new Hero();
        man = new Hero();
        man.setX(man.getX()+100);
    }

    @Override
    public boolean initialize() {
        if(!hero.initialize()) System.out.println("へろ読めねー");
        return true;
    }

    @Override
    public void update() {
        if(GameManager.keyboard.getPressedFrame(KeyEvent.VK_UP) > 0) {hero.setY(hero.getY()-1);}
        else if(GameManager.keyboard.getPressedFrame(KeyEvent.VK_DOWN) > 0){hero.setY(hero.getY()+1);}
        else if(GameManager.keyboard.getPressedFrame(KeyEvent.VK_RIGHT) > 0){hero.setX(hero.getX()+1);}
        else if(GameManager.keyboard.getPressedFrame(KeyEvent.VK_LEFT) > 0){hero.setX(hero.getX()-1);}

        if(hero.overlapTo(man)){
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
        g.drawImage(Toolkit.getDefaultToolkit().getImage("src\\Game\\街.PNG"),  10,10,400,400,this);
        g.drawImage(hero.getImage(),(int)hero.getX(),(int) hero.getY(),40,40,this);

    }
}
