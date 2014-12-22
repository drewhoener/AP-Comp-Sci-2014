package me.lukasmetlicka.compsci.plainclass;

import java.util.ArrayList;
public class Intersect {
	public ArrayList<Integer> Intersect(ArrayList<Integer> a, ArrayList<Integer> b){
		ArrayList<Integer> myReturn = new ArrayList<Integer>();
		for(int j = 0; j < this.largest(a, b).size(); j++){
			if (this.largest(a,b).equals(b)) {
				if (a.contains(b.get(j))) {
					myReturn.add(b.get(j));
				}
			} else {
				if (b.contains(a.get(j))) {
					myReturn.add(a.get(j));
				}
			}
		}
		return myReturn;
	}
	public ArrayList<Integer> largest(ArrayList<Integer> a, ArrayList<Integer> b){
		int x = 0;
		int y = 0;
		for (int i = 0; i < a.size(); i++){
			x++;
		}
		for (int i = 0; i < b.size(); i++){
			y++;
		}
		if (x > y){
			return a;
		} else {
			return b;
		}
	}

	public ArrayList<Integer> reverse(ArrayList<Integer> a){

		int size = a.size();
		for(int i = size - 1; i >= 0; i--){
			a.add(a.get(i));
		}
		int j = 0;
		double halfsize = a.size()/2;
		if (halfsize != (int)halfsize){
			halfsize = (int)halfsize + 1;
		}
		for (int i = 0; i < halfsize; i++){
			a.remove(i);
		}
		return a;
	}

	public static void main(String[] args){
		Intersect main = new Intersect();
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(5);
		a.add(6);
		a.add(7);
		a.add(9);
		ArrayList<Integer> b = new ArrayList<Integer>();
		b.add(5);
		b.add(6);
		b.add(9);
		ArrayList<Integer> c = main.Intersect(a,b);
		System.out.println(c.toString());
		b = main.reverse(b);
		System.out.println(b);
	}
}
