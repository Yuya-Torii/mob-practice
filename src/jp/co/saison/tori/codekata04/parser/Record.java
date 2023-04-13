package jp.co.saison.tori.codekata04.parser;

import java.util.Map;

public class Record {

    private final Map<String, String> columns;

    public Record(Map<String, String> columns) {
        this.columns = columns;
    }

    public String getValue(String name) {
        return columns.get(name);
    }

}
