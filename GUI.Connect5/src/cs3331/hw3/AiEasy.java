package cs3331.hw3;
import java.util.Random;

public class AiEasy extends AI {
	public void AiTurn(int p)
	{
		Board board= new Board(15);
		boolean valid=false;
		Random rand = new Random();
		int min=0;
		int max=board.getSize();
		while(valid) 
		{
			int x=rand.nextInt((max - min) + 1) + min;
			int y=rand.nextInt((max - min) + 1) + min;
			if(board.addDisc(x, y, p)) 
			{
				valid=true;
			}
		}

	}
}
