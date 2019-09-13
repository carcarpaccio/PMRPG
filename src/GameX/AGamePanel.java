package GameX;

import javax.swing.*;

public abstract class AGamePanel extends JPanel implements ITask{
    protected IChangeScene scene;
    public AGamePanel(IChangeScene changeScene){
        this.scene = changeScene;
    }
}