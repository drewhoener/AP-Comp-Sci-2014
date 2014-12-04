package me.lukasmetlicka.compsci.plainclass.move;

public class MovableCircle implements Movable {

	private MovablePoint center;
	private int radius;

	//Constructors
	public MovableCircle(int x, int y, int radius){
		center = new MovablePoint(x,y);
		this.setRadius(radius);
	}
	public MovableCircle(MovablePoint center, int radius){
		this.center = new MovablePoint(center.getX(), center.getY());
	}
	public MovableCircle(MovablePoint center){
		this(center, 0);
	}
	public MovableCircle(int radius){
		center = new MovablePoint(0,0);
		this.setRadius(radius);
	}

	//Getters
	public int getRadius(){
		return radius;
	}
	public MovablePoint getCenter(){
		return center;
	}
	@Override
	public int getX() {
		return center.getX();
	}
	@Override
	public int getY() {
		return center.getY();
	}

	//Setters
	@Override
	public void  setCenter(int x, int y){
		center.setCenter(x, y);
	}
	@Override
	public void setX(int x) {
		center.setX(x);
	}
	@Override
	public void setY(int y) {
		center.setY(y);
	}
	public void setRadius(int radius){
		this.radius = radius;
	}

	//Movement
	@Override
	public void moveUp(int a) {
		center.moveUp(a);
	}
	@Override
	public void moveDown(int a) {
		center.moveDown(a);
	}
	@Override
	public void moveLeft(int a) {
		center.moveLeft(a);
	}
	@Override
	public void moveRight(int a) {
		center.moveRight(a);
	}
	@Override
	public void moveCenter(int x, int y) {
		center.moveCenter(x,y);
	}
	@Override
	public void moveUp() {
		center.moveUp();
	}
	@Override
	public void moveDown() {
		center.moveDown();
	}
	@Override
	public void moveLeft() {
		center.moveLeft();
	}
	@Override
	public void moveRight(){
		center.moveRight();
	}

	public String toString(){
		return center.toString()+"\tRadius: "+radius;
	}

}
