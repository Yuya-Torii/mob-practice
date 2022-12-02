package jp.co.saison.mob;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FootballMain {
	public static void main(String[] args) {
		File file = new File("resource/football.dat");
		try (final FileReader fileReader = new FileReader(file);
		     final BufferedReader bufferedReader = new BufferedReader(fileReader)) {
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				String f = line.substring(43, 45);
				String a = line.substring(50, 52);
				String team = line.substring(7, 23);

				System.out.println(f);
				if (!f.matches("\\d+?")) {
					continue;
				}
				// どうする？
				final int goalFor = Integer.parseInt(f);
				final int goalAgainst = Integer.parseInt(a);

			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}


	}
}
