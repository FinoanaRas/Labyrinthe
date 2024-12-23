package graphique;
import gameplay.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class FlecheListener implements MouseListener{
    Fleche arrow;
    Fenetre fenetre;
    /*Brique[] brique;
    Plateau plateau;
    Mur[] walls;
    Score[] score;
    JPanel arrive;*/
    
    FlecheListener(Fleche a, Fenetre f)
    {
        this.arrow=a;
        fenetre=f;
    }
    public void mouseClicked(MouseEvent e)
    {

        if(fenetre.game.checkWin(fenetre.arrive)==false)
        {
            if(this.arrow.getMoveX()==0&&this.arrow.getMoveY()==0)
            {
                fenetre.game.automatic(fenetre.board,fenetre.walls,fenetre.arrive);
            }else{
                fenetre.game.moving(this.arrow.getMoveX(),this.arrow.getMoveY(),fenetre.board,fenetre.walls);
            }  
            
        }
        
        
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