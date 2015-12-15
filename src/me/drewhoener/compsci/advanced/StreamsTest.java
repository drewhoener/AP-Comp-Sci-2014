package me.drewhoener.compsci.advanced;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StreamsTest {

	public List<Integer> integers = new ArrayList<>();

	public static void main(String[] args) {

	}

	public StreamsTest() {
		Random random = new Random();

		for (int i = 0; i < 1000; i++) {
			this.integers.add(random.nextInt(1000));
		}
	}

	public void forEachStream() {
		this.integers.stream().forEach(System.out::println);
	}

}
