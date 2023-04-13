package jp.co.saison.tori.codekata04.parser;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Parser {

    private final RecordDefinition recordDefinition;

    private final FileDefinition fileDefinition;

    public Parser(FileDefinition fileDefinition, RecordDefinition recordDefinition) {
        this.fileDefinition = fileDefinition;
        this.recordDefinition = recordDefinition;
    }

    public List<Record> parse() throws IOException {
        try (InputStreamReader reader = new InputStreamReader(new FileInputStream(fileDefinition.getPath()), StandardCharsets.UTF_8)) {
            return parse(reader);
        }
    }

    public List<Record> parse(InputStreamReader isr) {
        Stream<String> lines = new BufferedReader(isr).lines();
        // footerもskipしたかったが、count()するとstreamが終わってしまうので、うまく実装できず。いったん放置
//        long limit = lines.count() - fileDefinition.getHeaderRow() - fileDefinition.getFooterRow();
        return lines.skip(fileDefinition.getHeaderRow())
//                .limit(limit)
                .filter(line -> recordDefinition.getLength() <= line.length())
                .map(this::parse)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    private Record parse(String line) {
        String remaining = line;
        Map<String, String> columns = new HashMap<>();
        for (ColumnDefinition columnDefinition : recordDefinition.getColumnDefinitions()) {
            int len = columnDefinition.getLength();
            // 格納前に変換をかける
            String value = columnDefinition.getPreparation().apply(remaining.substring(0, len));
            if (!columnDefinition.getDataType().acceptable(value)) {
                // 値にうまく変換できない場合はNULL
                return null;
            }
            columns.put(columnDefinition.getName(), value);
            remaining = remaining.substring(len);
        }
        return new Record(columns);
    }
}
