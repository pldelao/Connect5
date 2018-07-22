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
				b[i][j]=count(i,j,1);
				if(b[i][j]>max) {
					max=b[i][j];
					x=i;
					y=j;
				}
			}
		}
		if(max-1>=3) {
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
				b[i][j]=count(i,j,2);
				if(b[i][j]>max) {
					max=b[i][j];
					x=i;
					y=j;
				}
			}
		}
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
		if(b[x][y]==1||b[x][y]==2) {
			return 0;
		}
		if(b[x][y]==0) 
		{
			b[x][y]=p;
		}
		if(x+4<board.getSize()&&y+4<board.getSize()) {//d
			for(int k=0;k<5;k++)
			{
				if(b[x+k][y+k]==p) {
					c1++;
				}
				else 
				{break;}
			}
		}
		if(x+4<board.getSize()&&y-4>=0) {//d
			for(int k=0;k<5;k++)
			{
				if(b[x+k][y-k]==p)
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
				if(b[x][y+k]==p) 
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
				if(b[x+k][y]==p)
				{
					c4++;
				}
				else
				{break;}
			}
		}
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

		b[x][y]=0;
		return m1;
	}
	/**

	 * Makes a random move 

	 */
	public void randomPosition()
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
