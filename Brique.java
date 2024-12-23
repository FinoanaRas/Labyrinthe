package graphique;
import javax.swing.*;
import java.awt.*;
public class Brique extends JPanel{
    int pathNumber;
    int state;
    int lastX;
    int lastY;
    public void setPathNumber(int s)
    {
        this.pathNumber=s;
    }
    public int getPathNumber()
    {
        return this.pathNumber;
    }
    public void setState(int s)
    {
        this.state=s;
    }
    public int getState()
    {
        return this.state;
    }
    public void setlastX(int s)
    {
        this.lastX=s;
    }
    public int getlastX()
    {
        return this.lastX;
    }
    public void setlastY(int s)
    {
        this.lastY=s;
    }
    public int getlastY()
    {
        return this.lastY;
    }
    public Brique(int x, int y)
    {
        super();
        this.setBackground(Color.lightGray);
        this.setSize(50,50);
        this.setLocation((x*50)+10,(y*50)+10);
        this.setPathNumber(0);
        this.setState(0);
        this.setlastX(this.getLocation().x);
        this.setlastY(this.getLocation().y);
    }

}