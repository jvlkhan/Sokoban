package FrameWork;

public abstract class Game {

	protected Actor[][] board;

	public Actor[][] getBoard() {
		return board;
	}

	public abstract void upPressed();

	public abstract void downPressed();

	public abstract void leftPressed();

	public abstract void rightPressed();

}
