package me.lukasmetlicka.compsci.plainclass.Shapes;

public class Square extends Rectangle {

	public int getLength(){
		return Math.sqrt((p1.getX()-p2.getX())*(p1.getX()-p2.getX())+(p1.getY()-p2.getY())*(p1.getY()-p2.getY()));
	}

}
