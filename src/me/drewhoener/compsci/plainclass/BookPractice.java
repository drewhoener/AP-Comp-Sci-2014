package me.drewhoener.compsci.plainclass;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class BookPractice {

	public class Book {

		private int price;
		private String name;

		public Book(int price, String name) {
			this.price = price;
			this.name = name;
		}

		public int getPrice() {
			return price;
		}

		public String getName() {
			return name;
		}
	}

	public static void main(String[] args) {

		BookPractice bp = new BookPractice();


	}

	private CopyOnWriteArrayList<Book> bookList = new CopyOnWriteArrayList<>();

	public String getMostExpensive() {
		String mostExpensive = "";
		int price = Integer.MIN_VALUE;
		for (Book b : this.bookList) {
			if (b.getPrice() > price) {
				price = b.getPrice();
				mostExpensive = b.getName();
			}

		}
		return mostExpensive;
	}

	public double getTotal() {
		double max = 0;
		for (Book b : this.bookList) {
			max += b.getPrice();
		}
		return max;
	}

	public void remove(double price) {
		List<Book> tempList = new ArrayList<>(this.bookList);
		for (Book b : tempList) {
			if (b.getPrice() == price) {
				this.bookList.remove(b);
			}
		}
	}

}
