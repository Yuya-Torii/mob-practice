package jp.co.saison.mob;

public class KataParserFactory {

	public static KataParser createParser(String parserType) {

		if (parserType.equals("weather")) {
			return new WeatherParser();
		} else if (parserType.equals("football")) {
			return new FootballParser();
		} else {
			throw new IllegalArgumentException();
		}
	}

}
