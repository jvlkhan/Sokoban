import java.awt.Image;

import javax.swing.ImageIcon;


public class Box extends Actor{
	
	public Box(int x, int y) {
		
		super(x,y);
		boxInit();
	}
	
	private void boxInit() {
		
		ImageIcon Icon = new ImageIcon("images/box.png");
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
