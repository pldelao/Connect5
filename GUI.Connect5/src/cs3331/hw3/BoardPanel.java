package cs3331.hw3;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

/**
 * Class that acts as the Panel to display the model (board) as a grid of 15 by 15.
 * 
 * @author Edgar Padilla, Perla De la O ,Tarek Haddad
 *
 */
@SuppressWarnings("serial")
public class BoardPanel extends JPanel
{

	Color grey = new Color(238, 238, 238);
	/** Board model. */
	private Board board;

	/**
	 * Creates an instance of this panel for the discs board.
	 */
	public BoardPanel(Board board) 
	{
		super(true);
		this.board = board;
		setOpaque(true);
		setBackground(Color.CYAN);
	}
	/**
	 * Draws the board if disks were added
	 * 
	 * @param board Current board to be painted.
	 * @param g Current graphics
	 */
	public void drawDisc(int [][] board, Graphics g) {
		for(int i=0;i< board.length;i++)
		{
			for(int j=0;j<board.length;j++) {
				if(board[i][j]==1)
				{
					g.setColor(Color.red);
					g.fillOval(i, j,  625/board.length,625/board.length); //coordinates for gui board
				}
				if(board[i][j]==1)
				{
					g.setColor(Color.blue);
					g.fillOval(i, j,  625/board.length,625/board.length); //coordinates for GUI board
				}
			}
		}
	}

	/**
	 * Draws the discs board by calling the paint method.
	 * 
	 * @param x x coordinate.
	 * @param y y coordinate.
	 * @param p number of player.
	 */
	public boolean drawBoard(int x, int y, int p)
	{
		//add disc here and then  call repaint
		return board.addDisc(x, y, p);
	}
	/**
	 * Checks for winner
	 */

	public int check() {
		return board.check();
	}
	/**
	 * Resets board
	 */
	public void reset() {
		board.reset();
	}

	/**
	 * Paints the discs board to the panel.
	 */
	public void paint(Graphics g)
	{	
		g.setColor(Color.BLACK);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setStroke(new BasicStroke(2));

		for(int i = 0; i <= board.getSize(); i++)//to change the grid into a 9x9 change the for loop to nine 
		{   
			if(board.getSize() == 9) {
				//draws vertical lines of the grid
				g.drawLine(25 + i * 66, 25, 25 + i * 66, 625);
				//draws horizontal lines of the grid
				g.drawLine(25,25 + i * 66 , 625, 25 + i * 66);
			}
			if(board.getSize() == 15) {
				//draws vertical lines of the grid
				g.drawLine(25 + i * 40, 25, 25 + i * 40, 625);
				//draws horizontal lines of the grid
				g.drawLine(25,25 + i * 40 , 625, 25 + i * 40);
			} 
		}

		int [][]b = board.getBoard();
		//code to fill 15x15
		if(board.getSize() == 15) {
			int o = 600 / board.getSize();
			for(int r=0;r<board.getSize();r++)
			{
				for(int c=0;c<board.getSize();c++) 
				{
					if(b[r][c]==1) {
						g.setColor(Color.RED);
						g.fillOval(((r+1)*(o)-(o/2)+7),((c+1)*(o)-(o/2)+7),o-10,o-10);}//fill the oval in correct coordinates
					if(b[r][c]==2) {
						g.setColor(Color.BLUE);
						g.fillOval(((r+1)*(o)-(o/2)+7),((c+1)*(o)-(o/2)+7),o-10,o-10);}//fill the oval in correct coordinates
					if(b[r][c]==0) {
						g.setColor(grey);
						g.fillOval(((r+1)*(o)-(o/2)+7),((c+1)*(o)-(o/2)+7),o-10,o-10);}//fill the oval in correct coordinates
				}
			}
		}
		//code to fill 9x9
		if(board.getSize() == 9) {
			int o = 600 / board.getSize();
			for(int r=0;r<board.getSize();r++)
			{
				for(int c=0;c<board.getSize();c++) 
				{
					if(b[r][c]==1) {
						g.setColor(Color.RED);
						g.fillOval(((r)*(o)-(o/10)+37),((c)*(o)-(o/10)+37),o-10,o-10);}//fill the oval in correct coordinates
					if(b[r][c]==2) {
						g.setColor(Color.BLUE);
						g.fillOval(((r)*(o)-(o/10)+37),((c)*(o)-(o/10)+37),o-10,o-10);}//fill the oval in correct coordinates
					if(b[r][c]==0) {
						g.setColor(grey);
						g.fillOval(((r+1)*(o)-(o/10)-30),((c+1)*(o)-(o/10)-30),o-10,o-10);}//fill the oval in correct coordinates
				}
			}
		}
	}
}
