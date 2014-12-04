package me.drewhoener.compsci.plainclass.shapes;

public class Square extends Rectangle implements IShape {

	Square(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
		super(x1, y1, x2, y2, x3, y3, x4, y4);
	}

	public int getLength(){
		return (int)Math.sqrt((p1.getX()-p2.getX())*(p1.getX()-p2.getX())+(p1.getY()-p2.getY())*(p1.getY()-p2.getY()));
	}

	@Override
	public int getPerimeter() {
		return 4*this.getLength();
	}

	@Override
	public int getArea() {
		return this.getLength() * this.getLength();
	}
}
