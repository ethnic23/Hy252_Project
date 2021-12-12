package Model;

public class Deal_card extends Card{
    int cost,value;
    String choice1, choice2;

    /**
     * Constructor of a deal card
     *
     * @param type the type of the card in Greek
     * @param typeEn the type of the card in English
     * @param message the message of the card
     * @param cost  how much it will cost to get
     * @param value how much money a player will get if he sells this card
     * @param icon the image that's displayed when a card is shown
     * @param choice1 1st choice
     * @param choice2 2nd choice
     */

    public Deal_card(String type,String typeEn,String message,int cost,int value,String icon,String choice1,String choice2){
        this.type = type;
        this.typeEn = typeEn;
        this.message = message;
        this.cost = cost;
        this.value = value;
        this.icon = icon;
        this.choice1 = choice1;
        this.choice2 = choice2;
    }
}
