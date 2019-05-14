import java.awt.Image;
import javax.swing.ImageIcon;
	
public class Player extends Actor{
		
		public Player(int x, int y) {
			
			super(x,y);
			boxInit();
		}
		
		private void boxInit() {
			
			ImageIcon Icon = new ImageIcon("images/player.png");
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
