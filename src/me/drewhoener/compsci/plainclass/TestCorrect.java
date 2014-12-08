package me.drewhoener.compsci.plainclass;

public class TestCorrect {

	static Eins[] elements = {new Zwei(), new Eins(), new Vier(), new Drei()};

	public static void main(String[] args) {
		for (int i = 0; i < elements.length; i++) {
			System.out.println(elements[i]);
			elements[i].method1();
			System.out.println();
			elements[i].method2();
			System.out.println();
		}
	}


}


class Eins {


	public String toString() {
		return "Eins";
	}

	public void method1() {
		System.out.println("eins 1 ");
	}

	public void method2() {
		System.out.println("eins 2 ");
	}

}

class Zwei extends Eins {

	public void method2() {
		System.out.println("Zwei 2 ");
		method1();
	}

}

class Drei extends Zwei {

	public void method1() {
		System.out.println("Drei 1 ");
	}

	public String toString() {
		return "Drei1";
	}

}

class Vier extends Drei {

	public void method2() {
		super.method2();
		System.out.println("Vier 2 ");
	}

	public String toString() {
		return "Vier " + super.toString();
	}

}
