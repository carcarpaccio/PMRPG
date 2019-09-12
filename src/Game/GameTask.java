package Game;

import java.util.Timer;
import java.util.TimerTask;

class GameTask extends TimerTask {
    Timer timer;
   GamePanel gamePanel;
    GameTask(GamePanel gamePanel){
        this.gamePanel=gamePanel;
        timer=new Timer();
        timer.schedule(this,500);
    }
    @Override
    public void run(){
        gamePanel.hero.hero_move(gamePanel.field.field_info[gamePanel.hero.hero_x + gamePanel.dx][gamePanel.hero.hero_y + gamePanel.dy], gamePanel.dx, gamePanel.dy); //操作キャラの移動
        timer.cancel();
    }
}

