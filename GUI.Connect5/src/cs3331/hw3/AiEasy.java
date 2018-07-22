package cs3331.hw3;
import java.util.Random;

public class AiEasy extends AI {
	public void AiTurn()
	{
		//Board board= new Board(15);
		boolean valid=false;
		Random rand = new Random();
		
		while(valid) 
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
