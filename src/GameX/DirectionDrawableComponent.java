package GameX;


public class DirectionDrawableComponent extends DrawableComponent {
    private EDirection direction;

    DirectionDrawableComponent(){
        setDirection(EDirection.eDown);
    }

    public boolean initialize() {

        loadImage("C:\\Users\\yarn_\\Downloads\\Character-20190917T100633Z-001.zip\\Character");
        loadImage("C:\\Users\\yarn_\\Downloads\\Character-20190917T100633Z-001.zip\\Character");
        loadImage("C:\\Users\\yarn_\\Downloads\\Character-20190917T100633Z-001.zip\\Character");
        loadImage("");
        return true;

    }


    public EDirection getDirection() {
        return direction;
    }

    public void setDirection(EDirection direction) {
        this.direction = direction;
    }

    @Override
    void setCurrentImageIndex(int index) {
        currentImageIndex=index%4;
    }
}
