package graphique;
import gameplay.*;
import javax.swing.*;
import java.awt.*;
public class Fenetre extends JFrame{
    Plateau board;
    Score[] isa;
    Brique[] taxis;
    Mur[] walls;
    JPanel arrive;
    Jeu game;
    public Fenetre(Plateau plateau,Brique[] b,Mur[] w,JPanel a, int xA,int yA)
    {
        super();

        board=plateau;
        this.add(board);

        
        taxis=b;

        Ecouteur taxiListener=new Ecouteur(taxis,this);
        this.addMouseListener(taxiListener);
        
        JPanel p=new JPanel();
        p.setBackground(Color.darkGray);
        p.setBounds(board.getLongueurX()+50,10,200,300);
        this.add(p);

        isa=new Score[taxis.length];
        JPanel[] score=new JPanel[taxis.length];

        for(int iTaxi=0;iTaxi<taxis.length;iTaxi++)
        {
            this.add(taxis[iTaxi]);
            isa[iTaxi]=new Score(taxis[iTaxi].getPathNumber());
            score[iTaxi]=new JPanel();
            score[iTaxi].setBackground(Color.white);
            score[iTaxi].add(isa[iTaxi]);
            p.add(score[iTaxi]);
        }
        
        walls=w;
        for(int i=0;i<walls.length;i++)
        {
            this.add(walls[i]);
        }
        
        
        arrive=a;
        arrive.setBounds((xA*50)+10,(yA*50)+10,50,50); //x=9 y=2
        this.add(arrive);

        game=new Jeu(taxis,isa,arrive);

        p.add(new Control(this));
        
        this.add(new JPanel());

        this.addKeyListener(new FlecheKeyListener(38,this)); //haut
        this.addKeyListener(new FlecheKeyListener(40,this)); //bas
        this.addKeyListener(new FlecheKeyListener(37,this)); //gauche
        this.addKeyListener(new FlecheKeyListener(39,this)); //droite

                
        
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(board.getLongueurX()+300,board.getLongueurY()+100);
        this.setLocationRelativeTo(null);

        
        
    }
}