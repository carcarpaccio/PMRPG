package GameX;

public class MapChip extends ADrawableComponent {
    private int width;
    private int height;

    public MapChip(){
        setWidth(0);
        setHeight(0);
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
