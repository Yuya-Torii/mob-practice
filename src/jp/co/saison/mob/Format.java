package jp.co.saison.mob;

import java.util.Set;

public class Format {
    private final Set<Column> columnSet;

    public Format(Set<Column> columnSet) {
        this.columnSet = columnSet;
    }

    public Set<Column> getColumnSet() {
        return columnSet;
    }
}
