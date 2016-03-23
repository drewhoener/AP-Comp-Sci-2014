package me.drewhoener.compsci.advanced;

import java.util.Random;

public enum EnumDistributor {

	//BASIC: 15
	//COMMON: 10
	//AVERAGE: 5
	//RARE: 1

	//EARLY GAME: 1 -> All Players
	//MID GAME: 2 -> first few gone
	//LATE GAME: 3 -> Half Gone

	BLAZE(2, 10),
	CAVE_SPIDER(1, 10),
	CREEPER(2, 10),
	ENDERMAN(3, 5),
	GIANT(3, 1),
	PIG_ZOMBIE(2, 10),
	SHULKER(3, 5),
	SILVERFISH(1, 15),
	SKELETON(1, 10),
	SLIME(1, 15),
	SPIDER(1, 10),
	WITCH(2, 10),
	WOLF_ANGRY(2, 5),
	ZOMBIE(1, 15);


	static Random RANDOM = new Random();

	private int weightMultiplier;
	private int weight;

	EnumDistributor(int weightMultiplier, int weight) {
		this.weightMultiplier = weightMultiplier;
		this.weight = weight;
	}

	public int getWeightMultiplier() {
		return weightMultiplier;
	}

	public int getWeight() {
		return weight;
	}


	//TODO figure out a way to reverse the priority

	/**
	 * @param pA priorityAdjustment -> The assesment by the game of how much we have progressed
	 */
	public int getAdjustedWeight(int waveAmplifier, int pA) {

		int adjustedMultiplier = 1;

		//2, 2 -> 3
		//1, 3 -> 1
		//3, 1 -> 1

		int wA = getWeightMultiplier();
		adjustedMultiplier = this.getTableAdjustment(wA, pA);

		return getWeight() + (adjustedMultiplier * waveAmplifier);

	}

	private int getTableAdjustment(int wA, int pA) {

		switch (pA) {
			case 1:
				return Math.abs(((pA << wA) + (wA * pA)) - (2 * (wA + (2 * ((wA * pA) ^ (pA ^ wA)) * (pA & wA)))));
			case 2:
				return ((wA * pA) - ((wA - 1) * pA)) - ((2 * (pA ^ wA) - 1) * ((pA & wA) / 2));
			case 3:
				return ((wA << pA) / 8);
			default:
				return 1;
		}

	}

	public static EnumDistributor getRandomItem(int wave, int priority) {

		EnumDistributor[] values = EnumDistributor.values();

		int totalSum = 0;

		for (EnumDistributor item : values) {

			totalSum += item.getAdjustedWeight(wave, priority);

		}

		int randomNum = RANDOM.nextInt(totalSum);
		int prevWeight = 0;
		for (EnumDistributor randomItem : values) {

			if (randomNum > prevWeight && (randomNum <= prevWeight + randomItem.getAdjustedWeight(wave, priority))) {
				return randomItem;
			}

			prevWeight += randomItem.getAdjustedWeight(wave, priority);

		}

		return EnumDistributor.ZOMBIE;

	}

}
