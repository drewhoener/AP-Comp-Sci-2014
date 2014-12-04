package me.lukasmetlicka.compsci.plainclass.move;

public class MovablePoint implements Movable {

	private int x;
	private int y;

	//Constructors
	public MovablePoint(int x, int y){
		this.setCenter(x, y);
	}
	public MovablePoint(){
		this(0, 0);
	}

	//Getters
	@Override
	public int getX() {
		return x;
	}
	@Override
	public int getY() {
		return y;
	}

	//Setters
	@Override
	public void setX(int x) {
		this.x = x;
	}
	@Override
	public void setY(int y) {
		this.y = y;
	}
	@Override
	public void setCenter(int x, int y){
		this.setX(x);
		this.setY(y);
	}

	//Movement
	@Override
	public void moveUp(int a) {
		y += a;
	}
	@Override
	public void moveDown(int a) {
		y -= a;
	}
	@Override
	public void moveLeft(int a) {
		x += a;
	}
	@Override
	public void moveRight(int a) {
		x -= a;
	}
	@Override
	public void moveCenter(int x, int y) {
		this.x += x;
		this.y += y;
	}
	@Override
	public void moveUp() {
		y += 1;
	}
	@Override
	public void moveDown() {
		y -= 1;
	}
	@Override
	public void moveLeft() {
		x += 1;
	}
	@Override
	public void moveRight() {
		x -= 1;
	}

	public String toString(){
		return "X: "+x+"\tY: "+y;
	}

}
