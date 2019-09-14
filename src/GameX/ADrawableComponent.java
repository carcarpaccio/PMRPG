package GameX;

import java.awt.*;

public abstract class ADrawableComponent {

    private int x;
    private int y;
    private EDirection direction;

    protected Image image;

    public ADrawableComponent() {
        x = 0;
        y = 0;
        direction=EDirection.eDown;
        image = null;
    }

    /**
     * 重なってるか判定する
     *
     * @param drawableComponent 判定する対象
     * @return 重なっているかどうか
     */
    public boolean overlapTo(ADrawableComponent drawableComponent) {

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

    public EDirection getDirection() {
        return direction;
    }

    public void setDirection(EDirection direction) {
        this.direction = direction;
    }
}
