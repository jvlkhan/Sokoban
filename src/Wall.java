import java.awt.Image;
import javax.swing.ImageIcon;
import FrameWork.Actor;

public class Wall extends Actor {

	public Wall(int x, int y) {
		super(x, y);
		wallInit();
		// TODO Auto-generated constructor stub
	}

	private void wallInit() {
		ImageIcon Icon = new ImageIcon("images/wall.png");
		Image image = Icon.getImage();
		setImage(image);
	}
}
