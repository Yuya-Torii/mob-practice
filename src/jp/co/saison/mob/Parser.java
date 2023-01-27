package jp.co.saison.mob;

public class Parser {
	private Format format;

	public Parser(Format format) {
		this.format = format;
	}

	/**
	 * 一行読んで適切なところで区切ったデータを返す
	 *
	 * @param text
	 * @return
	 */
	Record parse(String text) {
		return new Record();
	}
}
