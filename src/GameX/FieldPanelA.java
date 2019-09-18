package GameX;
import java.awt.*;
import java.awt.event.KeyEvent;

public class FieldPanelA extends AGamePanel {


    DirectionDrawableComponent hero=new DirectionDrawableComponent();

    int length;
    Counter count;
    Counter cooltime;

    FieldA fieldA;
    FieldManager fieldManager;

    int waittime;

    public FieldPanelA(IChangeScene changeScene){
        super(changeScene);
        setVisible(true);
        System.out.println("Field画面");
        length=40;
        count=new Counter();    //足踏み処理の買うんと
        cooltime=new Counter();

        fieldA =new FieldA();
        fieldManager=new FieldManager(fieldA,hero);

        waittime=0;
    }

    @Override
    public boolean initialize() {
        if(!hero.initialize()) System.out.println("へろ読めねー");
        return true;
    }

    @Override
    public void update() {
        count.update();
        if(cooltime.getCount()==0) {
            if (GameManager.keyboard.getPressedFrame(KeyEvent.VK_UP) > 0) {
                if (fieldManager.beforecheck(EDirection.eUp) && hero.getDirection() == EDirection.eUp)
                    hero.setY(hero.getY() - length);
                hero.setDirection(EDirection.eUp);
                cooltime.setCount(4);
            } else if (GameManager.keyboard.getPressedFrame(KeyEvent.VK_DOWN) > 0) {
                if (fieldManager.beforecheck(EDirection.eDown) && hero.getDirection() == EDirection.eDown)
                    hero.setY(hero.getY() + length);
                hero.setDirection(EDirection.eDown);
                cooltime.setCount(4);
            } else if (GameManager.keyboard.getPressedFrame(KeyEvent.VK_RIGHT) > 0) {
                if (fieldManager.beforecheck(EDirection.eRight) && hero.getDirection() == EDirection.eRight)
                    hero.setX(hero.getX() + length);
                hero.setDirection(EDirection.eRight);
                cooltime.setCount(4);
            } else if (GameManager.keyboard.getPressedFrame(KeyEvent.VK_LEFT) > 0) {
                if (fieldManager.beforecheck(EDirection.eLeft) && hero.getDirection() == EDirection.eLeft)
                    hero.setX(hero.getX() - length);
                hero.setDirection(EDirection.eLeft);
                cooltime.setCount(4);
            }
        }
        if(cooltime.getCount()>0)   cooltime.countdown();
            switch (hero.getDirection()) {
                case eRight:
                    if (count.getCount() >= 0) hero.setCurrentImageIndex(0);
                    if (count.getCount() >= 10) hero.setCurrentImageIndex(1);
                    if (count.getCount() >= 20) hero.setCurrentImageIndex(2);
                    if (count.getCount() >= 30) hero.setCurrentImageIndex(3);
                    break;
                case eLeft:
                    if (count.getCount() >= 0) hero.setCurrentImageIndex(4);
                    if (count.getCount() >= 10) hero.setCurrentImageIndex(5);
                    if (count.getCount() >= 20) hero.setCurrentImageIndex(6);
                    if (count.getCount() >= 30) hero.setCurrentImageIndex(7);
                    break;
                case eUp:
                    if (count.getCount() >= 0) hero.setCurrentImageIndex(12);
                    if (count.getCount() >= 10) hero.setCurrentImageIndex(13);
                    if (count.getCount() >= 20) hero.setCurrentImageIndex(14);
                    if (count.getCount() >= 30) hero.setCurrentImageIndex(15);
                    break;
                case eDown:
                    if (count.getCount() >= 0) hero.setCurrentImageIndex(8);
                    if (count.getCount() >= 10) hero.setCurrentImageIndex(9);
                    if (count.getCount() >= 20) hero.setCurrentImageIndex(10);
                    if (count.getCount() >= 30) hero.setCurrentImageIndex(11);
                    break;
                case eNone:
                    break;
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






        g.drawImage(hero.getImage(),hero.getX(),hero.getY(),hero.getImage().getWidth(this),hero.getImage().getWidth(this),this);

        if(count.getCount()>=40)    count.reset();
    }
}
