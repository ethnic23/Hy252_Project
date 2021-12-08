package Model;

import java.util.Random;

public class tl extends Tile{
    int[] num_mc={4,4};
    Random rand= new Random();
    int rand_int;
    public tl(){
        super();
    }
    public void setImage(String type){
        if(type.equals("mess")){
            rand_int=rand.nextInt(num_mc.length);
            while(num_mc[rand_int]==0&&(num_mc[0]+num_mc[1])!=0){
                rand_int =rand.nextInt(num_mc.length);
            }
            if(rand_int == 1){
                this.image = "mc1.png";
            }else{
                this.image = "mc2.png";
            }
        }else if(type.equals("Start")){
            this.image = "start.png";
        }else if(type.equals("deal")){
            this.image = "deal.png";
        }else if(type.equals("sweep")){
            this.image = "sweep.png";
        }else if(type.equals("lot")){
            this.image = "lottery.png";
        }else if(type.equals("radio")){
            this.image = "radio.png";
        }else if(type.equals("buy")){
            this.image = "buyer.png";
        }else if(type.equals("fcn")){
            this.image = "casino.png";
        }else if(type.equals("yard")){
            this.image = "yard.png";
        }else{
            this.image = "pay.png";
        }
    }
}
