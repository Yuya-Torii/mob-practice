package jp.co.wistech.codekata.parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class RecordParser implements FixedLengthParser {

    public static final String FAIL_ON_UNPARSEABLE_RECORD = "skip.unparseable.record";
    private final List<RecordDefinition> recordDefinitions;
    private final RecordHandler handler;
    private final Map<String, Object> configure;

    public RecordParser(List<RecordDefinition> recordDefinitions, RecordHandler handler, Map<String, Object> configure) {
        this.recordDefinitions = recordDefinitions;
        this.handler = handler;
        this.configure = configure;
    }


    @Override
    public void parse(InputStreamReader reader) throws IOException {
        try (Stream<String> lines = new BufferedReader(reader).lines()) {
            lines.forEach(this::parseLine);
        }
    }

    private void parseLine(String line) {
        for (RecordDefinition recordDefinition : recordDefinitions) {
            if (line.length() != recordDefinition.getRecordLength()) {
                break;
            }
            int linePosition = 0;
            boolean unmatch = false;
            for (RecordDefinition.FieldDefinition fieldDefinition : recordDefinition.getFieldDefinitions()) {
                int fieldLength = fieldDefinition.getLength();
                if (!fieldDefinition.getType().canParse(line.substring(linePosition, linePosition + fieldLength))) {
                    unmatch = true;
                    break;
                }
                linePosition = linePosition + fieldLength;
            }
            if (unmatch) {
                continue;
            }
            Record record = toRecord(line, recordDefinition);
            handler.handle(record);
            return;
        }

        boolean failOnUnparseable = Boolean.parseBoolean(configure.getOrDefault(FAIL_ON_UNPARSEABLE_RECORD, false).toString());
        if (failOnUnparseable) {
            throw new IllegalArgumentException("Unparseable:[" + line + "]");
        }
    }

    private Record toRecord(String line, RecordDefinition recordDefinition) {
        Map<String, Record.Field> fields = new HashMap<>();
        int linePosition = 0;

        for (RecordDefinition.FieldDefinition fieldDefinition : recordDefinition.getFieldDefinitions()) {
            String value = line.substring(linePosition, linePosition + fieldDefinition.getLength());
            Record.Field field = new Record.Field() {
                @Override
                public String getName() {
                    return fieldDefinition.getName();
                }

                @Override
                public String getValue() {
                    return value;
                }

                @Override
                public RecordDefinition.FieldDefinition.FieldType getType() {
                    return fieldDefinition.getType();
                }
            };
            fields.put(field.getName(), field);
            linePosition = linePosition + fieldDefinition.getLength();
        }
        return new Record() {
            @Override
            public String getCategory() {
                return recordDefinition.getCategory();
            }

            @Override
            public Field getField(String name) {
                return fields.get(name);
            }

            @Override
            public Field[] getFields() {
                return fields.values().toArray(new Field[0]);
            }
        };
    }
}
