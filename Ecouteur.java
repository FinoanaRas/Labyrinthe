package graphique;
import gameplay.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class Ecouteur implements MouseListener{
    Brique[] brique;
    Brique tmp;
    Fenetre fenetre;

    public void setTmp(Brique taxi)
    {
        this.tmp=taxi;
    }
    Ecouteur(Brique[] b, Fenetre f)
    {
        this.fenetre=f;
        this.brique=b;
    }

    public void mouseClicked(MouseEvent e)
    {
        System.out.println(e.getX());
        System.out.println(e.getY());
        
        
        for(int i=0;i<brique.length;i++)
        {
            if(e.getX()>=brique[i].getLocation().x&&e.getX()<=brique[i].getLocation().x+80&&e.getY()>=brique[i].getLocation().y&&e.getY()<=brique[i].getLocation().y+80)
            {
                System.out.println("oui");
                this.brique[i].setState(1);  
            }else{
                System.out.println("non");
                this.brique[i].setState(0); 
            }
            
        }
        fenetre.game.gameSetupOnClick(fenetre.taxis,fenetre.isa);
        
    }
    public void mouseEntered(MouseEvent e)
    {

    }
    public void mouseExited(MouseEvent e)
    {
        
    }
    public void mousePressed(MouseEvent e)
    {

    }
    public void mouseReleased(MouseEvent e)
    {

    }
}