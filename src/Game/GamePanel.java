package Game;

import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;
import java.util.Timer;

public class GamePanel extends JPanel {

    final int sguea_length=40;  //マスの大きさ
    final int sguea_outline=10; //端の大きさ

    Field field;
    Hero hero;

    int dx;
    int dy;

    GamePanel(){

        //field情報取得
        this.field=new Field1();

    //操作キャラの情報取得
        this.hero=new Hero(field.start_point_x,field.start_point_y,sguea_length);   //実際はFrameかmainで行うこと！！

        // キーボードの設定を行う
        this.setFocusable(true);
        this.addKeyListener(new MoveController(this));


}

    // 操作キャラを移動する
    void Update(int dx, int dy) {

        this.dx=dx;
        this.dy=dy;
        hero.hero_halfmove(field.field_info[hero.hero_x + dx][hero.hero_y + dy], dx, dy); //操作キャラの移動
        new GameTask(this);

    }




     public void paintComponent(Graphics g) {


        g.clearRect(0, 0, getWidth(), getHeight());
        g.drawImage(field.field_image,  10,10,400,400,this);

        //マス目の制作
        // 以下、灰色で描画
        g.setColor(Color.GRAY);
        // for i = 0 から 4 まで
        for (int i = 0; i <= 10; i++) {
            // (10 + 40 * i, 10) -> (10 + 40 * i, 170) に線を引く
            g.drawLine(sguea_outline + sguea_length * i, sguea_outline, sguea_outline + sguea_length * i, sguea_length * 10 + sguea_outline);
            // (10, 10 + 40 * i) -> (170, 10 + 40 * i) に線を引く
            g.drawLine(sguea_outline, sguea_outline + sguea_length * i, sguea_length * 10 + 10, sguea_outline + sguea_length * i);
        }

        //取り込んだ画像を表示

         g.drawImage(hero.hero_image, hero.hero_image_x,hero.hero_image_y, 30,30,this);


    }

}
