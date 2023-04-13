package jp.co.saison.tori.codekata04.parser;

import java.util.Map;
import java.util.function.Function;

public class Record {

    private final Map<String, String> columns;

    public Record(Map<String, String> columns) {
        this.columns = columns;
    }

    public String getValue(String name) {
        return columns.get(name);
    }

    public String getProcessedValue(String name, Function<String, String> function) {
        return function.apply(columns.get(name));
    }
}
