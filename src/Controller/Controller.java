package Controller;

import Model.*;
import View.View;
import com.sun.javafx.binding.SelectBinding;
import paydaycards.PayDayCards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Controller {
    public static plr p1, p2;
    Board board;
    public int dice1, dice2;
    int months = 0, cur_month = 0, first;
    View view;
    String[][] mailCards = new String[48][6];
    String[][] dealCards = new String[20][8];
    ArrayList<Deal_card> deal_cards = new ArrayList<>();
    ArrayList<Mess_card> mess_cards = new ArrayList<>();
    ArrayList<Mess_card> rej_mess_cards = new ArrayList<>();
    ArrayList<Deal_card> rej_deal_cards = new ArrayList<>();

    public Controller() {
        view = new View();
        board = new Board();
        initialize();
        System.out.println("blabla");
    }

    /**
     * Initializes the game
     */
    public void initialize() {
        p1 = new plr();
        p2 = new plr();

        PayDayCards pdv = new PayDayCards();
        pdv.readFile("src/resources/dealCards.csv", "Deal");
        pdv.readFile("src/resources/mailCards.csv", "Mail");
        mailCards = pdv.mailCards;
        dealCards = pdv.dealCards;
        for (int i = 0; i < 48; i++) {
            mess_cards.add(new Mess_card(mailCards[i][0], mailCards[i][1], mailCards[i][2], mailCards[i][3], Integer.parseInt(mailCards[i][4]), mailCards[i][5]));
        }
        for (int i = 0; i < 20; i++) {
            deal_cards.add(new Deal_card(dealCards[i][0], dealCards[i][1], dealCards[i][2], Integer.parseInt(dealCards[i][3]), Integer.parseInt(dealCards[i][4]), dealCards[i][5], dealCards[i][6], dealCards[i][7]));
        }
        Random randint = new Random();
        first = randint.nextInt(2) + 1;
        if (first == 1) {

        }
        Collections.shuffle(deal_cards);
        Collections.shuffle(mess_cards);

        p1.addMoney(3500);
        p2.addMoney(3500);

        board = new Board();
    }

    public static plr getPlayer(int plr) {
        if (plr == 1) {
            return p1;
        }
        return p2;
    }

    /**
     * Throws and returns the roll of a 6-sided dice
     *
     * @return the dice roll
     */
    public static int dice() {
        Random roll = new Random();
        return roll.nextInt(5) + 1;
    }

    /**
     * Checks if the game has ended
     *
     * @return true if current month is the last and if the 2 players are finished
     */
    public boolean checkFinish() {
        if (this.cur_month == this.months) {
            if (this.p1.isFinished() && this.p2.isFinished()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the winner of the game
     *
     * @return 1 if player 1 wins, 2 if player 2 wins, and 0 if it is a draw
     */
    public int winner() {
        if (this.p1.calculateScore() > this.p2.calculateScore()) {
            return 1;
        } else if (this.p1.calculateScore() < this.p2.calculateScore()) {
            return 2;
        } else {
            return 0;
        }
    }
}

