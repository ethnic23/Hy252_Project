package Model;

public class Deal_card extends Card{
    int cost,value;
    String choice1, choice2;
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
