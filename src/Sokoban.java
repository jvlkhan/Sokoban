import FrameWork.Actor;
import FrameWork.Game;

public class Sokoban extends Game {

	String level1 = "##########" + 
					"#s b     #" + 
					"#  b     #" + 
					"#  b###x##" + 
					"#   #  ###" + 
					"#x     ###" + 
					"#x   b  x#" + 
					"## b    x#" + 
					"###      #" + 
					"##########" ;

	public Sokoban() {
		board = new Actor[10][10];
		buildLvl();
	}

	@Override
	public void upPressed() {
		// TODO Auto-generated method stub

	}

	@Override
	public void downPressed() {
		// TODO Auto-generated method stub

	}

	@Override
	public void leftPressed() {
		// TODO Auto-generated method stub

	}

	@Override
	public void rightPressed() {
		// TODO Auto-generated method stub

	}

	public void buildLvl() {
		int x = 0;
		int y = 0;
		for (int i = 0; i < level1.length(); i++) {
			y = i / board.length;
			x = i % board.length;
			System.out.println(x + " " + y);
			if (level1.charAt(i) == '#') {
				board[x][y] = new Wall(x, y);
			}
			if (level1.charAt(i) == 's') {
				board[x][y] = new Player(x, y);
			}
			if (level1.charAt(i) == 'b') {
				board[x][y] = new Box(x, y);
			}
			if (level1.charAt(i) == ' ') {
				board[x][y] = new Blank(x, y);
			}
			if (level1.charAt(i) == 'x') {
				board[x][y] = new blankMarked(x, y);
			}
		}
	}
}
