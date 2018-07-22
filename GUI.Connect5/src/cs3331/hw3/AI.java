/**

 * Contains the AI implementation for multiplayer and as an abstract class it allows 
 * the user to select easy or medium as the difficulty of the game

 * 

 * @author  Perla De la O ,Tarek Haddad

 *

 */
package cs3331.hw3;

public abstract class AI {
	/** Receives a reference to the object board */
	protected Board board;
	
	/**

	 *  Constructor

	 */
	public void AI(Board board)
	{
		this.board=board;
	}

}
