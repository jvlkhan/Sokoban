import java.util.ArrayList;

import FrameWork.Actor;
import FrameWork.Game;

public class Sokoban extends Game {
	
	// the levels 
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
	// creates a ArrayList for player and boxes (resizable array)
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
	
	private void resetLvl() {
		boxList = new ArrayList<Box>();
	}

	@Override
	public void upPressed() {
		// System.out.println("UP PRESSED");
		// TODO Auto-generated method stub
		// gets the players position
		int x = sokoPlayer.getX();
		int y = sokoPlayer.getY();
		// if its not a wall on top of the player
		if (board[x][y - 1].getClass() != Wall.class) {
			Boolean collision = false;
			// goes through the box list to see if there is a box on top of them
			for (int i = 0; i < boxList.size(); i++) {
				Box box = boxList.get(i);
				// gets the box position and see if it can be moved
				int xPos = box.getX();
				int yPos = box.getY();
				if (xPos == x && yPos == y - 1) {
					collision = moveBox(box, 0, -1);
				}
			}
			// moves the player upwards
			if (!collision) {
				sokoPlayer.move(0, -1);
				obsList.get(0).updater();
			}
		}
		// checks if we have won the game or not
		if(checkWin() == true) {
			System.out.println("Win");
			win = true;
		}
	}

	@Override
	public void downPressed() {
		// TODO Auto-generated method stub
		// gets the players position
		int x = sokoPlayer.getX();
		int y = sokoPlayer.getY();
		Boolean collision = false;
		// if its not a wall below the player
		if (board[x][y + 1].getClass() != Wall.class) {
			// goes through the box list to see if there is a box below them
			for (int i = 0; i < boxList.size(); i++) {
				// gets the box position and see if it can be moved
				Box box = boxList.get(i);
				int xPos = box.getX();
				int yPos = box.getY();
				if (xPos == x && yPos == y + 1) {
					collision = moveBox(box, 0, 1);
				}
			}
			// moves the player downwards
			if (!collision) {
				sokoPlayer.move(0, 1);
				obsList.get(0).updater();
			}
		}
		// checks if we have won the game or not
		if(checkWin() == true) {
			System.out.println("Win");
			win = true;
		}
	}

	@Override
	public void leftPressed() {
		// TODO Auto-generated method stub
		// gets the players position
		int x = sokoPlayer.getX();
		int y = sokoPlayer.getY();
		Boolean collision = false;
		// if its not a wall on their left
		if (board[x - 1][y].getClass() != Wall.class) {
			// goes through the box list to see if there is a box on their left
			for (int i = 0; i < boxList.size(); i++) {
				// gets the box position and see if it can be moved
				Box box = boxList.get(i);
				int xPos = box.getX();
				int yPos = box.getY();
				if (xPos == x - 1 && yPos == y) {
					collision = moveBox(box, -1, 0);
				}
			}
			// moves the player to the left
			if (!collision) {
				sokoPlayer.move(-1, 0);
				obsList.get(0).updater();
			}
		}
		// checks if we have won the game or not
		if(checkWin() == true) {
			System.out.println("Win");
			win = true;
		}
	}

	@Override
	public void rightPressed() {
		// TODO Auto-generated method stub
		// gets the players position
		int x = sokoPlayer.getX();
		int y = sokoPlayer.getY();
		Boolean collision = false;
		// if its not a wall on their right
		if (board[x + 1][y].getClass() != Wall.class) {
			// goes through the box list to see if there is a box on their right
			for (int i = 0; i < boxList.size(); i++) {
				// gets the box position and see if it can be moved
				Box box = boxList.get(i);
				int xPos = box.getX();
				int yPos = box.getY();
				if (xPos == x + 1 && yPos == y) {
					collision = moveBox(box, 1, 0);
				}
			}
			// moves the player to the right
			if (!collision) {
				sokoPlayer.move(1, 0);
				obsList.get(0).updater();
			}
		}
		// checks if we have won the game or not
		if(checkWin() == true) {
			win = true;
		}
	}
	
	public void nextLevel() {
		// goes to the next level when we have won
		if(win) {
			level++;
		}
		// reset the level when pressed the button x
		resetLvl();
		buildLvl();
		win = false;
		obsList.get(0).updater();
	}

	public void buildLvl() {
		int x = 0;
		int y = 0;

		String currentlevel = levelList.get(level);

		for (int i = 0; i < currentlevel.length(); i++) {
			// sets the x and y so its equally big on the board
			y = i / board.length;
			x = i % board.length;
			// System.out.println(x + " " + y);
			// builds the level by checking the letter is equal to the objects variable 
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
		// don't do anything is there is a wall beside them
		if (board[xBox + x][yBox + y].getClass() == Wall.class) {
			return true;
		}
		// goes through the box list and check if its moveable
		for (int i = 0; i < boxList.size(); i++) {
			Box box = boxList.get(i);
			int xPos = box.getX();
			int yPos = box.getY();
			if (xPos == xBox + x && yPos == yBox + y) {
				return true;
			}
		}
		// change the x and y value for new position
		b.setX(xBox + x);
		b.setY(yBox + y);
		return false;
	}

	public boolean checkWin() {
		// goes through the box list and see if all boxes are on a dot
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
		// put all the moveable objects in a list
		ArrayList<Actor> list = new ArrayList<Actor>();
		list.addAll(boxList);
		list.add(sokoPlayer);

		return list;
	}
}
