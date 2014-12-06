package me.drewhoener.compsci.plainclass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DanielExercise {

	public List<Integer> list1 = Arrays.asList(1, 2, 4, 8, 9, 11, 15, 17, 28, 41, 59);
	public List<Integer> list2 = Arrays.asList(4, 7, 11, 17, 19, 20, 23, 28, 37, 59, 81);

	public static void main(String[] args) {
		DanielExercise de = new DanielExercise();

		de.intersect(de.list1, de.list2);

	}


	//Always use the generic List class instead of restricting to only ArrayLists
	public void intersect(List<Integer> list1, List<Integer> list2) {

		//We declare as a generic List so it can be used with multiple things; not necessarily in this case, just in general good practice
		List<Integer> results = new ArrayList<>();

		//Daniel, not really necessary to loop backwards here, because we're not removing anything
		for (int i = 0; i < list1.size(); i++) {

			for (int j = 0; j < list2.size(); j++) {

				if (list2.get(j) == list1.get(i)) {
					results.add(list2.get(j));
				}

			}

		}

		System.out.println(results);

	}

}
