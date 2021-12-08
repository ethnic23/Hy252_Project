package Controller;

import Model.Board;
import Model.Player;
import Model.plr;
import View.View;

import java.util.Random;

public class Controller {
    Board board;
    View view;
    Player p1,p2;

    public void initialize(){
        p1 = new plr();
        p2 = new plr();

    }
    public int dice(){
        Random roll = new Random();
        return roll.nextInt(5) +1;
    }
}
