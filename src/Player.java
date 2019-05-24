import java.awt.Image;
import javax.swing.ImageIcon;

import FrameWork.Actor;

public class Player extends Actor {
	public Player(int x, int y) {
		super(x, y);

		initPlayer();
	}

	private void initPlayer() {
		ImageIcon playerIcon = new ImageIcon("images/player.png");
		Image image = playerIcon.getImage();
		setImage(image);
	}

	public void move(int x, int y) {
		int dx = getX() + x;
		int dy = getY() + y;

		setX(dx);
		setY(dy);
	}
}
