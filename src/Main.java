import javax.swing.JFrame;

import FrameWork.Game;
import FrameWork.View;

public class Main {
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Sokoban");
		Game game = new Sokoban();
		View view = new View(game);
		frame.add(view);
		frame.setVisible(true);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.repaint();
	}
}
