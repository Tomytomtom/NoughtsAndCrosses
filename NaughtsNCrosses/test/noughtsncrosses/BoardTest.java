/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package noughtsncrosses;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author levi4
 */
public class BoardTest {
    
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private Board instance;
    
    public BoardTest() {
        this.instance = new Board();
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
    }
    
    @After
    public void tearDown() {
        System.setOut(System.out);
    }
    

    /**
     * Test of HasWon method, of class Board.
     */
    @Test
    public void testHasWon() {
        System.out.println("HasWon");
        TileContent player = TileContent.Empty;
        Tile current = new Tile(1,1);
        
        //player is empty and every tile should be empty so player officially wins
        assertEquals(instance.HasWon(player, current), true);
        
        player = TileContent.Cross;
        //player is no longer empty so should not win
        assertEquals(instance.HasWon(player, current), false);
    }

    /**
     * Test of isDraw method, of class Board.
     */
    @Test
    public void testIsDraw() {
        System.out.println("isDraw");
        
        //should be false because no moves have been made
        boolean expResult = false;
        boolean result = instance.isDraw();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of Print method, of class Tile.
     */
    @Test
    public void testPrint(){
    Tile toTest = new Tile(0, 0);
    
    //print tile content for each possibility
    toTest.print();
    toTest.Content = TileContent.Cross;
    toTest.print();
    toTest.Content = TileContent.Nought;
    toTest.print();
    
    String expResult = "    X  O ";
    String result = outContent.toString();
    
    assertEquals(expResult, result);
    }
}
