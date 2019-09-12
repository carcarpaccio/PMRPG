package Game;

import java.awt.*;

public class Hero extends Human {
    int hero_x;     //操作キャラの座標
    int hero_y;

    int hero_image_x;    //操作キャラの画像座標
    int hero_image_y;

    int hero_dir;

    Image hero_image;   //操作キャラの画像

    Image hero_imageA;  //操作キャラの画像座標
    Image hero_imageB;


    Hero(int start_point_x,int start_point_y,int squea_length){
        // 操作キャラの初期座標
        this.hero_x = start_point_x;
        this.hero_y = start_point_y;

        //操作キャラの向き初期化
        hero_dir=0;

        //操作きゃらの画像座標
        hero_image_x=15 + hero_x* squea_length;
        hero_image_y=15 + hero_y* squea_length;

        //画像の取り込み
        hero_imageA = Toolkit.getDefaultToolkit().getImage("C:\\Users\\yarn_\\IdeaProjects\\ProjectMember\\src\\Game\\A.jpg");
        hero_imageB = Toolkit.getDefaultToolkit().getImage("C:\\Users\\yarn_\\IdeaProjects\\ProjectMember\\src\\Game\\B.jpg");
        hero_image=hero_imageB;

    }
    void hero_move(int hantei,int dx,int dy){
        if(hantei==1) {   //歩行可能マス(1)なら移動

            // x = x + dx
            hero_x += dx;
            // y = y + dy
            hero_y += dy;
            hero_image_x=hero_image_x+20*dx;
            hero_image_y=hero_image_y+20*dy;
        }
        if(hantei==5){    //画面遷移マス(5)なら移動して画面遷移
            // x = x + dx
            hero_x += dx;
            // y = y + dy
            hero_y += dy;
            hero_image_x=hero_image_x+20*dx;
            hero_image_y=hero_image_y+20*dy;
            GameFrame.gameFrame.ChangeFrame(new GamePanel());
        }
    }
    void hero_halfmove(int hantei,int dx,int dy){
        if(hantei==1) {   //歩行可能マス(1)なら移動
            hero_image_x=hero_image_x+20*dx;
            hero_image_y=hero_image_y+20*dy;
        }
    }
}
