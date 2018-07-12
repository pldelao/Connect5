/**

 * Contains the model for the Connect Five board. (No GUI elements should placed here.)

 * 

 * @author Edgar Padilla, Perla De la O ,Tarek Haddad

 *

 */

package cs3331.hw3;

public class Board

{

	/** Defines the size of the board */

	private int size;

	int [][] board;

	/**

	 *  Default constructor

	 */

	public Board(int size)

	{

		this.size = size;

		board = new int [size] [size];

	}

	public int[][] getBoard() {

		return board;

	}

	/**

	 * Adds a disc to the game board.

	 * @param x x coordinate of where the disc needs to be placed.

	 * @param y y coordinate of where the disc needs to be placed.
	 * 
	 * @param p number of player

	 */

	public boolean addDisc(int x, int y, int p)

	{

		if(isValidPosition(x, y)==true)

		{

			board[x/(600/size)][y/(600/size)]=p;
			return true;

		}
		return false;


	}

	/**

	 * Checks if input positions is valid. Checks if valid x-y range. Also checks if position is empty.

	 * 

	 * @param x x input.

	 * @param y y input.

	 * 

	 * @return Validity of placement of the disc.

	 */

	public boolean isValidPosition(int x, int y)

	{

		if(x<600 || x>25 ||y<600 ||y>25) {

			x=x/(600/size);

			y=y/(600/size);

			if(board[x][y]==0)

			{

				return true;

			}

		}

		return false;//change it to something that makes sense

	}

	//private 


	/** Returns the size of this board. */

	public int getSize() 

	{

		return size;

	}

	/** Sets the size of this board. */
	public void setSize(int size) {
		this.size = size;
	}
	/** Retsets board. */
	public void reset() {
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
				board[i][j] = 0;
			}
		}
	}

	/** Checks for winner
	 * @return returns the number of the player that won
	 */

	public int check()

	{

		final int HEIGHT = board.length;

		final int WIDTH = board[0].length;

		final int EMPTY_SLOT = 0;

		for (int r = 0; r < HEIGHT; r++) { // iterate rows, bottom to top

			for (int c = 0; c < WIDTH; c++) { // iterate columns, left to right

				int player = board[r][c];

				if (player == EMPTY_SLOT)

					continue; // don't check empty slots


				if (c + 4 < WIDTH &&

						player == board[r][c+1] && // look right

						player == board[r][c+2] &&

						player == board[r][c+3]&&

						player == board[r][c+4])

					return player;

				if (r + 3 < HEIGHT) {

					if (player == board[r+1][c] && // look up

							player == board[r+2][c] &&

							player == board[r+3][c]&&

							player == board[r+4][c])

						return player;

					if (c + 3 < WIDTH &&

							player == board[r+1][c+1] && // look up & right

							player == board[r+2][c+2] &&

							player == board[r+3][c+3] &&

							player == board[r+4][c+4])

						return player;

					if (c - 3 >= 0 &&

							player == board[r+1][c-1] && // look up & left

							player == board[r+2][c-2] &&

							player == board[r+3][c-3]&&

							player == board[r+4][c-4])

						return player;

				}

			}

		}

		return EMPTY_SLOT; // no winner found

	}


}
