package Model;

import java.util.Random;


public class Board{
    tl[][] tiles = new tl[5][7];
    int[] num = {8,5,2,3,2,6,2,2};
    String[] type = {"mess","deal","sweep","lot","radio","buy","fcn","yard"};//num_mess=8,deal_num=5,sweep_num=2,lot_num=3,radio_num=2,buy_num=6,fcn_num=2,yard_num=2
    Random rand_tile = new Random();
    int rand_int,total_com=0;

    /**
     * Sets the type of every tile in the board randomly
     */
    public Board(){
        for(int i=0;i<5;i++){
            for(int j=0;j<7;j++){
                if(i==0&&j==0){
                    tiles[i][j] = new tl();
                    tiles[i][j].type="Start";
                    tiles[i][j].setImage("Start");
                }
                if(i==4&&j==3){
                    tiles[i][j] = new tl();
                    tiles[i][j].type="Payday";
                    tiles[i][j].setImage("Payday");
                    break;
                }else{
                    for(int k=0;k<num.length;k++){
                        if(num[k]==0){
                            total_com++;
                        }
                    }
                    rand_int = rand_tile.nextInt(num.length);
                    while(num[rand_int]==0&&total_com!=num.length){
                        rand_int = rand_tile.nextInt(num.length);
                    }
                    tiles[i][j] = new tl();
                    tiles[i][j].type=type[rand_int];
                    num[rand_int]--;
                }
            }
        }
    }
}
