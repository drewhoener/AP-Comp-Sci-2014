package me.lukasmetlicka.compsci.plainclass.Shapes;

public class Point {

	private int x;
	private int y;

	//Constructors
	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	public Point(){
		this(0,0);
	}

	//Setters
	public void setX(int x){
		this.x = x;
	}
	public void setY(int y){
		this.y = y;
	}
	public void set(int x, int y){
		this.x = x;
		this.y = y;
	}

	//Getters
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}

	//Overrides
	@Override
	public String toString(){
		return "X: "+ x + "\tY: "+ y;
	}

}
