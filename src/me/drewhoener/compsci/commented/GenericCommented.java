package me.drewhoener.compsci.commented;

public class GenericCommented {

	public static void main(String[] args) {
		String[] stuff = {"How", "are", "you", "today"};
		System.out.println(joinArray(stuff));


	}

	/**
	 * The method here is defined as public static T String joinArray(T[] arr)
	 * public static is self-explanatory
	 * The T is whatever Object type we want to use in the method, you see I use it as my parameter. Whatever the
	 * variable type, it should be uppercase, and the letter in the diamonds has to match whatever letter you want to be any object.
	 * Without the diamond brackets, this method would result in a compile error, since it doesn't know what a "T" is
	 * I explicitly state within the brackets that T extends Object, which is redundant, since every class implicitly extends
	 * Object. It's just to show that you can limit what goes into the method with the diamond brackets -> See second method
	 */
	public static <T extends Object> String joinArray(T[] arr) {

		String result = "";

		for (int i = 0; i < arr.length; i++) {

			result += arr[i].toString();
			if (i < arr.length - 1)
				result += ", ";

		}

		return result;
	}


	/**
	 * Here we're using the diamond brackets to limit what goes into the method. In this case, it can only be something
	 * that extends the Number class. Primitive types like int can't be used (in versions below java 6) becuase they are primitive
	 * and aren't Objects. However, with something called "Autoboxing", those primitive arrays are automatically turned into an array
	 * of tye "wrapper" class of the array -> int[] turns into Integer[], double[] turns to Double[].
	 * I also happen to know that the Number class has a method called doubleValue() that returns the value as a primitive
	 * so I can use the multiplication function.
	 */
	public static <T extends Number> double multiplyAll(T[] arr) {

		double result = 1;

		for (T obj : arr) {
			result *= obj.doubleValue();
		}

		return result;
	}


}
