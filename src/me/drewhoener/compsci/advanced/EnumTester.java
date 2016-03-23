package me.drewhoener.compsci.advanced;

import java.util.HashMap;
import java.util.Random;

public class EnumTester {

	boolean isExtreme = false;
	int multiplier;
	int waveNum = 1;

	int players = 1;

	int outputNum;

	static Random rand = new Random();

	public static void main(String[] args) {

		HashMap<EnumDistributor, Integer> list = new HashMap<>();

		int modifier = 1;

		/*for(long i = 0; i < 100000; i++){

			if(i > -1 && i < 33333)
				modifier = 1;
			if(i >= 33333 && i < 66666)
				modifier = 2;
			if(i >= 66666)
				modifier = 3;

			EnumDistributor random = EnumDistributor.getRandomItem(1, 1);

			int num = (list.get(random) == null ? 0 : list.get(random));

			list.put(random, (num + 1));

		}*/

		EnumTester enumTester = new EnumTester();

		for (int i = 1; i < 100; i++) {

			if (i > -1 && i < 33)
				modifier = 1;
			if (i >= 33 && i < 66)
				modifier = 2;
			if (i >= 66)
				modifier = 3;

			enumTester.prepareWaveNext(enumTester.players, modifier);
			System.out.println("Round " + i + " : [ " + enumTester.outputNum + " ; " + enumTester.players + " ]");
			enumTester.waveNum++;
			if (new Random().nextInt(100 - i) == 0) ;
			//enumTester.players--;

		}

	}


	//If the number is smaller than the previous number, increase the priority multiplier

	public void prepareWaveNext(int numPlayers, int priorityAmplifier) {

		this.multiplier = (int) (numPlayers * (rand.nextDouble() * .6 + .3));
		if (isExtreme)
			this.multiplier *= ((double) (Math.random() + 1));

		this.outputNum = (this.multiplier == 0 ? (int) (this.waveNum * ((rand.nextDouble() * .6 + .3) * priorityAmplifier)) : this.multiplier * this.waveNum);

	}

}
