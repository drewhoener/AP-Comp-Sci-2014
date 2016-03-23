package me.drewhoener.compsci;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AdvancedPlanes {

	private static List<Boolean> testerResults = new ArrayList<>();


	public static final Random RANDOM = new Random();

	private boolean[] isFilled;
	private List<Integer> availableSeats;
	public static int[] orderOfBoarding;

	//Yeah I mix my tester class with the program, so sue me
	public static void main(String[] args) {

		//This could be done a whole lot better but honestly I don't care
		for (int i = 0; i < 10000; i++) {

			AdvancedPlanes ap = new AdvancedPlanes();

			//System.out.println(Arrays.toString(orderOfBoarding));
			//System.out.println(ap.availableSeats.toString());

			ap.processFirstPassenger();
			ap.simulate();
			testerResults.add(ap.isLastPassengerSeatEmpty());

		}

		double numPositive = 0;

		for (boolean bool : testerResults) {
			if (bool)
				numPositive++;
		}

		//System.out.println("Is Empty: " + testerResults.get(0));
		System.out.println("Times Empty: " + numPositive);
		System.out.println("Size: " + testerResults.size());

	}

	public AdvancedPlanes() {
		isFilled = new boolean[100];

		orderOfBoarding = new int[100];

		availableSeats = new ArrayList<Integer>();

		for (int i = 0; i < 100; i++) {
			//Passenger is added to the array with an index that also represents the number they were called
			availableSeats.add(i);
			//Order is recorded so we can find them later, even if the stuff is switched around
			//Since the values will remain the same after a shuffle, we have a viable method of
			//seating the people randomly
			orderOfBoarding[i] = i;
		}

		// shuffle array
		//
		shuffleArray(orderOfBoarding);
	}

	//We don't go about finding this guy's seat like normal, going through the boarding list
	//becuase he's an ass.
	public void processFirstPassenger() {
		// create random seat for first passenger: use int random
		int random = RANDOM.nextInt(isFilled.length);

		//System.out.println("Passenger " + orderOfBoarding[0] + " took the seat of passenger " + random);

		// fill that seat
		isFilled[random] = true;
		// remove seat from availableSeats
		availableSeats.remove(new Integer(random));

		//System.out.println();

	}

	// process passenger #2 to #99 and assign them seats
	public void simulate() {


		//This admittedly had me stumped for a while, couldn't figure out how to get the seat if we're removing filled
		//ones from the arraylist. I remembered we have a log with the array isFilled, so we check that and see
		//If it's true, then we pick a random seat, simple
		//Sure I could be using numbers instead of the length of the array, but I like it better this way
		for (int i = 1; i < isFilled.length - 1; i++) {

			//The boarding list has the order, the contents has the seat number
			int passengerID = orderOfBoarding[i];

			if (isFilled[passengerID]) {
				//Then we find them a random seat, just like with the first passenger
				//Generate it from however many are left
				int randomSeat = availableSeats.get(RANDOM.nextInt(availableSeats.size()));

				//System.out.println(availableSeats.toString());
				//System.out.println("Seat of passenger " + passengerID + " is full, they will now be taking " + randomSeat);
				//System.out.println();

				isFilled[randomSeat] = true;
				availableSeats.remove(new Integer(randomSeat));

			} else {
				//whoop dee doo...
				isFilled[passengerID] = true;
				//This seemed stupid at first, but the remove() method, when used with an object, finds the index
				//and removes that index, instead of treating the number I give it like the number to remove
				//System.out.println(availableSeats.toString());
				availableSeats.remove(new Integer(passengerID));
				//System.out.println("Seat of passenger " + passengerID + " is empty, they will now be taking " + passengerID);
				//System.out.println();


			}

		}

	}

	// check if last passenger's seat is empty
	public boolean isLastPassengerSeatEmpty() {

		//To the best of my understanding, this is the one we actually care about
		//Sure, we'll run everything else, but what we really really want is if the guy has his seat or not
		//The entire purpose of the avaliableSeats list is just to pick a random seat from, it's useless by now
		//All we have to do is return whether his seat is empty or not!

		//System.out.println("Is last passenger empty: " + isFilled[availableSeats.get(0)] + " : Seat : " + availableSeats.get(0));

		return !isFilled[orderOfBoarding.length - 1];

	}

	// shuffle array
	//Already done for us, I believe, I don't feel like messing with it
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
