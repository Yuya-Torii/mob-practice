package jp.co.saison.mob;

import java.util.HashSet;
import java.util.Set;

public class WeatherFormat {
    // ヘッダーの行数
    private final int headerCount = 2;
    // レコード
    private final Record record;

    public WeatherFormat() {
        Set<Column> columns = new HashSet<>();
        columns.add(new Column("Dy", 0, 4, ColumnType.Number));
        this.record = new Record(columns);
    }
    // フッター

    // 処理が必要なら持つ
}
