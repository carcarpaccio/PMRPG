package GameX;

public class FieldManager {
    private FieldA fieldA;
    private DirectionDrawableComponent directionDrawableComponent;

    FieldManager(FieldA fieldA, DirectionDrawableComponent directionDrawableComponent){
        this.fieldA = fieldA;
        this.directionDrawableComponent = directionDrawableComponent;
    }


    public boolean beforecheck(EDirection eDirection) {//movesurumasunokazu
        int i=0,j=0;
        switch (eDirection) {
            case eRight:
                i++;
                break;
            case eLeft:
                i--;
                break;
            case eUp:
                j--;
                break;
            case eDown:
                j++;
                break;
            case eNone:
                break;
        }
        return fieldA.getInfo(directionDrawableComponent.getX()/40+i,directionDrawableComponent.getY()/40+j)!=0;
    }



}
