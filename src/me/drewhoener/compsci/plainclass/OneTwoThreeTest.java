package me.drewhoener.compsci.plainclass;

class One {

	public void method1() {
		System.out.println("One1");
	}

}

class Two extends One {

	public void method3() {
		System.out.println("Two3");
	}

}

class Three extends One {

	public void method2() {
		System.out.println("Three2");
		method1();
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

}


public class OneTwoThreeTest {


	static One var1 = new Two();
	static One var2 = new Three();
	static One var3 = new Four();
	static Three var4 = new Four();
	static Object var5 = new Three();
	static Object var6 = new One();

	public static void main(String[] args) {
		var1.method1();
		System.out.println();
		System.out.println();
		var2.method1();
		System.out.println();
		System.out.println();
		var3.method1();
		System.out.println();
		System.out.println();
		var4.method1();
		var4.method2();
		System.out.println();
		System.out.println();
		var4.method2();
		System.out.println();
		System.out.println();

		((Two) var1).method3();
		System.out.println();
		System.out.println();
		((Four) var3).method1();
		System.out.println();
		System.out.println();
		((Four) var4).method3();
		System.out.println();
		System.out.println();
		((One) var5).method1();
		System.out.println();
		System.out.println();
		((Three) var5).method2();
		System.out.println();
		System.out.println();
		((One) var6).method1();


	}


}
