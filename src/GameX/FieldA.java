package GameX;

public class FieldA extends AField{

    FieldA() {
        info=new int[10][10];
        for (int j = 0; j < 10; j++) { //1＝道、0＝壁
            for (int i = 0; i < 10; i++) {
                if (j == 0 || i == 0 || i == 9 || j == 9 ) info[i][j] = 0;
                else info[i][j] = 1;
            }
        }
        info[6][7]=10;
    }

    public int getInfo(int i,int j) {
        return info[i][j];
    }
}
