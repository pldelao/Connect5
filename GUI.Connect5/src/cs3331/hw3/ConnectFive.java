package cs3331.hw3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JOptionPane;


/**
 * Frame class for the graphical user interface of connect five.
 * Controller for handling events that affect the model and the view.
 * 
 * @author Edgar Padilla, Perla De la O ,Tarek Haddad

 *
 */
@SuppressWarnings("serial")
public class ConnectFive extends JFrame 
{

	int player = 1;
	int winner = 0;
	int answer;
	/**
	 * Board model
	 */
	private Board board;
	/**
	 * Label containing message to user
	 */
	private JLabel message;
	/**
	 * Panel for the board to be displayed on the GUI
	 * frame.
	 */
	private BoardPanel boardPanel;

	/**
	 * Constructor that initializes and adds all the components of the frame
	 * including anonymous classes for the handlers.
	 */
	public ConnectFive() 
	{
		setTitle("Connect Five");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());


		//adding buttons (top)
		JPanel boardSizePanel = new JPanel(new FlowLayout());
		JButton largeBoard = new JButton("Board Size (15x15)");
		JButton smallBoard = new JButton("Board Size (9x9)");
		for (JButton button: new JButton[] { largeBoard, smallBoard }) 
		{
			button.setFocusPainted(false);
			button.addActionListener(e -> {
				if(e.getSource() == largeBoard) {
					board.setSize(15);
					answer = JOptionPane.showConfirmDialog(this,"Leave this game and start a new 15x15 game?");
					if(answer == 0) {
						message.setText("Welcome to Connect Five");
						player = 1;
						boardPanel.reset();
					}
					repaint();
				}
				if(e.getSource() == smallBoard) {
					board.setSize(9);
					answer = JOptionPane.showConfirmDialog(this,"Leave this game and start a new 9x9 game?");
					if(answer == 0) {
						message.setText("Welcome to Connect Five");
						player = 1;
						boardPanel.reset();
					}
					repaint();
				}
			});
			boardSizePanel.add(button);
		}
		getContentPane().add(boardSizePanel, BorderLayout.NORTH);

		board = new Board(15);
		boardPanel=new BoardPanel(board);
		boardPanel.setPreferredSize(new Dimension(660, 660));
		getContentPane().add(boardPanel, BorderLayout.CENTER); 


		//creating message label (bottom)
		JPanel statusPanel = new JPanel();
		statusPanel.setBackground(Color.DARK_GRAY);
		statusPanel.setPreferredSize(new Dimension(660, 50));
		message = new JLabel("Welcome to Connect Five");
		message.setForeground(Color.WHITE);
		message.setFont(new Font(message.getName(), Font.BOLD, 28));
		statusPanel.add(message);
		getContentPane().add(statusPanel, BorderLayout.SOUTH);


		// Handler for user input when placing a disc on the grid.
		//anonymous class declaration (MouseAdapter is not a functional interface, we cannot use lambda expression)(need to do it the old way)
		boardPanel.addMouseListener(new MouseAdapter()
		{
			public void mousePressed(MouseEvent e) 
			{
				message.setText("X: " + e.getX() + " Y: " + e.getY());
				action(e);
				if (boardPanel.check() == 1) {
					message.setText("Player 1 Wins!");
				}
				if (boardPanel.check() == 2) {
					message.setText("Player 2 Wins!");
				
				}
				repaint();

			}//end mouse pressed
		});
	}//end constructor
	/**
	 * Initializes the frame for the GUI and starts the application.
	 */
	public void action(MouseEvent e) {
		if(boardPanel.check() == 0) {
			boolean number = boardPanel.drawBoard(e.getX(), e.getY(), player);
			if(number) {
				if(player == 1) {
					player = 2;
					message.setText("Player 2 Turn.");
				}
				else {
					player = 1;
					message.setText("Player 1 Turn.");
				}
			}
			else {
				message.setText("Invalid Move. Try Again.");
			}
			
		}
	
	}
	public static void main(String[] args) 
	{
		ConnectFive cf = new ConnectFive();
		cf.setVisible(true);
		cf.pack();
	}
}