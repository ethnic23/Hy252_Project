package Model;

import java.util.ArrayList;

public abstract class Player {
    int money,pos,score;
    boolean Started= false;
    boolean Finished= false;

    public Player(){
        this.money = 3500;
        this.pos = 0;
        this.score = 0;
    }
    public int getMoney(){return this.money;}
    public boolean isStarted(){return this.Started;}
    public void setStarted(boolean started){this.Started = started;}
    public boolean isFinished(){return this.Finished;}
    public void setFinished(boolean finished){this.Finished = finished;}

}
