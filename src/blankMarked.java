import java.awt.Image;
import javax.swing.ImageIcon;

import FrameWork.Actor;

public class blankMarked extends Actor {
	public blankMarked(int x, int y) {
		super(x, y);
		blankMarkedInit();
	}

	private void blankMarkedInit() {
		ImageIcon Icon = new ImageIcon("images/blankmarked.png");
		Image image = Icon.getImage();
		setImage(image);
	}
}
