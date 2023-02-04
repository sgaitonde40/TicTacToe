import javax.swing.*;
import java.awt.*;

/**
 * TicTacToe Front End
 * Sohan Gaitonde
 */
public class TicTacToeViewer extends JFrame {
    // TODO: Complete this class
    private Image[] images;
    private final int WINDOW_WIDTH = 1000;
    private final int WINDOW_HEIGHT = 800;
    private TicTacToe T;

    public TicTacToeViewer (TicTacToe T) {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("TicTacToe");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
        this.T = T;
        // creates an array containing the images for x and o
        images = new Image[2];
        images[0] = new ImageIcon("Resources/X.png").getImage();
        images[1] = new ImageIcon("Resources/O.png").getImage();
    }

    public Image[] getImages() {
        return images;
    }


    public void paint(Graphics g) {
        // Turns the color red, sets the font to italic and draws all the numbers
        g.setColor(Color.RED);
        g.setFont(new Font("Serif", Font.ITALIC, 50));
        g.drawString("0", 375, 200 - 10);
        g.drawString("1", 375 + 150, 200 - 10);
        g.drawString("2", 375 + 300, 200 - 10);
        g.drawString("0", 300 - 40 , 275);
        g.drawString("1", 300 - 40, 275 + 150);
        g.drawString("2", 300 - 40, 275 + 300);
        g.setColor(Color.BLACK);
        // grabs the board from the tictactoe object
        Square[][] squares = T.getBoard();
        // prints out each square
        for(int i = 0; i < squares.length; i++) {
            for(int j = 0; j < squares[i].length; j++) {
                squares[i][j].draw(g,this);
            }
        }
        // prints out the winner
        g.setFont(new Font("Serif", Font.BOLD, 75));
        if(!T.getWinner().equals("-")) {
            g.drawString(T.getWinner() + " Wins!", 400, 750);
        }
        if(T.checkTie()) {
            g.drawString("It's a Tie!", 400, 750);
        }
    }
}
