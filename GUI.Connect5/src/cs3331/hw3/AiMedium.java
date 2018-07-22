package cs3331.hw3;
import java.util.Random;

//import java.util.Random;

public class AiMedium extends AI{
	int aiMove=0;
	
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
	public boolean defence() 
	{
		return false;
	}


	public void offence() 
	{
		int max=0;
		int x=0;
		int y=0;
		int [][] b= new int[board.getSize()][board.getSize()];
		for(int i=0;i<board.getSize();i++) {
			for( int j=0;j<board.getSize();j++) {
				b[i][j]=count(i,j);
				if(b[i][j]>max) {
					max=b[i][j];
					x=i;
					y=j;
				}
			}
		}
		board.addDisc(x*(625/board.getSize()), y*(625/board.getSize()), 2);
	}
	public int count(int x, int y) {
		int c1=0,c2=0,c3=0,c4=0;
		
		int[][] b=board.getBoard();
		if(b[x][y]==0) 
		{
			return 0;
		}
		if(b[x][y]==0) 
		{
			b[x][y]=2;
		}
		for(int k=0;y+3<board.getSize();k++)
		{
			if(b[x+k][y+k]==2) {
				c1++;
			}
			else 
			{break;}
		}
		for(int k=0;y-3>=0;k++)
		{
			if(b[x+k][y-k]==2)
			{
				c2++;
			}
			else
			{break;}
		}
		for(int k=0;y+4<board.getSize();k++)
		{
			if(b[x][y+k]==2) 
			{
				c3++;
			}
			else
			{break;}
		}
		for(int k=0;x+3<board.getSize();k++)
		{
			if(b[x+k][y]==0)
			{
			c4++;
			}
			else
			{break;}
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
		
		return m1;
	}
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
