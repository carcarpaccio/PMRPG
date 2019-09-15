package GameX;

public class FieldManager {
    private FieldA fieldA;
    private DirectionDrawableComponent directionDrawableComponent;

    FieldManager(FieldA fieldA, DirectionDrawableComponent directionDrawableComponent){
        this.fieldA = fieldA;
        this.directionDrawableComponent = directionDrawableComponent;
    }


    public void checkEvent() {
    }

    public boolean beforeCheck(){ //移動ますが壁か？
        switch (GameManager.keyboard.keycord){
            case 39:
                if(fieldA.info[directionDrawableComponent.getX()+1][directionDrawableComponent.getY()]==0)       return false;
                break;
            case 37:
                if(fieldA.info[directionDrawableComponent.getX()-1][directionDrawableComponent.getY()]==0)       return false;
                break;
            case 38:
                if(fieldA.info[directionDrawableComponent.getX()][directionDrawableComponent.getY()-1]==0)       return false;
                break;
            case 40:
                if(fieldA.info[directionDrawableComponent.getX()][directionDrawableComponent.getY()+1]==0)       return false;
                break;
        }
        return true;
    }


}
