package me.drewhoener.acsl.navigation;

public enum EnumCities {

	A(0D), B(450D), C(590D), D(710D), E(1030D), F(1280D), G(1360D);


	double distFromMiddle;

	EnumCities(double distFrom0) {

		this.distFromMiddle = distFrom0;

	}

	public double getPosition() {

		return this.distFromMiddle;

	}

	public static EnumCities getCityByLetter(String letter) {

		switch (letter.toLowerCase()) {


			case "a":
				return EnumCities.A;
			case "b":
				return EnumCities.B;
			case "c":
				return EnumCities.C;
			case "d":
				return EnumCities.D;
			case "e":
				return EnumCities.E;
			case "f":
				return EnumCities.F;
			case "g":
				return EnumCities.G;
			default:
				return EnumCities.A;


		}


	}


}
