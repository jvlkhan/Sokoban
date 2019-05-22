package FrameWork;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class View extends JPanel implements KeyListener, Observer {

	int width;
	int height;
	private Game game;

	public View(Game g) {
		game = g;
		g.addObs(this);
		width = 600;
		height = 600;
		setPreferredSize(new Dimension(width, height));
		addKeyListener(this);
		setFocusable(true);
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
		//System.out.println("ritar");
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
		
		ArrayList<Actor> list = game.getMoveable();
		for(int i = 0; i < list.size(); i++) {
			Actor act = list.get(i);
			Image img = act.getImage();
			g.drawImage(img, square * act.getX(), square * act.getY(), square, square, null);
			
		}
	}

	@Override
	public void updater() {
		// TODO Auto-generated method stub
		repaint();
	}
}
