package me.lukasmetlicka.compsci.plainclass.Cards;

import java.util.Random;

public class DeckOfCards {

	private Card[] deck; //array of Card objects
	private int currentCard;// index of next Card to be dealt(0-51)
	private static final int NUMBER_OF_CARDS = 52;
	private static final Random r = new Random();

	public DeckOfCards() {
		String[] faces = {"Ace", "Deuce", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
		String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
	/*initalize deck and current card */
		currentCard = 0;
		deck = new Card[52];
		int counter = 0;
    	for (int i = 0; i < 4; i++){
			for (int j = 0; j < 13; j++ ){
				deck[counter] = new Card(faces[j],suits[i]);
				counter++;
			}
		}


	}

	public void shuffle() {
		// after shuffling, dealing should start at deck[ 0 ] again
   /* reinitialize currentCard    */

		currentCard = 0;
		// for each Card, pick another random Card (0-51) and swap them
		for (int first = 0; first < deck.length; first++) {
     /* select a random number between 0 and 51 */
			int second = r.nextInt(51) + 50;
			Card placeholder = deck[first];
			deck[first] = deck[second];
			deck[second] = placeholder;


     /* swap current Card with randomly selected Card */


		}
	}

	public Card dealCard() {
  /* if determine whether Cards remain to be dealt
     return current card, else return null */
		if (currentCard < deck.length) {
			currentCard++;
			return deck[currentCard];

		} else
			return null;

	}


}
