package me.drewhoener.compsci.advanced.sprites;

import java.io.File;

public class MainUnit {

	public static void main(String[] args) {

		MainUnit mu = new MainUnit();
		mu.doThing();

	}

	public void doThing() {

		String url = this.getClass().getClassLoader().getResource("sprites").getPath();
		File f = new File(url);
		System.out.println(f.exists());
		System.out.println(url);
		File[] files = f.listFiles();
		if (files != null) {
			for (File fil : files) {
				System.out.println(fil.getName());
			}
		} else {
			System.out.println("No files");
		}

	}

}
