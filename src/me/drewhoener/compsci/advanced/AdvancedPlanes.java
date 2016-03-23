package me.drewhoener.compsci.advanced;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class AdvancedPlanes {

	public static final Random RANDOM = new Random();

	public List<Passenger> boardingList = new ArrayList<>();
	public Passenger[] airplaneSeating = new Passenger[100];

	static double timesEmpty;

	public static void main(String[] args) {

		AdvancedPlanes ap = new AdvancedPlanes();

		for (int i = 0; i < 10000; i++) {
			if (ap.runBoarding())
				timesEmpty++;

		}

		System.out.println((timesEmpty / 10000D));

	}

	public boolean runBoarding() {

		boardingList.clear();

		for (int i = 0; i < 100; i++) {

			boardingList.add(new Passenger(i));
			airplaneSeating[i] = null;

		}

		Collections.shuffle(boardingList);
		//System.out.println(boardingList.toString());

		int rand = RANDOM.nextInt(100);
		airplaneSeating[rand] = boardingList.get(0);

		for (int i = 1; i < 99; i++) {

			Passenger p = boardingList.get(i);
			if (airplaneSeating[p.seat] == null) {//empty

				airplaneSeating[p.seat] = p;

			} else {//full

				//contains all the number seats remaining
				Integer[] remainingSeats = this.getSeatsRemaining();
				airplaneSeating[remainingSeats[RANDOM.nextInt(remainingSeats.length)]] = p;

			}

		}

		Integer[] seatsLeft = this.getSeatsRemaining();
		//System.out.println(seatsLeft[0]);
		return seatsLeft[0] == this.boardingList.get(99).seat;

	}

	public Integer[] getSeatsRemaining() {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			if (airplaneSeating[i] == null)
				list.add(i);
		}
		return list.toArray(new Integer[list.size()]);
	}


	class Passenger {

		public int seat;

		public Passenger(int seatNum) {
			this.seat = seatNum;
		}

		public String toString() {
			return Integer.toString(this.seat);
		}

		public boolean equals(Object other) {
			return (other instanceof Passenger) && (this.seat == ((Passenger) other).seat);
		}

	}

}
