package me.lukasmetlicka.compsci.plainclass.Shapes;
import java.lang.Math;

public class Rectangle extends Quadrilateral {

	public int returnWidth(){
		return Math.sqrt((p1.getX()-p2.getX())*(p1.getX()-p2.getX())+(p1.getY()-p2.getY())*(p1.getY()-p2.getY()));
	}
	public int returnLength(){
		return Math.sqrt((p1.getX()-p4.getX())*(p1.getX()-p4.getX())+(p1.getY()-p4.getY())*(p1.getY()-p4.getY()))
	}

	public int getArea(){
		return this.returnLength() * this.returnWidth();
	}

}
