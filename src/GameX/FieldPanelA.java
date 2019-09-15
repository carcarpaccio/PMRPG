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
        keycount=new Counter(); //マス目移動の中間のためのカウント

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
            if (GameManager.keyboard.getPressedFrame(KeyEvent.VK_UP) > 0 || keycount.getCount() < 4 && keycount.getCount() > 0 && hero.getDirection() == EDirection.eUp) {
                hero.setDirection(EDirection.eUp);
                hero.setY(hero.getY() - length / 4);
                keycount.update();
                GameManager.keyboard.setAvailabkekey(false);
            } else if (GameManager.keyboard.getPressedFrame(KeyEvent.VK_DOWN) > 0 || keycount.getCount() < 4 && keycount.getCount() > 0 && hero.getDirection() == EDirection.eDown) {
                hero.setDirection(EDirection.eDown);
                hero.setY(hero.getY() + length / 4);
                keycount.update();
                GameManager.keyboard.setAvailabkekey(false);
            } else if (GameManager.keyboard.getPressedFrame(KeyEvent.VK_RIGHT) > 0 || keycount.getCount() < 4 && keycount.getCount() > 0 && hero.getDirection() == EDirection.eRight) {
                hero.setDirection(EDirection.eRight);
                hero.setX(hero.getX() + length / 4);
                keycount.update();
                GameManager.keyboard.setAvailabkekey(false);
            } else if (GameManager.keyboard.getPressedFrame(KeyEvent.VK_LEFT) > 0 || keycount.getCount() < 4 && keycount.getCount() > 0 && hero.getDirection() == EDirection.eLeft) {
                hero.setDirection(EDirection.eLeft);
                hero.setX(hero.getX() - length / 4);
                keycount.update();
                GameManager.keyboard.setAvailabkekey(false);
            }
            if(keycount.getCount()==4){ //四回動いたらキーボード入力受付
                keycount.reset();
                GameManager.keyboard.setAvailabkekey(true);
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
