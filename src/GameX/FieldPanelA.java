package GameX;
import java.awt.*;
import java.awt.event.KeyEvent;

public class FieldPanelA extends AGamePanel {


    DirectionDrawableComponent hero=new DirectionDrawableComponent();

    int length;
    Counter count;
    Counter keycount;

    FieldA fieldA;
    FieldManager fieldManager;

    public FieldPanelA(IChangeScene changeScene){
        super(changeScene);
        setVisible(true);
        System.out.println("Field画面");
        length=40;
        count=new Counter();    //足踏み処理の買うんと

        fieldA =new FieldA();
        fieldManager=new FieldManager(fieldA,hero);
    }

    @Override
    public boolean initialize() {
        if(!hero.initialize()) System.out.println("へろ読めねー");
        return true;
    }

    @Override
    public void update() {
        count.update();
            if (GameManager.keyboard.getPressedFrame(KeyEvent.VK_UP) > 0 ) {
                hero.setDirection(EDirection.eUp);
                hero.setY(hero.getY() - length );
            } else if (GameManager.keyboard.getPressedFrame(KeyEvent.VK_DOWN) > 0 ) {
                hero.setDirection(EDirection.eDown);
                hero.setY(hero.getY() + length );
            } else if (GameManager.keyboard.getPressedFrame(KeyEvent.VK_RIGHT) > 0 ) {
                hero.setDirection(EDirection.eRight);
                hero.setX(hero.getX() + length );
            } else if (GameManager.keyboard.getPressedFrame(KeyEvent.VK_LEFT) > 0 ) {
                hero.setDirection(EDirection.eLeft);
                hero.setX(hero.getX() - length );
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
                if(count.getCount()>=0   )hero.setCurrentImageIndex(0);
                if(count.getCount()>=10  )hero.setCurrentImageIndex(1);
                if(count.getCount()>=20  )hero.setCurrentImageIndex(2);
                if(count.getCount()>=30  )hero.setCurrentImageIndex(3);
                g.drawImage(hero.getImage(),hero.getX(),hero.getY(),hero.getImage().getWidth(this),hero.getImage().getWidth(this),this);
                break;
            case eLeft:
                if(count.getCount()>=0   )hero.setCurrentImageIndex(4);
                if(count.getCount()>=10  )hero.setCurrentImageIndex(5);
                if(count.getCount()>=20  )hero.setCurrentImageIndex(6);
                if(count.getCount()>=30  )hero.setCurrentImageIndex(7);
                g.drawImage(hero.getImage(),hero.getX(),hero.getY(),hero.getImage().getWidth(this),hero.getImage().getWidth(this),this);
                break;
            case eUp:
                if(count.getCount()>=0   )hero.setCurrentImageIndex(8);
                if(count.getCount()>=10  )hero.setCurrentImageIndex(9);
                if(count.getCount()>=20  )hero.setCurrentImageIndex(10);
                if(count.getCount()>=30  )hero.setCurrentImageIndex(11);
                g.drawImage(hero.getImage(),hero.getX(),hero.getY(),hero.getImage().getWidth(this),hero.getImage().getWidth(this),this);
                break;
            case eDown:
                if(count.getCount()>=0   )hero.setCurrentImageIndex(12);
                if(count.getCount()>=10  )hero.setCurrentImageIndex(13);
                if(count.getCount()>=20  )hero.setCurrentImageIndex(14);
                if(count.getCount()>=30  )hero.setCurrentImageIndex(15);
                g.drawImage(hero.getImage(),hero.getX(),hero.getY(),hero.getImage().getWidth(this),hero.getImage().getWidth(this),this);
                break;
            case eNone:
                break;
        }
        if(count.getCount()>=40)    count.reset();
    }
}
