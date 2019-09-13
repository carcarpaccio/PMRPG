package GameX;

public class Hero extends ADrawableComponent {
    public Hero() {

    }

    public boolean initialize() {
        loadImage("src\\GameX\\A.jpg");
        return true;
    }
}
