package jp.co.saison.mob;

import java.util.HashSet;
import java.util.Set;

public class WeatherFormat {
    public static final int DY_START = 0;
    public static final int DY_END = 4;
    public static final int MXT_START = 4;
    public static final int MXT_END = 9;
    public static final int MNT_START = 9;
    public static final int MNT_END = 14;

    // ヘッダーの行数
    private final int headerCount = 2;
    // レコード
    private final Format format;

    public WeatherFormat() {
        Set<Column> columns = new HashSet<>();
        columns.add(new Column("Dy", 0, 4, ColumnType.Number));
        this.format = new Format(columns);
    }
    // フッター

    // 処理が必要なら持つ
}
