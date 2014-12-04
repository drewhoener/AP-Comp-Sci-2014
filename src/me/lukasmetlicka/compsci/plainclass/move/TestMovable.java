package me.lukasmetlicka.compsci.plainclass.move;

public class TestMovable {

	public static void main(String[] args) {

		Movable m1 = new MovablePoint(5, 5); // upcast

		System.out.println(m1);

		m1.moveDown();

		System.out.println(m1);

		m1.moveRight();

		System.out.println(m1);

		Movable m2 = new MovableCircle(2, 1, 20); // upcast

		System.out.println(m2);

		m2.moveRight();

		System.out.println(m2);

	}

}
