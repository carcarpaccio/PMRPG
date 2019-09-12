package GameX;
import java.awt.*;

public class Hero {
    private int x;     //操作キャラの座標
    private int y;

    private Image image;   //操作キャラの画像

    Hero(){
        x=50;
        y=50;
        image = Toolkit.getDefaultToolkit().getImage("C:\\Users\\yarn_\\IdeaProjects\\ProjectMember\\src\\GameX\\A.jpg");//画像の取り込み
    }

    public boolean initialize() {

        if(image==null) return false;
        return true;
    }


    public Image getImage() {
        return image;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getY() {
        return y;
    }

}
