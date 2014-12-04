package me.lukasmetlicka.compsci.plainclass.move;

public interface Movable {

	public void moveUp(int a);
	public void moveUp();
	public void moveDown(int a);
	public void moveDown();
	public void moveLeft(int a);
	public void moveLeft();
	public void moveRight(int a);
	public void moveRight();
	public void moveCenter(int x, int y);

	public int getX();
	public int getY();

	public void setX(int x);
	public void setY(int y);
	public void setCenter(int x, int y);

	public String toString();

}
