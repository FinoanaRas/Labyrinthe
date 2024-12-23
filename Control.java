package graphique;
import javax.swing.*;
import java.awt.*;
public class Control extends JPanel{
    public Control(Fenetre f)
    {
        super();
        
        this.setLayout(new GridLayout(3,3,5,5));

        Fleche left=new Fleche(-50,0,"gauche");
        left.addMouseListener(new FlecheListener(left,f));
        Fleche right=new Fleche(50,0,"droite");
        right.addMouseListener(new FlecheListener(right,f));
        Fleche down=new Fleche(0,50,"bas");
        down.addMouseListener(new FlecheListener(down,f));
        Fleche up=new Fleche(0,-50,"haut");
        up.addMouseListener(new FlecheListener(up,f));
        Fleche upright=new Fleche(50,-50,"upr");
        upright.addMouseListener(new FlecheListener(upright,f));
        Fleche auto=new Fleche(0,0,"auto");
        auto.addMouseListener(new FlecheListener(auto,f));

        this.add(new JPanel());
        this.add(up);
        this.add(upright);
        this.add(left);
        this.add(auto);
        this.add(right);
        this.add(new JPanel());
        this.add(down);
        
    }

}