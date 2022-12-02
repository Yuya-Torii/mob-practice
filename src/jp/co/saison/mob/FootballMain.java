package jp.co.saison.mob;

import java.io.*;

public class FootballMain {
	public static void main(String[] args) {
		File file = new File("resource/football.dat");
		try(final FileReader fileReader = new FileReader(file);
			final BufferedReader bufferedReader = new BufferedReader(fileReader)) {

		} catch (IOException e) {
			throw new RuntimeException(e);
		}


	}
}
