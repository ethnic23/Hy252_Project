package Model;

import java.util.ArrayList;

public abstract class Player {
    int money=0,pos,score;
    boolean Started= false;
    boolean Finished= false;

    public Player(){
        this.money = 3500;
        this.pos = 0;
        this.score = 0;
    }
    public void addMoney(int money){
        this.money += money;
    }
    public int getMoney(){return this.money;}

    public boolean isStarted(){
        if (this.pos > 0) {
            this.Started = true;
        }
        return this.Started;}

    public boolean isFinished(){
        if(this.pos >=31){
            this.Finished = true;
        }
        return this.Finished;}

    public void setPos(int pos){
        this.pos = pos;
    }
    public int getPos(){return this.pos;}

}
