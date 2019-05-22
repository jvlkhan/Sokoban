import FrameWork.Actor;
import FrameWork.Game;

public class Sokoban extends Game {

	String level1 = "##########" + 
					"#  b     #" + 
					"#  b     #" + 
					"#s b###x##" + 
					"#   #  ###" + 
					"#x     ###" + 
					"#x   b  x#" + 
					"## b    x#" + 
					"###      #" + 
					"##########" ;
	
	Player sokoPlayer;
	

	public Sokoban() {
		super();
		board = new Actor[10][10];
		buildLvl();
	}

	@Override
	public void upPressed() {
		//System.out.println("UP PRESSED");
		// TODO Auto-generated method stub
		int x = sokoPlayer.getX();
		int y = sokoPlayer.getY();
		if(board[x][y-1].getClass() != Wall.class) {
			Boolean collision = false;
			if(board[x][y-1].getClass() == Box.class) {
				 collision = moveBox((Box)board[x][y-1], 0, -1);
			}
			if(!collision) {
				board[x][y] = new Blank(x, y);
				sokoPlayer.move(0, -1);
				x = sokoPlayer.getX();
				y = sokoPlayer.getY();
				board[x][y] = sokoPlayer;
				obsList.get(0).updater();
			}
		}
	}

	@Override
	public void downPressed() {
		// TODO Auto-generated method stub
		int x = sokoPlayer.getX();
		int y = sokoPlayer.getY();
		Boolean collision = false;
		if(board[x][y+1].getClass() != Wall.class) {
			if(board[x][y+1].getClass() == Box.class) {
				collision = moveBox((Box)board[x][y+1], 0, 1);
			}
			if(!collision) {
				board[x][y] = new Blank(x, y);
				sokoPlayer.move(0, 1);
				x = sokoPlayer.getX();
				y = sokoPlayer.getY();
				board[x][y] = sokoPlayer;
				obsList.get(0).updater();
			}
		}
	}

	@Override
	public void leftPressed() {
		// TODO Auto-generated method stub
		int x = sokoPlayer.getX();
		int y = sokoPlayer.getY();
		Boolean collision = false;
		if(board[x-1][y].getClass() != Wall.class) {
			if(board[x-1][y].getClass() == Box.class) {
				collision = moveBox((Box)board[x-1][y], -1, 0);
			}
			if(!collision) {
				board[x][y] = new Blank(x, y);
				sokoPlayer.move(-1, 0);
				x = sokoPlayer.getX();
				y = sokoPlayer.getY();
				board[x][y] = sokoPlayer;
				obsList.get(0).updater();
			}
		}
	}

	@Override
	public void rightPressed() {
		// TODO Auto-generated method stub
		int x = sokoPlayer.getX();
		int y = sokoPlayer.getY();
		Boolean collision = false;
		if(board[x+1][y].getClass() != Wall.class) {
			if(board[x+1][y].getClass() == Box.class) {
				collision = moveBox((Box)board[x+1][y], 1, 0);
			}
			if(!collision) {
				board[x][y] = new Blank(x, y);
				sokoPlayer.move(1, 0);
				x = sokoPlayer.getX();
				y = sokoPlayer.getY();
				board[x][y] = sokoPlayer;
				obsList.get(0).updater();
			}
		}
	}

	public void buildLvl() {
		int x = 0;
		int y = 0;
		for (int i = 0; i < level1.length(); i++) {
			y = i / board.length;
			x = i % board.length;
			//System.out.println(x + " " + y);
			if (level1.charAt(i) == '#') {
				board[x][y] = new Wall(x, y);
			}
			if (level1.charAt(i) == 's') {
				sokoPlayer = new Player(x, y);
				board[x][y] = sokoPlayer;
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
	
	public boolean moveBox(Box b, int x, int y) {
		int xBox = b.getX();
		int yBox = b.getY();
		if(board[xBox+x][yBox+y].getClass() == Wall.class || board[xBox+x][yBox+y].getClass() == Box.class) {
			return true;
		}
		b.setX(xBox+x);
		b.setY(yBox+y);
		board[xBox][yBox] = new Blank(xBox, yBox);
		board[xBox+x][yBox+y] = b;
		return false;
	}
}
