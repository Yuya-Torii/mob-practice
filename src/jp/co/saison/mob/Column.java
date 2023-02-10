package jp.co.saison.mob;

public class Column {

    private final String name;

    private final int startPosition;

    private final int length;

    private final ColumnType type;

    public Column(String name, int startPosition, int length, ColumnType type) {
        this.name = name;
        this.startPosition = startPosition;
        this.length = length;
        this.type = type;
    }

    public String getName() {
        return name;
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
