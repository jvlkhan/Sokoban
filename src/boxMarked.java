import java.awt.Image;
import javax.swing.ImageIcon;

import FrameWork.Actor;

public class boxMarked extends Actor {

	public boxMarked(int x, int y) {
		super(x, y);
		boxMInit();
	}

	private void boxMInit() {

		ImageIcon Icon = new ImageIcon("images/boxmarked.png");
		Image image = Icon.getImage();
		setImage(image);
	}

	public void Go(int x, int y) {

		int Dx = getX() + x;
		int Dy = getY() + y;

		setX(Dx);
		setY(Dy);
	}

}