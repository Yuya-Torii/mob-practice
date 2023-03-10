package jp.co.saison.mob;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WeatherStrategy implements Strategy{
    @Override
    public Set<Column> makeColumnSet() {
        // ColumnのSetをつくる
        Set<Column> columnSet = new HashSet<>();
        final Column dy = new Column("Dy", 0, 4, ColumnType.Number);
        columnSet.add(dy);
        final Column mxt = new Column("MxT", 4, 6, ColumnType.Number);
        columnSet.add(mxt);
        final Column mnt = new Column("MnT", 10, 6, ColumnType.Number);
        columnSet.add(mnt);

        return columnSet;
    }

    @Override
    public void handle(List<Record> records) {
        final Record minRecord = records.stream()
                .min(Comparator.comparing(r -> ((BigDecimal) r.items.get("MxT")).subtract(((BigDecimal) r.items.get("MnT")))))
                .orElseThrow(NullPointerException::new);

        final Object minDiffDay = minRecord.items.get("Dy");
        System.out.println(minDiffDay);

    }
}
