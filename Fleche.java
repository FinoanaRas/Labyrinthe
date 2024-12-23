package graphique;
import javax.swing.*;
import java.awt.*;
public class Fleche extends JPanel{
    int xmove;
    int ymove;

    public void setMove(int x, int y)
    {
        this.xmove=x;
        this.ymove=y;
    }
    public int getMoveX()
    {
        return this.xmove;
    }
    public int getMoveY()
    {
        return this.ymove;
    }
    public Fleche(String name)
    {
        super();
        JLabel direction= new JLabel();
        direction.setText(name);
        this.add(direction);
        this.setBackground(Color.blue);
    }
    public Fleche(int x,int y, String name )
    {
        super();
        this.setMove(x,y);
        JLabel direction= new JLabel();
        direction.setText(name);
        this.add(direction);
        this.setBackground(Color.blue);
    }

}