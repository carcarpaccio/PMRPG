package GameX;


public class DirectionDrawableComponent extends DrawableComponent {
    private EDirection direction;

    DirectionDrawableComponent(){
        setDirection(EDirection.eDown);
    }

    public boolean initialize() {

        loadImage("C:\\Users\\yarn_\\IdeaProjects\\ProjectMember\\src\\GameX\\Charactar\\char0.png");
        loadImage("C:\\Users\\yarn_\\IdeaProjects\\ProjectMember\\src\\GameX\\Charactar\\char1.png");
        loadImage("C:\\Users\\yarn_\\IdeaProjects\\ProjectMember\\src\\GameX\\Charactar\\char2.png");
        loadImage("C:\\Users\\yarn_\\IdeaProjects\\ProjectMember\\src\\GameX\\Charactar\\char3.png");
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
