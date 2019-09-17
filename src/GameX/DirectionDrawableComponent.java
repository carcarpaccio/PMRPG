package GameX;


public class DirectionDrawableComponent extends DrawableComponent {
    private EDirection direction;

    DirectionDrawableComponent(){
        setDirection(EDirection.eDown);
    }

    public boolean initialize() {

        loadImage("C:\\Users\\yarn_\\IdeaProjects\\ProjectMember\\src\\GameX\\Charactar\\right0.png");
        loadImage("C:\\Users\\yarn_\\IdeaProjects\\ProjectMember\\src\\GameX\\Charactar\\right1.png");
        loadImage("C:\\Users\\yarn_\\IdeaProjects\\ProjectMember\\src\\GameX\\Charactar\\right2.png");
        loadImage("C:\\Users\\yarn_\\IdeaProjects\\ProjectMember\\src\\GameX\\Charactar\\right3.png");

        loadImage("C:\\Users\\yarn_\\IdeaProjects\\ProjectMember\\src\\GameX\\Charactar\\left0.png");
        loadImage("C:\\Users\\yarn_\\IdeaProjects\\ProjectMember\\src\\GameX\\Charactar\\left1.png");
        loadImage("C:\\Users\\yarn_\\IdeaProjects\\ProjectMember\\src\\GameX\\Charactar\\left2.png");
        loadImage("C:\\Users\\yarn_\\IdeaProjects\\ProjectMember\\src\\GameX\\Charactar\\left3.png");

        loadImage("C:\\Users\\yarn_\\IdeaProjects\\ProjectMember\\src\\GameX\\Charactar\\front0.png");
        loadImage("C:\\Users\\yarn_\\IdeaProjects\\ProjectMember\\src\\GameX\\Charactar\\front1.png");
        loadImage("C:\\Users\\yarn_\\IdeaProjects\\ProjectMember\\src\\GameX\\Charactar\\front2.png");
        loadImage("C:\\Users\\yarn_\\IdeaProjects\\ProjectMember\\src\\GameX\\Charactar\\front3.png");

        loadImage("C:\\Users\\yarn_\\IdeaProjects\\ProjectMember\\src\\GameX\\Charactar\\buck0.png");
        loadImage("C:\\Users\\yarn_\\IdeaProjects\\ProjectMember\\src\\GameX\\Charactar\\buck1.png");
        loadImage("C:\\Users\\yarn_\\IdeaProjects\\ProjectMember\\src\\GameX\\Charactar\\buck2.png");
        loadImage("C:\\Users\\yarn_\\IdeaProjects\\ProjectMember\\src\\GameX\\Charactar\\buck3.png");
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
        currentImageIndex=index;
    }
}
