import java.awt.Image;
import javax.swing.ImageIcon;

public class Blank extends Actor{
		
		public Blank(int x, int y) {
			
			super(x,y);
			blankInit();
		}
		
		private void blankInit() {
			
			ImageIcon Icon = new ImageIcon("images/blank.png");
	        Image image = Icon.getImage();
	        setImage(image);
		}

}
