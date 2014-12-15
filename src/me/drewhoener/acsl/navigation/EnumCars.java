package me.drewhoener.acsl.navigation;

public enum EnumCars {

	C(28D), M(25D), F(22D), V(20D);

	double mpg;

	EnumCars(double mpg) {

		this.mpg = mpg;

	}

	public double getMpg() {
		return this.mpg;
	}

	public static EnumCars getCarByLetter(String letter) {

		switch (letter.toLowerCase()) {


			case "c":
				return EnumCars.C;
			case "m":
				return EnumCars.M;
			case "f":
				return EnumCars.F;
			case "v":
				return EnumCars.V;
			default:
				return EnumCars.C;


		}


	}

}
