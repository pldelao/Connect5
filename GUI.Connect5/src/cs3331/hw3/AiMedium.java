/**

 * Contains the AI implementation for multiplayer when the player selects medium level of difficulty

 * 

 * @author  Perla De la O ,Tarek Haddad

 *

 */
package cs3331.hw3;
import java.util.Random;

//import java.util.Random;

public class AiMedium extends AI{
	/** Stores when the AI makes the first move */
	int aiMove=0;
	/**

	 * Determines whether it should defend, make a random move or try to win

	 */
	public void AiTurn()
	{
		if(aiMove==0) {
			randomPosition();
			aiMove++;
		}
		if(defence()==false&&aiMove!=0) 
		{
			offence();
		}

	}
	/**

	 * Makes an defensive move to prevent the user from winning
	 * @return returns true if the user has 3 or more discs connected

	 */
	public boolean defence() 
	{
		int max=0;
		int x=0;
		int y=0;
		int [][] b= new int[board.getSize()][board.getSize()];
		for(int i=0;i<board.getSize();i++) {
			for( int j=0;j<board.getSize();j++) {
				b[i][j]=count(i,j,1);//finds the number of connected discs
				if(b[i][j]>max) {
					max=b[i][j];//gets the max number of discs
					x=i;//updates the coordinates
					y=j;
				}
			}
		}
		if(max-1>=3) {//if the user has 3 or more discs connected it places a disc
			board.addDisc(x*(625/board.getSize()), y*(625/board.getSize()), 2);
			return true;
		}
		return false;
	}

	/**

	 * Makes an offensive move to try to win

	 */
	public void offence() 
	{
		int max=0;
		int x=0;
		int y=0;
		int [][] b= new int[board.getSize()][board.getSize()];
		for(int i=0;i<board.getSize();i++) {
			for( int j=0;j<board.getSize();j++) {
				b[i][j]=count(i,j,2);//finds the number of connected discs
				if(b[i][j]>max) {
					max=b[i][j];//gets the max number of discs
					x=i;//updates the coordinates
					y=j;
				}
			}
		}
		//adds disc to board
		board.addDisc(x*(625/board.getSize()), y*(625/board.getSize()), 2);
	}

	/**

	 * Counts how many discs are connected and adds one

	 * @param x x coordinate the place to be checked

	 * @param y y coordinate the place to be checked
	 * 
	 * @param p number of player

	 */
	public int count(int x, int y, int p) {
		int c1=0,c2=0,c3=0,c4=0;

		int[][] b=board.getBoard();
		if(b[x][y]==1||b[x][y]==2) {//if one of 2 the position is not available
			return 0;
		}
		if(b[x][y]==0) 
		{
			b[x][y]=p;//if 0 then the position is available
		}
		if(x+4<board.getSize()&&y+4<board.getSize()) {//d
			for(int k=0;k<5;k++)
			{
				if(b[x+k][y+k]==p) {//counts discs to the right and increases the counter
					c1++;
				}
				else 
				{break;}
			}
		}
		if(x+4<board.getSize()&&y-4>=0) {//d
			for(int k=0;k<5;k++)
			{
				if(b[x+k][y-k]==p)//counts discs up and increases the counter
				{
					c2++;
				}
				else
				{break;}
			}
		}
		if(y+4<board.getSize()) {//d
			for(int k=0;k<5;k++)
			{
				if(b[x][y+k]==p) //counts discs to the positive slope and increases the counter
				{
					c3++;
				}
				else
				{break;}
			}
		}
		if(x+4<board.getSize()){
			for(int k=0;k<5;k++)
			{
				if(b[x+k][y]==p)//counts discs to the negative slope and increases the counter
				{
					c4++;
				}
				else
				{break;}
			}
		}
		//finds the max value of the counters
		int m1, m2;
		if(c1>c2) {
			m1=c1;
		}
		else {
			m1=c2;
		}
		if(c3>c4)
		{
			m2=c3;
		}
		else {
			m2=c4;
		}
		if(m2>m1)
		{m1=m2;
		}

		b[x][y]=0;//restores the board to its original
		return m1;//sends the max number of discs connected
	}
	/**

	 * Makes a random move 

	 */
	public void randomPosition()
	{
		Random rand = new Random();//initializes the random object
		while(true) //loops until it finds a position that isn't taken
		{
			int x=rand.nextInt(board.getSize());//gets the x position
			int y=rand.nextInt(board.getSize()) ;//gets the y position
			if(board.addDisc(x*(625/board.getSize()), y*(625/board.getSize()), 2)==true) 
			{
				//adds disc and leaves the loop
				break;
			}
		}
	}
}
