package me.lukasmetlicka.compsci.plainclass.Shapes;

public class Rectangle extends Quadrilateral implements IShape {

	Rectangle(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
		super(x1, y1, x2, y2, x3, y3, x4, y4);
	}

	public int returnWidth(){
		return (int) Math.sqrt((p1.getX() - p2.getX()) * (p1.getX() - p2.getX()) + (p1.getY() - p2.getY()) * (p1.getY() - p2.getY()));
	}
	public int returnLength(){
		return (int) Math.sqrt((p1.getX() - p4.getX()) * (p1.getX() - p4.getX()) + (p1.getY() - p4.getY()) * (p1.getY() - p4.getY()));
	}

	public int getArea(){
		return this.returnLength() * this.returnWidth();
	}

}
