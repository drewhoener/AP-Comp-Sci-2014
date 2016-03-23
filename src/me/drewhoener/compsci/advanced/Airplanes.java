package me.drewhoener.compsci.advanced;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Airplanes {

	private boolean[] isFilled;
	private List<Integer> availableSeats;
	public static int[] orderOfBoarding;

	public static final Random rand = new Random();

	static double numEmptyResults = 0;

	public static void main(String[] args) {

		for (int i = 0; i < 10000; i++) {

			Airplanes ap = new Airplanes();
			if (ap.runBoarding())
				numEmptyResults++;

		}

		System.out.println((numEmptyResults / 10000D));

	}


	public Airplanes() {
		isFilled = new boolean[100];

		orderOfBoarding = new int[100];

		availableSeats = new ArrayList<Integer>();

		for (int i = 0; i < 100; i++) {
			availableSeats.add(i);
			orderOfBoarding[i] = i;
		}

		// shuffle array
		shuffleArray(orderOfBoarding);
		//System.out.println(Arrays.toString(orderOfBoarding));
	}

	public boolean runBoarding() {

		this.processFirstPassenger();

		this.simulate();

		return this.isLastPassengerSeatEmpty();

	}

	public void processFirstPassenger() {

		int seat = availableSeats.get(rand.nextInt(availableSeats.size()));
		//System.out.println("Taking seat " + seat);
		isFilled[seat] = true;
		availableSeats.remove(new Integer(seat));
		//System.out.println("Seats Remaining: " + availableSeats.size());
	}

	// process passenger #2 to #99 and assign them seats
	public void simulate() {

		for (int i = 1; i < 99; i++) {

			int passenger = orderOfBoarding[i];

			if (isFilled[passenger]) {

				int seat = availableSeats.get(rand.nextInt(availableSeats.size()));
				//System.out.println(availableSeats);
				//System.out.println("Seat for Passenger " + passenger + " is taken, using " + seat);
				isFilled[seat] = true;
				availableSeats.remove(new Integer(seat));

			} else {//empty

				isFilled[passenger] = true;
				availableSeats.remove(new Integer(passenger));
				//System.out.println("Seat for Passenger " + passenger + " is empty, using " + passenger);

			}

		}

	}

	// check if last passenger's seat is empty
	public boolean isLastPassengerSeatEmpty() {

		return !isFilled[orderOfBoarding[99]];

	}

	// shuffle array
	public static void shuffleArray(int[] ar) {
		for (int i = ar.length - 1; i > 0; i--) {
			int index = (int) (Math.random() * (i + 1));
			// swap
			int a = ar[index];
			ar[index] = ar[i];
			ar[i] = a;
		}
	}

}
