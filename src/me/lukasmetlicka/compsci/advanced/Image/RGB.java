package me.lukasmetlicka.compsci.advanced.Image;

public class RGB {

	int[][][] color = new int[255][255][255];

	public RGB(int R, int G, int B){
		color[R][G][B] = 1;
	}

}
