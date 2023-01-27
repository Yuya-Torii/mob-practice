package jp.co.saison.mob;

import java.util.Set;

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

        Set<Column> columnSet = format.getColumnSet();

        for (Column column : columnSet) {
            int endPosition = column.getStartPosition() + column.getLength();
            final String rawText = text.substring(column.getStartPosition(), endPosition);
			ColumnType columnType = column.getType();
			switch (columnType) {
				case Text:
			}
        }

        return new Record();
    }
}
