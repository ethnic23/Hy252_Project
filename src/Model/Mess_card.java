package Model;

public class Mess_card extends Card{
    String choice;
    int Euro;

    /**
     * Constructor of a Message Card
     *
     * @param type the type of the card in Greek
     * @param typeEn the type of the card in English
     * @param message the message of the card
     * @param choice  what the player does
     * @param Euro how much the player loses or gains
     * @param icon the image of the card
     */
    public Mess_card(String type, String typeEn, String message, String choice, int Euro, String icon){
        this.type = type;
        this.typeEn = typeEn;
        this.message = message;
        this.choice  = choice;
        this.Euro = Euro;
        this.icon = icon;
    }
}
