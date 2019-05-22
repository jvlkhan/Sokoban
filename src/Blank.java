import java.awt.Image;
import javax.swing.ImageIcon;

import FrameWork.Actor;

public class Blank extends Actor {
	public Blank(int x, int y) {
		// refers to parent's constructor
		super(x, y);
		blankInit();
	}

	private void blankInit() {
		// initiates the blank spot on the game
		ImageIcon Icon = new ImageIcon("images/blank.png");
		Image image = Icon.getImage();
		setImage(image);
	}
}
