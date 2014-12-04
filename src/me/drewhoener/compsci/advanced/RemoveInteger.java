package me.drewhoener.compsci.advanced;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class RemoveInteger {

	public static void main(String[] args) {

		List<Integer> list = new CopyOnWriteArrayList<>();

		list.add(10);
		list.add(15);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(50);
		list.add(60);
		list.add(70);
		list.add(80);
		list.add(90);
		list.add(100);


		list.stream().filter(i -> i % 2 == 0).forEach(i -> {

			list.remove(list.indexOf(i));

		});

		System.out.println(list);

	}

}
