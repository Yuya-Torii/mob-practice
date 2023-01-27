package jp.co.saison.mob;

import java.util.Set;

public class Record {
    private final Set<Column> columnSet;

    public Record(Set<Column> columnSet) {
        this.columnSet = columnSet;
    }

    public Set<Column> getColumnSet() {
        return columnSet;
    }
}
