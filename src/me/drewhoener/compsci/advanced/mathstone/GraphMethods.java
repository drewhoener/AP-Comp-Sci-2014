package me.drewhoener.compsci.advanced.mathstone;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;

public class GraphMethods {

	static DecimalFormat numberFormat = new DecimalFormat("#.000000000");

	public static void main(String[] args) {
		//4.60517019
		//0.4054651081081643
		//System.out.println(findNatLog(100));
		//System.out.println(bakhshaliMethod(1000000000));
		/*DigitMethod method = new DigitMethod(11298);
		System.out.println(method.getNextIncrement());
		System.out.println(method.getNextIncrement());
		System.out.println(method.getNextIncrement());
		System.out.println(method.getNextIncrement());
		System.out.println(method.getNextIncrement());
		System.out.println(method.getNextIncrement());
		System.out.println(figureOutDecimal(method.getNextIncrement(), 11298));*/


	}

	public static abstract class IncrementableMethod {

		boolean hasFinished = false;

		abstract double getNextIncrement();

		public void setFinished(boolean hasFinished) {
			this.hasFinished = hasFinished;
		}

		public boolean hasFinished() {
			return hasFinished;
		}
	}

	public static class BabylonianMethod extends IncrementableMethod {

		private double oldX0 = Double.MAX_VALUE;
		private double newX0;
		private double numToRoot;

		public BabylonianMethod(int numToRoot, int newX0) {
			this.numToRoot = numToRoot;
			this.newX0 = newX0;
		}

		@Override
		public double getNextIncrement() {

			if (oldX0 == newX0) {
				this.setFinished(true);
				return this.newX0;
			}

			oldX0 = newX0;

			double firstNum = numToRoot / newX0;
			double secondNum = newX0 + firstNum;

			newX0 = secondNum / 2;

			if (Math.abs(oldX0 - newX0) <= .000000000000000005) {
				setFinished(true);
			}

			return newX0;
		}
	}

	/**
	 * <ol>
	 * <li>It can be easier for manual calculations</li>
	 * <li>Every digit of the root found is known to be correct</li>
	 * <li>If the square root has an expansion that terminates, the algorithm terminates after the last digit is found. Thus, it can be used to check whether a given integer is a square number.</li>
	 * <li>The algorithm works for any base, and naturally, the way it proceeds depends on the base chosen.</li>
	 * <li>Please choose numbers > 3</li>
	 * </ol>
	 */
	public static class DigitMethod extends IncrementableMethod {

		Integer[] groups;
		int memoryCounter = 0;
		int memoryMultiplier = 1;
		int workingRemainder = 0;
		int workingNumber = 0;

		public double numToRoot;


		public DigitMethod(double numToRoot) {

			this.numToRoot = numToRoot;

			String toStr = Double.toString(numToRoot);
			String str = toStr.substring(0, toStr.length() - 2);
			ArrayList<Integer> numbers = new ArrayList<>();
			if (str.length() % 2 != 0) {
				numbers.add(Integer.parseInt(str.substring(0, 1)));
				str = str.substring(1);
			}

			for (Iterator i = Pattern.compile("(?<=\\G.{2})").splitAsStream(str).iterator(); i.hasNext(); ) {
				numbers.add(Integer.parseInt((String) i.next()));
			}
			groups = numbers.toArray(new Integer[numbers.size()]);
		}


		@Override
		double getNextIncrement() {
			if (this.memoryCounter == 0) {
				this.getFirstNumber();
			} else {
				this.getNumber();
			}

			System.out.println("Counter: " + memoryCounter);

			int numWorking = Integer.toString(this.workingNumber).length();
			int numRoot = Double.toString(this.numToRoot).substring(0, Double.toString(this.numToRoot).length() - 2).length();

			if (numWorking >= numRoot / 2 + 1)
				return this.figureOutDecimal(this.workingNumber, this.numToRoot, /*2D * (1D / memoryCounter)*/ 4);
			return this.workingNumber;
		}

		public void getFirstNumber() {

			for (int i = 1; ; i++) {
				if (Math.pow(i, 2) > this.getNextGroup(this.memoryCounter)) {
					this.workingNumber = i - 1;
					break;
				} else if (Math.pow(i, 2) == this.getNextGroup(this.memoryCounter)) {
					this.workingNumber = i;
					break;
				}
			}

			this.workingRemainder = this.getNextGroup(this.memoryCounter) - ((int) Math.pow(this.workingNumber, 2));
			System.out.println("Working: " + this.workingNumber);
			System.out.println("Remainder: " + this.workingRemainder);

			this.memoryMultiplier *= 10;
			this.memoryCounter++;
		}

