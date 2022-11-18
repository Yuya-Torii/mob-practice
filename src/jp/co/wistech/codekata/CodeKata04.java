package jp.co.wistech.codekata;

import jp.co.wistech.codekata.parser.FixedLengthParser;
import jp.co.wistech.codekata.parser.RecordParser;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static jp.co.wistech.codekata.parser.FixedLengthParser.RecordDefinition.FieldDefinition.number;
import static jp.co.wistech.codekata.parser.FixedLengthParser.RecordDefinition.FieldDefinition.text;
import static jp.co.wistech.codekata.parser.FixedLengthParser.RecordDefinition.body;

public class CodeKata04 {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("C:\\Users\\齊藤毅\\Downloads\\weather.dat");

        Code04Handler handler = new Code04Handler();
        try (InputStreamReader inputStreamReader = new InputStreamReader(Files.newInputStream(path), StandardCharsets.UTF_8)) {
            FixedLengthParser parser = FixedLengthParser.builder()
                    .handler(handler)
                    .record(body().fields(
                            number("Day", 4),
                            number("MxT", 4),
                            number("MnT", 6),
                            text("FILLER", 75)))
                    .configure(RecordParser.FAIL_ON_UNPARSEABLE_RECORD, false).build();
            parser.parse(inputStreamReader);
        }
        System.out.println(String.format("日にち: %s, 気温差:%d", handler.getDay(), handler.getTempDiff()));
    }

    private static class Code04Handler implements FixedLengthParser.RecordHandler {
        private String day;
        private int tempDiff = Integer.MAX_VALUE;

        @Override
        public void handle(FixedLengthParser.Record record) {
            int max = Integer.parseInt(record.getField("MxT").getValue().trim());
            int min = Integer.parseInt(record.getField("MnT").getValue().trim());
            if (tempDiff > max - min) {
                tempDiff = max - min;
                day = record.getField("Day").getValue().trim();
            }
        }

        public String getDay() {
            return day;
        }

        public int getTempDiff() {
            return tempDiff;
        }
    }

    private static class PrintRecordHandler implements FixedLengthParser.RecordHandler {

        @Override
        public void handle(FixedLengthParser.Record record) {
            System.out.println("カテゴリ:" + record.getCategory());
            for (FixedLengthParser.Record.Field field : record.getFields()) {
                System.out.printf("名前: %s, 値: %s%n", field.getName(), field.getValue());
            }
        }
    }
}
