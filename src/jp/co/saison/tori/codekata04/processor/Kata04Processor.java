package jp.co.saison.tori.codekata04.processor;

import jp.co.saison.tori.codekata04.parser.FileDefinition;
import jp.co.saison.tori.codekata04.parser.Parser;
import jp.co.saison.tori.codekata04.parser.Record;
import jp.co.saison.tori.codekata04.parser.RecordDefinition;

import java.io.IOException;
import java.util.List;

public abstract class Kata04Processor {

    private final Parser parser;

    public abstract String handle(List<Record> records);

    protected abstract FileDefinition defineFile(String path);

    protected abstract RecordDefinition defineRecords();

    protected Kata04Processor(String path) {
        this.parser = new Parser(defineFile(path), defineRecords());
    }

    public List<Record> parse() throws IOException {
        return parser.parse();
    }

    public static Kata04Processor processor(String path, String type) {
        switch (type) {
            case WeatherProcessor.TYPE_NAME:
                return new WeatherProcessor(path);
            case FootballProcessor.TYPE_NAME:
                return new FootballProcessor(path);
            default:
                throw new IllegalArgumentException("Unknown format type");
        }
    }

}
