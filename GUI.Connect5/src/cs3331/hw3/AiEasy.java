/**

 * Contains the AI implementation for multiplayer when the player selects easy level of difficulty

 * 

 * @author  Perla De la O ,Tarek Haddad

 *

 */
package cs3331.hw3;
import java.util.Random;

public class AiEasy extends AI {
	
	/**

	 * Makes a move on the board in easy mode

	 */
	public void AiTurn()
	{
		Random rand = new Random();
		
		while(true) 
		{
			int x=rand.nextInt(board.getSize());
			int y=rand.nextInt(board.getSize()) ;
			if(board.addDisc(x*(625/board.getSize()), y*(625/board.getSize()), 2)==true) 
			{
				break;
			}
		}

	}
}
