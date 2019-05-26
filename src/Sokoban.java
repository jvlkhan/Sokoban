import java.util.ArrayList;

import FrameWork.Actor;
import FrameWork.Game;

public class Sokoban extends Game {
	

	String level1 = "##########" + 
					"#        #" + 
					"#  b   b #" + 
					"#s b###x##" + 
					"#   #  ###" + 
					"#x     ###" + 
					"#x   b  x#" + 
					"## b    x#" + 
					"###      #" + 
					"##########";
	
	String level2 = " ######## " + 
					"##x     ##" + 
					"#     x  #" + 
					"#bb## b  #" + 
					"#   #    #" + 
					"#x  b ####" + 
					"#   b x # " + 
					"###   ### " + 
					"  #x  #   " + 
					"  #####   ";
	
	Player sokoPlayer;
	ArrayList<Box> boxList;
	ArrayList<String> levelList;
	int level = 0;
	
	public void characters() {
		boxList = new ArrayList<Box>();
	}

	public void addBoxes(Box b) {
		boxList.add(b);
	}

	public Sokoban() {
		super();
		board = new Actor[10][10];
		characters();
		levelList = new ArrayList<String>();
		levelList.add(level1);
		levelList.add(level2);
		buildLvl();

	}
/*<<<<<<< HEAD
=======*/
	
	private void resetLvl() {
		boxList = new ArrayList<Box>();
	}
/*>>>>>>> branch 'master' of https://github.com/gulheo/sokoban.git*/

	@Override
	public void upPressed() {
		// System.out.println("UP PRESSED");
		// TODO Auto-generated method stub
		int x = sokoPlayer.getX();
		int y = sokoPlayer.getY();
		if (board[x][y - 1].getClass() != Wall.class) {
			Boolean collision = false;
			for (int i = 0; i < boxList.size(); i++) {
				Box box = boxList.get(i);
				int xPos = box.getX();
				int yPos = box.getY();
				if (xPos == x && yPos == y - 1) {
					collision = moveBox(box, 0, -1);
				}

			}
			if (!collision) {
				sokoPlayer.move(0, -1);
				obsList.get(0).updater();
			}
		}
		if(checkWin() == true) {
			System.out.println("Win");
			win = true;
			//buildLvl();
		}
	}

	@Override
	public void downPressed() {
		// TODO Auto-generated method stub
		int x = sokoPlayer.getX();
		int y = sokoPlayer.getY();
		Boolean collision = false;
		if (board[x][y + 1].getClass() != Wall.class) {
			for (int i = 0; i < boxList.size(); i++) {
				Box box = boxList.get(i);
				int xPos = box.getX();
				int yPos = box.getY();
				if (xPos == x && yPos == y + 1) {
					collision = moveBox(box, 0, 1);
				}

			}
			if (!collision) {
				sokoPlayer.move(0, 1);
				obsList.get(0).updater();
			}
		}
		if(checkWin() == true) {
			System.out.println("Win");
			win = true;
			//buildLvl();
		}
	}

	@Override
	public void leftPressed() {
		// TODO Auto-generated method stub
		int x = sokoPlayer.getX();
		int y = sokoPlayer.getY();
		Boolean collision = false;
		if (board[x - 1][y].getClass() != Wall.class) {
			for (int i = 0; i < boxList.size(); i++) {
				Box box = boxList.get(i);
				int xPos = box.getX();
				int yPos = box.getY();
				if (xPos == x - 1 && yPos == y) {
					collision = moveBox(box, -1, 0);
				}
			}
			if (!collision) {
				sokoPlayer.move(-1, 0);
				obsList.get(0).updater();
			}
		}
		if(checkWin() == true) {
			System.out.println("Win");
			win = true;
			//buildLvl();
		}
	}

	@Override
	public void rightPressed() {
		// TODO Auto-generated method stub
		int x = sokoPlayer.getX();
		int y = sokoPlayer.getY();
		Boolean collision = false;
		if (board[x + 1][y].getClass() != Wall.class) {
			for (int i = 0; i < boxList.size(); i++) {
				Box box = boxList.get(i);
				int xPos = box.getX();
				int yPos = box.getY();
				if (xPos == x + 1 && yPos == y) {
					collision = moveBox(box, 1, 0);
				}

			}
			if (!collision) {
				sokoPlayer.move(1, 0);
				obsList.get(0).updater();
			}
		}
		if(checkWin() == true) {
			win = true;
			
			
		}
	}
	
/*<<<<<<< HEAD
=======*/
	public void nextLevel() {
		if(win) {
			level++;
		}
		//resetar banan om man ej fått win o trycker x
		resetLvl();
		buildLvl();
		win = false;
		obsList.get(0).updater();

	}


/*>>>>>>> branch 'master' of https://github.com/gulheo/sokoban.git*/
	public void buildLvl() {
		int x = 0;
		int y = 0;

		String currentlevel = levelList.get(level);

		for (int i = 0; i < currentlevel.length(); i++) {
			y = i / board.length;
			x = i % board.length;
			// System.out.println(x + " " + y);
			if (currentlevel.charAt(i) == '#') {
				board[x][y] = new Wall(x, y);
			}
			if (currentlevel.charAt(i) == 's') {
				sokoPlayer = new Player(x, y);
				board[x][y] = new Blank(x, y);
			}
			if (currentlevel.charAt(i) == 'b') {
				boxList.add(new Box(x, y));
				board[x][y] = new Blank(x, y);
			}
			if (currentlevel.charAt(i) == ' ') {
				board[x][y] = new Blank(x, y);
			}
			if (currentlevel.charAt(i) == 'x') {
				board[x][y] = new blankMarked(x, y);
			}
		}
	}
		
	

	public boolean moveBox(Box b, int x, int y) {
		int xBox = b.getX();
		int yBox = b.getY();
		if (board[xBox + x][yBox + y].getClass() == Wall.class) {
			return true;
		}
		for (int i = 0; i < boxList.size(); i++) {
			Box box = boxList.get(i);
			int xPos = box.getX();
			int yPos = box.getY();
			if (xPos == xBox + x && yPos == yBox + y) {
				return true;
			}
		}
		b.setX(xBox + x);
		b.setY(yBox + y);
		return false;
	}

	public boolean checkWin() {
		for (int i = 0; i < boxList.size(); i++) {
			Box box = boxList.get(i);
			int xPos = box.getX();
			int yPos = box.getY();
			Actor a = board[xPos][yPos];
			if(a.getClass() != blankMarked.class) {
				return false;
			}
		}
		return true; 	
	}
	
	@Override
	public ArrayList<Actor> getMoveable() {
		ArrayList<Actor> list = new ArrayList<Actor>();
		list.addAll(boxList);
		list.add(sokoPlayer);

		return list;
	}
	
}
