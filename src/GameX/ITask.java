package GameX;

public interface ITask {
    boolean initialize();       // 初期化処理(リソースの読み込みなど)
    void update();// 更新処理
    void destroy();//Panel終了処理　　　　　　　　　　　　　　　　　　　　　　
}
