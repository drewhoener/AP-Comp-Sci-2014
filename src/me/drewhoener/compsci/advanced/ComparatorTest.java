package me.drewhoener.compsci.advanced;

import me.drewhoener.compsci.advanced.bricks.Point;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class ComparatorTest {

	public ArrayList<Point> points = new ArrayList<>();

	public ComparatorTest() {

		Random r = new Random();

		for (int i = 0; i < 100; i++) {

			this.points.add(new Point(r.nextInt(200) - 100, r.nextInt(200) - 100));

		}


	}

	public static void main(String[] args) {

		ComparatorTest ct = new ComparatorTest();

		System.out.println(ct.points);
		System.out.println();

		Collections.sort(ct.points, (o1, o2) -> {

			if (o1.getX() < o2.getX()) return -1;
			if (o2.getX() > o2.getX()) return 1;

			return 0;

		});

		System.out.println(ct.points);

	}

}
