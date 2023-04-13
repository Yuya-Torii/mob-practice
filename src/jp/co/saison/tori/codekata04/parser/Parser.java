package jp.co.saison.tori.codekata04.parser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Parser {

    private final RecordDefinition recordDefinition;

    public Parser(RecordDefinition recordDefinition) {
        this.recordDefinition = recordDefinition;
    }

    public List<Record> parse(InputStreamReader isr) {
        Stream<String> lines = new BufferedReader(isr).lines();
        return lines.filter(line -> recordDefinition.getLength() <= line.length())
                .map(this::parse)
                .collect(Collectors.toList());
    }

    private Record parse(String line) {
        String remaining = line;
        Map<String, String> columns = new HashMap<>();
        for (Map.Entry<String, Integer> colDefinition : recordDefinition.getColumns().entrySet()) {
            int len = colDefinition.getValue();
            columns.put(colDefinition.getKey(), remaining.substring(0, len));
            remaining = remaining.substring(len - 1);
        }
        return new Record(columns);
    }
}
