package jp.co.saison.mob;

public class Column {

    private final int startPosition;

    private final int length;

    private final ColumnType type;

    public Column(int startPosition, int length, ColumnType type) {
        this.startPosition = startPosition;
        this.length = length;
        this.type = type;
    }

    public int getStartPosition() {
        return startPosition;
    }

    public int getLength() {
        return length;
    }

    public ColumnType getType() {
        return type;
    }
}
