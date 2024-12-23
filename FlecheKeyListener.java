package graphique;
import gameplay.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class FlecheKeyListener implements KeyListener{
    int sens;
    Fenetre fenetre;


    FlecheKeyListener(int s,Fenetre f)
    {
        this.sens=s;
        fenetre=f;

    }
    public void keyTyped(KeyEvent e)
    {

    }
    public void keyPressed(KeyEvent e)
    {
       if(e.getKeyCode()==this.sens)
       {
            if(fenetre.game.checkWin(fenetre.arrive)==false)
            {
                switch(this.sens)
                {
                    case 38:
                        fenetre.game.moving(0,-50,fenetre.board,fenetre.walls);
                        break;
                    case 40:
                        fenetre.game.moving(0,50,fenetre.board,fenetre.walls);
                        break;
                    case 37:
                        fenetre.game.moving(-50,0,fenetre.board,fenetre.walls);
                        break;
                    case 39:
                        fenetre.game.moving(50,0,fenetre.board,fenetre.walls);
                        break;
                }
            }
            
       }
       
    }
    public void keyReleased(KeyEvent e)
    {

    }

}