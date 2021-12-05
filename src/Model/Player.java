package Model;

import java.util.ArrayList;

public class Player {
    int money=0;
    int pos= -1;
    boolean Started= false;
    boolean Finished= false;

    public Player(){
        this.money = 3500;
        this.pos = 0;
    }
    public boolean isStarted(){return this.Started;}
    public void setStarted(boolean started){this.Started = started;}
    public boolean isFinished(){return this.Finished;}
    public void setFinished(boolean finished){this.Finished = finished;}

}
