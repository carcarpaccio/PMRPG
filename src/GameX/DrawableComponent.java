package GameX;

import java.awt.*;

public class DrawableComponent {

    private int x;
    private int y;


    protected Image image;

    public DrawableComponent() {
        x = 0;
        y = 0;
        image = null;
    }

    /**
     * 重なってるか判定する
     *
     * @param drawableComponent 判定する対象
     * @return 重なっているかどうか
     */
    public boolean overlapTo(DrawableComponent drawableComponent) {

        if (this.x == drawableComponent.x && this.y == drawableComponent.y){
            return true;
        }

        return false;
    }


    public Image getImage() {
        return image;
    }

    public void loadImage(String path) {
        image = Toolkit.getDefaultToolkit().getImage(path);
    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

}
