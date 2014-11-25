package me.drewhoener.compsci.plainclass;

class One {

	public void method1() {
		System.out.println("One1");
	}

	public String toString() {
		return "One";
	}

}

class Two extends One {

	public void method3() {
		System.out.println("Two3");
	}

	public String toString() {
		return "Two";
	}

}

class Three extends Two {

	public void method2() {
		System.out.println("Three2");
		method1();
	}

	public String toString() {
		return "Three";
	}

}

class Four extends Three {

	public void method1() {
		System.out.println("Four1");
		super.method1();
	}

	public void method3() {
		System.out.println("Four3");
	}

	public String toString() {
		return "Four";
	}

}


public class OneTwoThreeTest {

	static One[] list = {new One(), new Two(), new Three(), new Four()};


	public static void main(String[] args) {

		for (int i = 0; i < list.length; i++) {
			System.out.println(list[i].toString());
			list[i].method1();
		}



	}


}
