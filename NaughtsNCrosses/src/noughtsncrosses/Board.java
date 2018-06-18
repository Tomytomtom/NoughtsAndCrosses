/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package noughtsncrosses;

/**
 *
 * @author levi4
 */
public class Board {
    
    
    
    Tile[][] Tiles;
    Tile currentTile;
    
    public Board(){
        Init();    
    }
    
    private void Init(){
         Tiles = new Tile[3][3];
         currentTile = new Tile(0,0);
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                Tiles[i][j] = new Tile(i, j);
            }
        }
    }
    
    public void DrawBoard(){
   // will loop thought the arry and draw board based
        for (int row = 0; row < 3; ++row) {
         for (int col = 0; col < 3; ++col) {
            Tiles[row][col].print();  
            if (col < 3 - 1) System.out.print("|");
         }
         System.out.println();
         if (row < 3 - 1) {
            System.out.println("-----------");
         }
      }
   
       
    }
 
    
    //checks if the player has won with this move
    public boolean HasWon(TileContent player, Tile current){                                                                                        
                //victory conditions
                //3 in a row
        return Tiles[current.Row][0].Content == player && Tiles[current.Row][1].Content == player && Tiles[current.Row][2].Content == player ||     
                //3 in a column
               Tiles[0][current.Col].Content == player && Tiles[1][current.Col].Content == player && Tiles[2][current.Col].Content == player ||     
                //3 diagonal
               current.Row == current.Col && Tiles[0][0].Content == player && Tiles[1][1].Content == player && Tiles[2][2].Content == player ||     
                //3 diagonal
               current.Row + current.Col == 2 && Tiles[2][0].Content == player && Tiles[1][1].Content == player && Tiles[0][2].Content == player;   
    }
    
    //checks if the game is a draw (it is a draw if no tiles are empty and nobody has won
    public boolean isDraw(){
       for(Tile[] row : Tiles){
            for(Tile tile : row){
                if (tile.Content == TileContent.Empty) {return false;}
            }
        }
        return true;
    }
}
