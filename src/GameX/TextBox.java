package GameX;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;

public class TextBox extends JLabel {
    TextBox(){
        setBounds(2,360,406,35);
        setOpaque(true);
        setBackground(Color.WHITE);
        setBorder((new BevelBorder(1)));
        setText("壁で先に進めない");
    }
}
