package jp.co.saison.mob;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;

public class FootballMain {
	public static void main(String[] args) {
		final File file = new File("resource/football.dat");
		try {
			final FileReader fileReader = new FileReader(file);
			final BufferedReader bufferedReader = new BufferedReader(fileReader);
			bufferedReader.readLine();

			ArrayList<FootballRecord> records = new ArrayList<>();
			String text;
			while ((text = bufferedReader.readLine()) != null) {
				String name = text.substring(7, 21).replace(" ", "");
				if (name.contains("--")) {
					continue;
				}
				String forGoal = text.substring(43, 45);
				String againstGoal = text.substring(50, 52);

				FootballRecord footballRecord = new FootballRecord(name, forGoal, againstGoal);
				records.add(footballRecord);
			}

			FootballRecord minRecord = records.stream()
					.min(Comparator.comparing(FootballRecord::getGoalDiff))
					.orElseThrow(NullPointerException::new);

			System.out.println(minRecord.toString());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
