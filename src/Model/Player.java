package Model;

import java.util.ArrayList;

public abstract class Player {
    int money=0,pos,score,bills,loans;
    boolean Started= false;
    boolean Finished= false;
    boolean can_play = false;
    ArrayList<Deal_card> bought_cards = new ArrayList<>();

    /**
     * initializes the player
     */
    public Player(){
        this.money = 3500;
        this.pos = 0;
        this.score = 0;
        this.bills = 0;
        this.loans =0;
    }

    public void addMoney(int money){
        this.money += money;
    }
    public int getMoney(){return this.money;}
    public void addLoan(int loan){this.loans+=loan;}
    public int getLoans(){return this.loans;}
    public void addBills(int bill){this.bills+=bill;}
    public int getBills(){return this.bills;}

    public void allow(){
        this.can_play = true;
    }
    public void forbid(){
        this.can_play = false;
    }
    public boolean getAllowed(){return this.can_play;}

    /**
     * Checks if a player has started from the starting position
     *
     * @return true if pos>0
     */
    public boolean isStarted(){
        if (this.pos > 0) {
            this.Started = true;
        }
        return this.Started;}

    /**
     * Checks if a player has reached the end of the board
     *
     * @return true if pos>=31
     */
    public boolean isFinished(){
        if(this.pos >=31){
            this.Finished = true;
        }
        return this.Finished;}

    /**
     *Updates a player's position
     *
     * @param pos the position of the player
     */
    public void setPos(int pos){
        this.pos = pos;
    }

    /**
     * Returns current position of the player
     *
     * @return current position
     */
    public int getPos(){return this.pos;}

    /**
     * Calculates and returns the score of a player
     *
     * @return the score of the player
     */
    public int calculateScore(){
        this.score = this.money-this.loans-this.bills;
        return this.score;
    }
}
