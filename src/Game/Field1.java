package Game;

import java.awt.*;

public class Field1 extends Field{

    Field1(){
        start_point_x=2;
        start_point_y=2;
        field_name="A";
        field_image=Toolkit.getDefaultToolkit().getImage("C:\\Users\\yarn_\\IdeaProjects\\ProjectMember\\src\\Game\\街.PNG");

        for (int j=0;j<10;j++){ //1＝道、0＝壁
            for (int i=0;i<10;i++){
                if(j==0||i==0||i==9||j==9||i==1||j==1)  field_info[i][j]=0;
                else field_info[i][j]=1;
            }
        }
        field_info[5][6]=0;
        field_info[6][6]=0;
        field_info[7][6]=0;
        field_info[5][7]=0;
        field_info[7][7]=0;
        field_info[6][7]=5;
    }


}