		private void getNumber() {

			this.workingRemainder *= 100;
			this.workingRemainder += this.getNextGroup(this.memoryCounter);

			int newWorking = this.workingNumber * 2 * this.memoryMultiplier;
			this.workingNumber *= this.memoryMultiplier;

			double multiplier = this.getClosestMultiplier(newWorking, this.workingRemainder);

			System.out.println("Working: " + this.workingNumber);
			System.out.println("Remainder: " + this.workingRemainder);
			System.out.println("Multiplier: " + multiplier);

			this.workingRemainder = this.workingRemainder - (int) ((newWorking + multiplier) * multiplier);
			this.workingNumber += multiplier;

			this.memoryCounter++;
		}

		private int getNextGroup(int index) {
			if (index >= this.groups.length) {
				return 00;
			} else {
				return this.groups[index];
			}
		}

		private double figureOutDecimal(double number, double supposedSquare, double threshold) {

			String numberStr = Double.toString(number);

			System.out.println(Math.pow(Double.parseDouble(numberStr), 2) - supposedSquare);

			if (Math.abs(Math.pow(Double.parseDouble(numberStr), 2) - supposedSquare) <= threshold) {
				return Double.parseDouble(numberStr);
			}

			String compareStr = numberStr;
			if (numberStr.contains(".")) {
				String[] parts = compareStr.split(Pattern.quote("."));
				StringBuilder builder = null;
				if (parts[0].length() > 1) {
					builder = new StringBuilder(parts[0].substring(0, parts[0].length() - 1));
					builder.append(".").append(parts[0].substring(parts[0].length() - 1)).append(parts[1]);
				}
				if (builder != null)
					compareStr = builder.toString();

			} else {
				compareStr = numberStr + ".0";

			}

			if (Math.abs(Math.pow(Double.parseDouble(compareStr), 2) - supposedSquare) < threshold) {
				return Double.parseDouble(compareStr);
			}

			return figureOutDecimal(Double.parseDouble(compareStr), supposedSquare, threshold);
		}

		private double getClosestMultiplier(int startingCloseNum, int toBeLessThan) {

			for (int i = 1; ; i++) {

				double working = (startingCloseNum + i) * i;
				if (working > toBeLessThan) {
					return i - 1;
				} else if (working == toBeLessThan) {
					return i;
				}

			}

		}


	}

	public static double figureOutDecimal(double number, int supposedSquare) {
		String numberStr = Double.toString(number);
		System.out.println(numberStr);

		if (Math.abs(Math.pow(Double.parseDouble(numberStr), 2) - supposedSquare) <= 1) {
			return Double.parseDouble(numberStr);
		}

		String compareStr = numberStr;
		if (numberStr.contains(".")) {
			String[] parts = compareStr.split(Pattern.quote("."));
			StringBuilder builder = null;
			if (parts[0].length() > 1) {
				builder = new StringBuilder(parts[0].substring(0, parts[0].length() - 1));
				builder.append(".").append(parts[0].substring(parts[0].length() - 1)).append(parts[1]);
			}
			if (builder != null)
				compareStr = builder.toString();

		} else {
			compareStr = numberStr + ".0";

		}

		if (Math.abs(Math.pow(Double.parseDouble(compareStr), 2) - supposedSquare) < 1) {
			return Double.parseDouble(compareStr);
		}

		return figureOutDecimal(Double.parseDouble(compareStr), supposedSquare);
	}


	/**
	 * n = the closest perfect square to s
	 */
	public static double bakhshaliMethod(double s) {

		double n;
		double n2;
		double d;
		double p;
		double p2;
		double a;

		for (int i = 1; ; i++) {
			if (Math.pow(i, 2) > s) {
				n = i - 1;
				break;
			} else if (Math.pow(i, 2) == s) {
				n = i;
				break;
			}
		}

		n2 = Math.pow(n, 2);
		d = s - n2;
		p = (d / (2 * n));
		p2 = p * p;
		a = n + p;


		return (a - (p2 / (2 * a)));

	}


}
