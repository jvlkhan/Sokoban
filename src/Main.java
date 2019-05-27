import javax.swing.JFrame;

import FrameWork.Game;
import FrameWork.View;

public class Main {
	
	public static void main(String[] args) {
		// creates the main window for the game
		JFrame frame = new JFrame("Sokoban");
		Game game = new Sokoban();
		View view = new View(game);
		frame.add(view);
		frame.setVisible(true);
		frame.pack();
		// stops the program when the windows closes
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
