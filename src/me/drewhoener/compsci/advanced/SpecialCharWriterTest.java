package me.drewhoener.compsci.advanced;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SpecialCharWriterTest {

	public static final char COLOR_CHAR = '§';

	public static void main(String[] args) {

		File testFile = new File(System.getProperty("user.home") + File.separator + "Desktop" + File.separator + "newFile.txt");

		if (!testFile.exists()) {
			try {
				testFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		PrintWriter writer = null;

		try {
			writer = new PrintWriter(new BufferedWriter(new FileWriter(testFile, true)));

			writer.println("Drew Hoener: Hello: There");


		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (writer != null) {
				writer.close();
			}
		}


		BufferedReader reader;

		try {

			reader = new BufferedReader(new FileReader(testFile));
			String s;

			while ((s = reader.readLine()) != null) {
				for (String s1 : s.split(":"))
					System.out.println(s1);
			}


		} catch (IOException e) {


		}


	}


}
