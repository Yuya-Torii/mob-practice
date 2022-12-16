package jp.co.saison.mob;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class FootballMain {
	public static void main(String[] args) {
		File file = new File("resource/football.dat");
		Map<String, Integer> map = new HashMap<>();
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
				final String teamName = team.trim();
				final int diff = Math.abs(goalFor - goalAgainst);
				map.put(teamName, diff);
			}
//			Collections.sort(Arrays.asList(map.values().toArray()), Integer.compare());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}


	}
}
