package jp.co.saison.mob;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FootballStrategy implements Strategy {

    @Override
    public Set<Column> makeColumnSet() {
        // ColumnのSetをつくる
        Set<Column> columnSet = new HashSet<>();
        columnSet.add(new Column("Team", 7, 16, ColumnType.Text));
        columnSet.add(new Column("F", 43, 3, ColumnType.Number));
        columnSet.add(new Column("A", 50, 3, ColumnType.Number));
        return columnSet;
    }

    @Override
    public void handle(List<Record> records) {
        final Record minRecord = records.stream()
                .min(Comparator.comparing(r -> ((BigDecimal) r.items.get("F")).subtract(((BigDecimal) r.items.get("A"))).abs()))
                .orElseThrow(NullPointerException::new);
        final Object minDiffTeam = minRecord.items.get("Team");
        System.out.println(minDiffTeam);
    }
}
