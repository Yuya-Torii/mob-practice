package jp.co.saison.tori.codekata04.processor;

import jp.co.saison.tori.codekata04.parser.Parser;
import jp.co.saison.tori.codekata04.parser.Record;
import jp.co.saison.tori.codekata04.parser.RecordDefinition;

import java.io.InputStreamReader;
import java.util.List;

public abstract class Kata04Processor {

    private final Parser parser;

    public abstract String handle(List<Record> records);

    abstract RecordDefinition defineRecords();

    protected Kata04Processor() {
        this.parser = new Parser(defineRecords());
    }

    public List<Record> parse(InputStreamReader isr) {
        return parser.parse(isr);
    }

    public static Kata04Processor processor(String type) {
        return switch (type) {
            case WeatherProcessor.TYPE_NAME -> new WeatherProcessor();
            case FootballProcessor.TYPE_NAME -> new FootballProcessor();
            default -> throw new IllegalArgumentException("Unknown format type");
        };
    }

}
