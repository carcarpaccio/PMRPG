package GameX;
import java.awt.*;
import java.awt.event.KeyEvent;

public class FieldPanelA extends AGamePanel {

    int length;
    DirectionDrawableComponent hero=new DirectionDrawableComponent();

    Counter count;
    Counter keycount;

    public FieldPanelA(IChangeScene changeScene){
        super(changeScene);
        setVisible(true);
        System.out.println("Field画面");
        length=40;
        count=new Counter();
        keycount=new Counter();
    }

    @Override
    public boolean initialize() {
        if(!hero.initialize()) System.out.println("へろ読めねー");
        return true;
    }

    @Override
    public void update() {
        count.update();
        if(GameManager.keyboard.isAvailabkekey()){
            count.update();
            GameManager.keyboard.setAvailabkekey(false);
        }
            if (GameManager.keyboard.getPressedFrame(KeyEvent.VK_UP) > 0&&) {
                hero.setY(hero.getY() - length / 4);
                hero.setDirection(EDirection.eUp);
            } else if (GameManager.keyboard.getPressedFrame(KeyEvent.VK_DOWN) > 0) {
                hero.setY(hero.getY() + length / 4);
                hero.setDirection(EDirection.eDown);
            } else if (GameManager.keyboard.getPressedFrame(KeyEvent.VK_RIGHT) > 0) {
                hero.setX(hero.getX() + length / 4);
                hero.setDirection(EDirection.eRight);
            } else if (GameManager.keyboard.getPressedFrame(KeyEvent.VK_LEFT) > 0) {
                hero.setX(hero.getX() - length / 4);
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



        if(count.getCount()>=0   )hero.setCurrentImageIndex(0);
        if(count.getCount()>=10  )hero.setCurrentImageIndex(1);
        if(count.getCount()>=20  )hero.setCurrentImageIndex(2);
        if(count.getCount()>=30  )hero.setCurrentImageIndex(3);

        switch (hero.getDirection()){
            case eRight:
                g.drawImage(hero.getImage(),hero.getX(),hero.getY(),hero.getImage().getWidth(this),hero.getImage().getWidth(this),this);
                break;
            case eLeft:
                g.drawImage(hero.getImage(),hero.getX(),hero.getY(),hero.getImage().getWidth(this),hero.getImage().getWidth(this),this);
                break;
            case eUp:
                g.drawImage(hero.getImage(),hero.getX(),hero.getY(),hero.getImage().getWidth(this),hero.getImage().getWidth(this),this);
                break;
            case eDown:
                g.drawImage(hero.getImage(),hero.getX(),hero.getY(),hero.getImage().getWidth(this),hero.getImage().getWidth(this),this);
                break;
            case eNone:
                break;
        }
        if(count.getCount()>=40)    count.reset();
    }
}
