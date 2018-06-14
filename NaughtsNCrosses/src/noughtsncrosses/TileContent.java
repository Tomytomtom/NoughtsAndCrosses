/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package noughtsncrosses;

/**
 *
 * @author levi4
 * 
 * enum to store values for tiles with a printable character
 */
public enum TileContent {
    Nought(" O "), Cross(" X "), Empty("   ");
    
    String value;
    
    TileContent(String value){
        this.value = value;
    }
}
