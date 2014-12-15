package me.drewhoener.acsl.navigation;

public enum EnumRoads {

	I(65D), H(60D), M(55D), S(45D);

	double speedLimit;

	EnumRoads(double speedLimit) {
		this.speedLimit = speedLimit;
	}


	public double getSpeedLimit() {

		return this.speedLimit;

	}

	public static EnumRoads getRoadByLetter(String letter) {


		switch (letter.toLowerCase()) {


			case "i":
				return EnumRoads.I;
			case "h":
				return EnumRoads.H;
			case "m":
				return EnumRoads.M;
			case "s":
				return EnumRoads.S;
			default:
				return EnumRoads.I;


		}


	}

}
