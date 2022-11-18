package jp.co.wistech.codekata.parser;

import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface FixedLengthParser {

    void parse(InputStreamReader inputStream) throws IOException;

    static Builder builder() {
        return new Builder();
    }

    interface RecordHandler {
        void handle(Record record);
    }

    interface Record {

        String getCategory();

        Field getField(String name);

        Field[] getFields();

        interface Field {

            String getName();

            String getValue();

            RecordDefinition.FieldDefinition.FieldType getType();
        }

    }

    public static class Builder {

        private RecordHandler handler;
        private final List<RecordDefinition> recordDefinitions = new ArrayList<>();
        private final HashMap<String, Object> configure = new HashMap<>();

        public Builder record(RecordDefinition recordDefinition) {
            recordDefinitions.add(recordDefinition);
            return this;
        }

        public Builder handler(RecordHandler handler) {
            this.handler = handler;
            return this;
        }

        public Builder configure(String key, Object value) {
            configure.put(key, value);
            return this;
        }

        public FixedLengthParser build() {
            return new RecordParser(recordDefinitions, handler, configure);
        }

    }

    public static class RecordDefinition {

        private final String category;
        private final List<FieldDefinition> fieldDefinitions = new ArrayList<>();

        public RecordDefinition(String category) {
            this.category = category;
        }

        public static RecordDefinition header() {
            return new RecordDefinition("HEADER");
        }

        public static RecordDefinition body() {
            return new RecordDefinition("BODY");
        }

        public static RecordDefinition footer() {
            return new RecordDefinition("FOOTER");
        }

        public RecordDefinition field(FieldDefinition fieldDefinition) {
            fieldDefinitions.add(fieldDefinition);
            return this;
        }

        public RecordDefinition fields(FieldDefinition... fieldDefinitions) {
            for (FieldDefinition fieldDefinition : fieldDefinitions) {
                field(fieldDefinition);
            }
            return this;
        }

        public String getCategory() {
            return category;
        }

        public List<FieldDefinition> getFieldDefinitions() {
            return fieldDefinitions;
        }

        public int getRecordLength() {
            return getFieldDefinitions().stream().mapToInt(FieldDefinition::getLength).sum();
        }

        public static class FieldDefinition {

            private final FieldType type;
            private int length;
            private String name;

            public FieldDefinition(FieldType type) {
                this.type = type;
            }

            public FieldDefinition length(int length) {
                this.length = length;
                return this;
            }

            public FieldDefinition name(String name) {
                this.name = name;
                return this;
            }

            public String getName() {
                return name;
            }

            public int getLength() {
                return length;
            }

            public FieldDefinition type() {
                return this;
            }

            public FieldType getType() {
                return type;
            }

            public interface FieldType {
                boolean canParse(String value);

                class Text implements FieldType {

                    @Override
                    public boolean canParse(String value) {
                        return true;
                    }
                }

                class Number implements FieldType {

                    @Override
                    public boolean canParse(String value) {
                        try {
                            new BigDecimal(value.trim());
                            return true;
                        } catch (Exception e) {
                            return false;
                        }
                    }
                }

                class Fix implements FieldType {

                    private final String fixValue;

                    public Fix(String fixValue) {
                        this.fixValue = fixValue;
                    }

                    @Override
                    public boolean canParse(String value) {
                        return value.equals(fixValue);
                    }
                }
            }

            public static FieldDefinition text(String name, int length) {
                return new FieldDefinition(new FieldType.Text()).name(name).length(length);
            }

            public static FieldDefinition number(String name, int length) {
                return new FieldDefinition(new FieldType.Number()).name(name).length(length);
            }
        }
    }
}
