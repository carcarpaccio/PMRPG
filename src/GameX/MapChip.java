package GameX;

public class MapChip extends DrawableComponent{
    final private int width=40;
    final private int height=40;
    MapChip(){
        loadImage("C:\\Users\\yarn_\\IdeaProjects\\ProjectMember\\src\\GameX\\Charactar\\Village.png");//house
        this.setX(width*6);
        this.setY(height*7);
    }
    @Override
    void setCurrentImageIndex(int index) {

    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
