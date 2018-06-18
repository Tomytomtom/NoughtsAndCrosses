/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package noughtsncrosses;

import java.io.*;
import java.util.Scanner;

/**
 *
 * @author levi4
 */
public class Game {

    private TileContent Player = TileContent.Cross;
    private Board board;
    private Scanner Input = new Scanner(System.in);

    public Game() {
        board = new Board();
        GameState state = GameState.Playing;
        do {
            board.DrawBoard();
            MakeMove(Player);
            System.out.println("Chose postion");
            if (board.HasWon(Player, board.currentTile))
            {
               state = Player == TileContent.Cross ? GameState.CrossWin : GameState.NoughtWin;
              
                System.out.println(Player.value + "Has won!!! woo...");
                board.DrawBoard();
            }
            
            
            Player = Player == TileContent.Cross ? TileContent.Nought : TileContent.Cross;
            //thing = (condition?) ? if true : if false
            
            if (board.isDraw())
            {
               state = GameState.Draw;
                System.out.println("ITS A DRAW!!!!!!!!!!!!!!!!!");
                board.DrawBoard();
            }
        } while (state == GameState.Playing);

    }
    public void MakeMove(TileContent Player )
    {
        boolean valid = false;
        do {
        if (Player == TileContent.Cross ) 
        {
             System.out.println("CROSSES TURN (row[1-3] column[1-3]): ");
        }
        else if ( Player == TileContent.Nought)
        {
             System.out.println("NOUGHTS TURN (row[1-3] column[1-3]): ");
        }
        else
        {
            System.out.println("THE FUCK!!!!! ");
        }
         int row = Input.nextInt() - 1;
         int col = Input.nextInt() - 1;
        if( col > -1 && col < 3 && row > -1 && row < 3 &&  board.Tiles[row][col].Content == TileContent.Empty) 
        {
           board.Tiles[row][col].Content = Player;
           board.currentTile.Row = row ;
           board.currentTile.Col = col ;
           valid = true;
        
       }
       else
       {
            System.out.println("This move at (" + (row + 1) + "," + (col + 1)
                  + ") is not valid. Try again...");

        }
       }while(!valid);
        
    }

    public static void main(String[] args) {

        System.out.println("WELCOME TO NOUGHTS AND CROSSES");
        Game CurrentGame = new Game();

    }

}
