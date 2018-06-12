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
public class Tile {
    public TileContent Content;
    public int Row, Col;
    
    public Tile(int row, int col){
        Content = TileContent.Empty;
        this.Row = row;
        this.Col = col;
    }
    
    //prints either an X, a O or a space depending on the value of the tile
    public void print(){
        System.out.print(this.Content.value);
    }
}
