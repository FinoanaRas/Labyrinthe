package gameplay;
import graphique.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;
public class Jeu
{
    Brique brique;
    Score score;
    int checkAuto;
    public Brique get_brique(){
        return this.brique;
    }
    public void set_brique(Brique b)
    {
        this.brique=b;
    }
    public Score get_score(){
        return this.score;
    }
    public void set_score(Score s)
    {
        this.score=s;
    }

    public int getNearestTaxi(Brique[] taxis, JPanel arrive)
    {
        int imini=0;
        double mini=0;
        double distance;
        for(int i=0;i<taxis.length;i++)
        {
            distance=Math.sqrt(Math.pow(taxis[i].getLocation().x-arrive.getLocation().x,2)+Math.pow(taxis[i].getLocation().y-arrive.getLocation().y,2));
            if(distance<mini)
            {
                imini=i;
            }
            mini=distance;
        }
        return imini;
    }
    public Jeu(Brique[] taxis,Score[] s,JPanel arrive)
    {
        this.checkAuto=0;
        if(this.get_brique()==null)
        {
            this.set_brique(taxis[getNearestTaxi(taxis,arrive)]);
            this.set_score(s[getNearestTaxi(taxis,arrive)]);
        }
        
    }

    public void gameSetupOnClick(Brique[] taxis,Score[] s)
    {
        int i=0;
        while(i<taxis.length)
        {
            if(taxis[i].getState()==1)
            {
                this.set_brique(taxis[i]);
                break;
            }
            i++;
        }
        if(i!=taxis.length)
        {
            this.set_score(s[i]);
        }
        
    }

    public int[][] getNearestPoint(JPanel arrive)
    {
        int[][] positions=new int[4][2];
        positions[0][0]=0; //x
        positions[0][1]=-50;  //y
        positions[1][0]=0;
        positions[1][1]=50;
        positions[2][0]=-50;
        positions[2][1]=0;
        positions[3][0]=50;
        positions[3][1]=0;
        double d1;
        double d2;
        for(int i=0;i<4;i++)
        {
            for(int j=i+1;j<4;j++)
            {
                d1=Math.sqrt(Math.pow(this.get_brique().getLocation().x+positions[i][0]-arrive.getLocation().x,2)+Math.pow(this.get_brique().getLocation().y+positions[i][1]-arrive.getLocation().y,2));
                d2=Math.sqrt(Math.pow(this.get_brique().getLocation().x+positions[j][0]-arrive.getLocation().x,2)+Math.pow(this.get_brique().getLocation().y+positions[j][1]-arrive.getLocation().y,2));
                if(d2<d1)
                {
                    int[] tmp=positions[i];
                    positions[i]=positions[j];
                    positions[j]=tmp;
                }
            }
            
        }
        return positions;
    }

    public void automatic(Plateau plateau,Mur[] walls,JPanel arrive)
    {
        this.checkAuto=1;
        int[][] positions=getNearestPoint(arrive);
        int iPosition=0;
        int initialPositionX=this.get_brique().getLocation().x;
        int initialPositionY=this.get_brique().getLocation().y;
        while(this.get_brique().getLocation().x==initialPositionX&&this.get_brique().getLocation().y==initialPositionY)
        {
            moving(positions[iPosition][0],positions[iPosition][1],plateau,walls);
            iPosition++;
        }
    }

    public void moving(int moveX, int moveY, Plateau plateau,Mur[] walls)
    {
        int initialPositionX=this.get_brique().getLocation().x;
        int initialPositionY=this.get_brique().getLocation().y;
    
        int newPositionX=initialPositionX+moveX;
        int newPositionY=initialPositionY+moveY;
        if(newPositionX>plateau.getLongueurX()||newPositionX<plateau.getLocation().x)
        {
            newPositionX=initialPositionX;
        }
        if(newPositionY>plateau.getLongueurY()||newPositionY<plateau.getLocation().y)
        {
            newPositionY=initialPositionY;
        }
        for(int i=0;i<walls.length;i++)
        {
            if(newPositionX==(walls[i].get_x()*50)+10&&newPositionY==(walls[i].get_y()*50)+10)
            {
                newPositionX=initialPositionX;
                newPositionY=initialPositionY;
            }
        }
       if(newPositionX!=initialPositionX||newPositionY!=initialPositionY)
       {
            if(newPositionX==this.get_brique().getlastX()&&newPositionY==this.get_brique().getlastY())
            {   switch(this.checkAuto)
                {
                    case 0:
                        this.get_brique().setPathNumber(this.get_brique().getPathNumber()-1);
                        score.setText(String.valueOf(this.get_brique().getPathNumber()));
                        
                        break;
                    case 1:
                        newPositionX=initialPositionX;
                        newPositionY=initialPositionY;
                        this.checkAuto=0;
                        break;
                }
                    
            }else{
                this.get_brique().setlastX(initialPositionX);
                this.get_brique().setlastY(initialPositionY);

                this.get_brique().setPathNumber(this.get_brique().getPathNumber()+1);
                score.setText(String.valueOf(this.get_brique().getPathNumber()));
                
            }
       }
       
        
       
       
        this.get_brique().setLocation(newPositionX,newPositionY);
    }

    public boolean checkWin(JPanel arrive)
    {
        if(this.get_brique().getLocation().x==arrive.getLocation().x&&this.get_brique().getLocation().y==arrive.getLocation().y)
        {
            return true;
        }
        return false;
    }
}
