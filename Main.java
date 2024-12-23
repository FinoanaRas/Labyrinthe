package affichage;
import javax.swing.*;
import java.awt.*;
import graphique.*;
public class Main{
    public static void main(String[] args)
    {
        Plateau board=new Plateau(6,7);
        int nbTaxi=3;
        Brique[] taxis=new Brique[nbTaxi];
        taxis[0]=new Brique(0,0);
        taxis[1]=new Brique(5,2);
        taxis[2]=new Brique(2,4);
        int nbmurs=7;
        Mur[] walls=new Mur[nbmurs];
        walls[0]=new Mur(2,1);
        walls[1]=new Mur(4,2);
        walls[2]=new Mur(5,3);
        walls[3]=new Mur(1,4);
        walls[4]=new Mur(3,4);
        walls[5]=new Mur(3,5);
        walls[6]=new Mur(3,6);
        
        JPanel arrive=new JPanel();
        arrive.setBackground(Color.pink);
        Fenetre frame= new Fenetre(board,taxis,walls,arrive,4,6);
    }
}