package me.lukasmetlicka.compsci.plainclass.Shapes;

public class Trapezoid extends Quadrilateral{

	public int getTopLength(){
		return Math.sqrt((p1.getX()-p2.getX())*(p1.getX()-p2.getX())+(p1.getY()-p2.getY())*(p1.getY()-p2.getY()));
	}
	public int getBottomLength(){
		return Math.sqrt((p4.getX()-p3.getX())*(p4.getX()-p3.getX())+(p4.getY()-p3.getY())*(p4.getY()-p3.getY()));
	}

	public int getHeight(){
		return Math.max(p1.getX(), p4.getX())-Math.min(p1.getX(), p4.getX());
	}

	public int getArea(){
		return ((this.getBottomLength()+this.getTopLength())/2)*this.getHeight();
	}

}
