package FrameWork;

import java.util.ArrayList;

public abstract class Game {

	protected Actor[][] board;
	protected ArrayList<Observer> obsList;
	
	public Game() {
		obsList = new ArrayList<Observer>();
	}
	public Actor[][] getBoard() {
		return board;
	}

	public abstract void upPressed();

	public abstract void downPressed();

	public abstract void leftPressed();

	public abstract void rightPressed();
	
	public abstract void nextLevel();
	
	public abstract ArrayList<Actor> getMoveable();
	
	public void addObs(Observer o) {
		obsList.add(o);
	}
	protected boolean win = false;

	public boolean getWin() {
		return win;
		
	}
}
