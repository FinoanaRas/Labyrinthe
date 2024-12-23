package graphique;
import javax.swing.*;
import java.awt.*;
public class Mur extends JPanel{
    int x;
    int y;
    public int get_x()
    {
        return this.x;
    }
    public int get_y()
    {
        return this.y;
    }
    public void set_x(int x)
    {
        this.x=x;
    }
    public void set_y(int y)
    {
        this.y=y;
    }

    public Mur(int x, int y)
    {
        super();
        this.setLocation((x*50)+10,(y*50)+10);
        this.set_x(x);
        this.set_y(y);
        this.setBackground(Color.darkGray);
        this.setSize(50,50);
    }
}