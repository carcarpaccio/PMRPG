package GameX;

public class Field {
    //
    static int squea_length=50;
    int info[][];
    Field() {
        for (int j = 0; j < 10; j++) { //1＝道、0＝壁
            for (int i = 0; i < 10; i++) {
                if (j == 0 || i == 0 || i == 9 || j == 9 ) info[i][j] = 0;
                else info[i][j] = 1;
            }
        }
    }

    public int[][] getInfo() {
        return info;
    }
}
