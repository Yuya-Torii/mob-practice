package jp.co.saison.tori.codekata04.parser;

import java.util.*;

public class RecordDefinition {

    private final int length;

    private final LinkedHashMap<String, Integer> columns;

    private RecordDefinition(LinkedHashMap<String, Integer> columns) {
        this.columns = columns;
        this.length = this.columns.values().stream().mapToInt(Integer::intValue).sum();
    }

    public int getLength() {
        return length;
    }

    public LinkedHashMap<String, Integer> getColumns() {
        return columns;
    }

    public static class RecordDefinitionBuilder {

        private final LinkedHashMap<String, Integer> columns = new LinkedHashMap<>();

        public RecordDefinitionBuilder column(String name, int length) {
            columns.put(name, length);
            return this;
        }

        public RecordDefinition build() {
            return new RecordDefinition(this.columns);
        }
    }
}
