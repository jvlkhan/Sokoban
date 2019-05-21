package FrameWork;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class View extends JPanel implements KeyListener {

	int width;
	int height;
	private Game game;

	public View(Game g) {

		game = g;
		width = 600;
		height = 600;
		setPreferredSize(new Dimension(width, height));

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_RIGHT) {
			game.rightPressed();

		}
		if (key == KeyEvent.VK_LEFT) {
			game.leftPressed();
		}
		if (key == KeyEvent.VK_UP) {
			game.upPressed();
		}
		if (key == KeyEvent.VK_DOWN) {
			game.downPressed();
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void paintComponent(Graphics g) {
		System.out.println("ritar");
		Actor[][] board = game.getBoard();
		int square = width / board.length;

		for (int x = 0; x < board.length; x++) {
			for (int y = 0; y < board[0].length; y++) {
				Actor actor = board[x][y];
				//if (actor == null)
					//System.out.println("ingen actor " + x + " " + y);
				if (actor != null) {
					Image img = actor.getImage();
					g.drawImage(img, square * x, square * y, square, square, null);
				}

			}

		}
	}

}
