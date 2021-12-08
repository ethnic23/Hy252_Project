package Controller;

import Model.*;
import View.View;
import paydaycards.PayDayCards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Controller {
    Board board;
    View view;
    Player p1,p2;
    int months=0,cur_month=0;
    String[][] mailCards = new String[48][6];
    String[][] dealCards = new String[20][8];
    ArrayList<Deal_card> deal_cards = new ArrayList<>();
    ArrayList<Mess_card> mess_cards = new ArrayList<>();

    public void initialize(){
        p1 = new plr();
        p2 = new plr();
        board = new Board();
        view = new View();
        PayDayCards pdv = new PayDayCards();
        pdv.readFile("resources/dealCards_greeklish.csv", "Deal");
        pdv.readFile("resources/mailCards-greeklish.csv", "Mail");
        for(int i=0;i<48;i++){
            mess_cards.add(new Mess_card(mailCards[i][0],mailCards[i][1],mailCards[i][2],mailCards[i][3],Integer.parseInt(mailCards[i][4]),mailCards[i][5]));
        }
        for(int i=0;i<20;i++){
            deal_cards.add(new Deal_card(dealCards[i][0],dealCards[i][1],dealCards[i][2],Integer.parseInt(dealCards[i][3]),Integer.parseInt(dealCards[i][4]),dealCards[i][5],dealCards[i][6],dealCards[i][7]));
        }

    }

    public int dice(){
        Random roll = new Random();
        return roll.nextInt(5) +1;
    }
    public boolean checkFinish(){
        if(this.cur_month==this.months){
            if(this.p1.isFinished()&&this.p2.isFinished()){
                return true;
            }
        }
        return false;
    }

}
