package GameX;

public class DirectionDrawableComponent extends DrawableComponent {
    private EDirection direction;

    DirectionDrawableComponent(){
        setDirection(EDirection.eDown);
    }

    public boolean initialize() {

        loadImage("C:\\Users\\yarn_\\IdeaProjects\\ProjectMember\\src\\GameX\\pipo-charachip001.png");
        return true;

    }


    public EDirection getDirection() {
        return direction;
    }

    public void setDirection(EDirection direction) {
        this.direction = direction;
    }
}
