package me.lukasmetlicka.compsci.plainclass.Cards;

public class Card {

	private String face;
	private String suit;

	public Card(String cardFace, String cardSuit) {

	}

	//returns format is, for example, "King of Hearts".
	@Override
	public String toString() {
		return "face: "+ face + "\tsuit: "+ suit;
	}

}
