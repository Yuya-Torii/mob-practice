package jp.co.saison.tori.codekata04.parser;

import java.util.*;
import java.util.function.Function;

public class RecordDefinition {

    private final int length;

    private final List<ColumnDefinition> columnDefinitions;

    private RecordDefinition(List<ColumnDefinition> columnDefinitions) {
        this.columnDefinitions = columnDefinitions;
        this.length = this.columnDefinitions.stream().mapToInt(ColumnDefinition::getLength).sum();
    }

    public int getLength() {
        return length;
    }

    public List<ColumnDefinition> getColumnDefinitions() {
        return columnDefinitions;
    }

    public static class RecordDefinitionBuilder {

        private final List<ColumnDefinition> columnDefinitions = new ArrayList<>();

        public RecordDefinitionBuilder column(String name, int length, ColumnDefinition.DataType type) {
            columnDefinitions.add(new ColumnDefinition(name, length, type));
            return this;
        }

        public RecordDefinitionBuilder column(String name, int length, ColumnDefinition.DataType type, Function<String, String> preparation) {
            columnDefinitions.add(new ColumnDefinition(name, length, type, preparation));
            return this;
        }

        public RecordDefinition build() {
            return new RecordDefinition(this.columnDefinitions);
        }
    }
}
