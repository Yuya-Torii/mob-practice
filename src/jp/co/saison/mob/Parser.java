package jp.co.saison.mob;

import java.math.BigDecimal;
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

        final Record record = new Record();
        for (Column column : columnSet) {
            int endPosition = column.getStartPosition() + column.getLength();
            final String rawText = text.substring(column.getStartPosition(), endPosition);
			ColumnType columnType = column.getType();
            // TODO ごみ処理？
			switch (columnType) {
				case Text:
                    record.items.put(column.getName(), rawText.trim());
                    break;
                case Number:
//                    record.items.put(column.getName(), Integer.parseInt(rawText.trim()));
                    record.items.put(column.getName(), new BigDecimal(rawText.trim()));
                    break;
			}
        }
        return record;
    }
}
