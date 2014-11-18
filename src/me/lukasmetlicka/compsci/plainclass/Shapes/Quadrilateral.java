package me.lukasmetlicka.compsci.plainclass.Shapes;

public class Quadrilateral implements IShape {

	Point p1 = new Point();
	Point p2 = new Point();
	Point p3 = new Point();
	Point p4 = new Point();

	//Constructors
	public Quadrilateral(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4){
		p1.set(x1,y1);
		p2.set(x2,y2);
		p3.set(x3,y3);
		p4.set(x4,y4);
	}

	@Override
	public int getPerimeter() {
		return 2*this.getLength()+ 2*this.getHeight();
	}

	@Override
	public int getArea(){
		 return this.getHeight()* this.getLength();
	}
	@Override
	public int getLength(){
		return Math.sqrt((p1.getX()-p2.getX())*(p1.getX()-p2.getX())+(p1.getY()-p2.getY())*(p1.getY()-p2.getY()));
	}
	public int getHeight(){
		return Math.max(p1.getX(), p4.getX())- Math.min(p1.getX(), p4.getX());
	}

}
