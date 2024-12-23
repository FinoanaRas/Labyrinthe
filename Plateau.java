package graphique;
import javax.swing.*;
import java.awt.*;
public class Plateau extends JPanel{
    int longueurX;
    int longueurY;

    public int getLongueurX(){
        return this.longueurX;
    }
    public int getLongueurY(){
        return this.longueurY;
    }
    public void setLongueurX(int w)
    {
        this.longueurX=w;
    }
    public void setLongueurY(int h)
    {
        this.longueurY=h;
    }


    public Plateau(int lX,int lY)
    {
        super();
        this.setBackground(Color.gray);
        this.setBounds(10,10,(lX*50)+50,(lY*50)+50);
        this.setLongueurX(lX*50);
        this.setLongueurY(lY*50);
    }

    public void paint(Graphics g)
    {
       
        for(int i=0;i<this.getLongueurX();i=i+50)
        {
            for(int j=0;j<this.getLongueurY();j=j+50)
            {
                g.drawRect(i,j,50,50);
            } 
        }
    }
}