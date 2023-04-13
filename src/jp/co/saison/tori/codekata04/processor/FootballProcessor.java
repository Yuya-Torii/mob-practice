package jp.co.saison.tori.codekata04.processor;

import jp.co.saison.tori.codekata04.parser.FileDefinition;
import jp.co.saison.tori.codekata04.parser.Record;
import jp.co.saison.tori.codekata04.parser.RecordDefinition;

import java.util.List;

class FootballProcessor extends Kata04Processor {

    static final String TYPE_NAME = "football";

    protected FootballProcessor(String path) {
        super(path);
    }

    @Override
    public String handle(List<Record> records) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    protected FileDefinition defineFile(String path) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    protected RecordDefinition defineRecords() {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
