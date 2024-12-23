package graphique;
import gameplay.*;
import javax.swing.*;
import java.awt.*;
public class Score extends JLabel{
    public Score(int number)
    {
        super();
        this.setText(String.valueOf(number));
        this.setSize(200,10);
        this.setBackground(Color.white);
    }
}