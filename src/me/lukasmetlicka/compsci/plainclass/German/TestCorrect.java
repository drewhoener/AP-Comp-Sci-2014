package me.lukasmetlicka.compsci.plainclass.German;

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
