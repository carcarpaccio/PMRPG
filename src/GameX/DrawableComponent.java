package GameX;

import java.awt.*;
import java.util.ArrayList;

abstract public class DrawableComponent {

    private int x;
    private int y;

    protected ArrayList<Image> images;
    protected int currentImageIndex;

    public DrawableComponent() {
        x = 1;
        y = 1;
        images=new ArrayList<>();
        currentImageIndex=0;
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
        return images.get(currentImageIndex);
    }

    public void loadImage(String path) {
        Image image=Toolkit.getDefaultToolkit().getImage(path);
        if(image==null) return;
        images.add(image);
    }
    abstract void setCurrentImageIndex(int index);




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
