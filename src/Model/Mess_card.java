package Model;

public class Mess_card extends Card{
    String choice;
    int Euro;

    public Mess_card(String type, String typeEn, String message, String choice, int Euro, String icon){
        this.type = type;
        this.typeEn = typeEn;
        this.message = message;
        this.choice  = choice;
        this.Euro = Euro;
        this.icon = icon;
    }
}
