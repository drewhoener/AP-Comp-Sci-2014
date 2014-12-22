package me.lukasmetlicka.compsci.plainclass.German;

public class Vier extends Drei {

	public void method2() {
		super.method2();
		System.out.println("Vier 2 ");
	}

	public String toString() {
		return "Vier " + super.toString();
	}

}
