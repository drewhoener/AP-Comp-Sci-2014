package me.lukasmetlicka.compsci.plainclass.Shapes;

import me.drewhoener.compsci.plainclass.shapes.IShape;
import me.drewhoener.compsci.plainclass.shapes.Point;

public class Triangle implements IShape {

	Point p1,p2,p3;

	public Triangle(int x1, int y1, int x2, int y2, int x3, int y3){
		p1 = new Point(x1,y1);
		p2 = new Point(x2,y2);
		p3 = new Point(x3,y3);
	}

	@Override
	public int getArea() {
		return (int)0.5*this.getLength(p2,p3)*this.getHeight();
	}

	@Override
	public int getPerimeter() {
		return this.getLength(p1,p2)+this.getLength(p2,p3)+this.getLength(p3,p1);
	}

	public int getLength(Point a, Point b) {
		return (int)Math.sqrt((a.getX()-b.getX())*(a.getX()-b.getX())+(a.getY()-b.getY())*(a.getY()-b.getY()));
	}
	public int getHeight(){
		return Math.max(p1.getX(), p2.getX())-Math.min(p1.getX(), p2.getX());
	}

	@Override
	public int getLength() {
		return 0;
	}
}
