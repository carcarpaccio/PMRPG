package GameX;
import java.awt.*;
import java.awt.event.KeyEvent;

public class FieldPanelA extends AGamePanel {
    boolean push=true;
    Hero hero;
    public FieldPanelA(IChangeScene changeScene){

        super(changeScene);
        setVisible(true);
        System.out.println("Field画面");
        hero=new Hero();
    }

    @Override
    public boolean initialize() {
        if(!hero.initialize()) System.out.println("へろ読めねー");
        return true;
    }

    @Override
    public void update() {
        if (push) {
            push = false;
            if (GameManager.keyboard.getPressedFrame(KeyEvent.VK_UP) > 0) {
                hero.setY(hero.getY() - 1);
            } else if (GameManager.keyboard.getPressedFrame(KeyEvent.VK_DOWN) > 0) {
                for (int i = 0; i < 9; i++) {
                    if (i == 0) System.out.println("0ho");
                    if (i == 2) System.out.println("1po");
                    else if (i == 5) System.out.println("2ho");
                    hero.setY(hero.getY() + Field.squea_length / 40);
                }
            } else if (GameManager.keyboard.getPressedFrame(KeyEvent.VK_RIGHT) > 0) {
                hero.setX(hero.getX() + 1);
            } else if (GameManager.keyboard.getPressedFrame(KeyEvent.VK_LEFT) > 0) {
                hero.setX(hero.getX() - 1);
            }
            push = true;
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
        g.drawImage(hero.getImage(),hero.getX(),hero.getY(),40,40,this);
        //g.drawImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\yarn_\\IdeaProjects\\ProjectMember\\src\\Game\\街.PNG"),  20,20,400,400,this);
    }
}
