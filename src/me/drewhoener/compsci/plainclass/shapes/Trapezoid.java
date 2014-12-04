package me.drewhoener.compsci.plainclass.shapes;

public class Trapezoid extends Quadrilateral implements IShape{

	public Trapezoid(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
		super(x1, y1, x2, y2, x3, y3, x4, y4);
	}

	public int getTopLength(){
		return (int)Math.sqrt((p1.getX()-p2.getX())*(p1.getX()-p2.getX())+(p1.getY()-p2.getY())*(p1.getY()-p2.getY()));
	}
	public int getBottomLength(){
		return (int)Math.sqrt((p4.getX()-p3.getX())*(p4.getX()-p3.getX())+(p4.getY()-p3.getY())*(p4.getY()-p3.getY()));
	}

	@Override
	public int getHeight(){
		return Math.max(p1.getX(), p4.getX())-Math.min(p1.getX(), p4.getX());
	}

	@Override
	public int getLength() {
		return (int)Math.sqrt((p2.getX()-p3.getX())*(p2.getX()-p3.getX())+(p2.getY()-p3.getY())*(p2.getY()-p3.getY()));
	}

	@Override
	public int getArea(){
		return ((this.getBottomLength()+this.getTopLength())/2)*this.getHeight();
	}

	@Override
	public int getPerimeter() {
		return 2*this.getLength() + this.getTopLength() + this.getBottomLength();
	}
}
