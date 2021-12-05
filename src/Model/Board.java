package Model;

public class Board {
    Tile[][] tiles = new Tile[5][7];
    public Board(){
        for(int i=0;i<5;i++){
            for(int j=0;j<7;j++){
                tiles[i][j]= new Tile();
            }
        }
    }
}
