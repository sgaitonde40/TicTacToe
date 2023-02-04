import javax.swing.*;
import javax.swing.text.View;
import java.awt.*;

/**
 * A class written to support the TicTacToe Game.
 *
 * Each Square object is one position of the TicTacToe
 * board. It maintains information on the marker, its
 * location on the board, and whether it is part
 * of the winning set.
 *
 * @author: Nandhini Namasivayam
 * @version: Jan 2023
 */

public class Square {

    private String marker;

    private int row;
    private int col;
    public int INITx;
    public int INITy;
    public int width;
    private boolean isWinningSquare;

    /**
     * Constructor to initialize one Square of the
     * TicTacToe board
     * @param row the row the square is in
     * @param col the column the square is in
     */
    public Square(int row, int col) {
        this.row = row;
        this.col = col;

        this.INITx = 300;
        this.INITy = 200;
        this.width = 150;

        this.marker = TicTacToe.BLANK;
        this.isWinningSquare = false;
    }

    /******************** Getters and Setters ********************/
    public String getMarker() {
        return this.marker;
    }

    public void setMarker(String marker) {
        this.marker = marker;
    }

    public void setWinningSquare() {
        this.isWinningSquare = true;
    }

    /**
     * Checks if the square has the BLANK marker
     * @return True if the square is empty, False otherwise
     */
    public boolean isEmpty() {
        return this.marker.equals(TicTacToe.BLANK);
    }

    public void draw(Graphics g, TicTacToeViewer T) {
        // if the square is winning turn in green
        if (isWinningSquare) {
            g.setColor(Color.GREEN);
            g.fillRect(INITx + (width * col),INITy + (width * row),width,width);
        }
        // draw the square
        g.setColor(Color.BLACK);
        g.drawRect(INITx + (width * col),INITy + (width * row),width,width);
        // draw the marker
        if(this.marker.equals("X")) {
            g.drawImage(T.getImages()[0],INITx + (width * col) , INITy + (width * row), 150, 150, T);
        }
        else if(this.marker.equals("O")) {
            g.drawImage(T.getImages()[1],INITx + (width * col),INITy + (width * row), 150, 150, T);
        }
    }

    /**
     * @return the marker for the square
     */
    public String toString() {
        return this.marker;
    }
}
