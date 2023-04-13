package jp.co.saison.tori.codekata04;

import jp.co.saison.tori.codekata04.parser.Record;
import jp.co.saison.tori.codekata04.processor.Kata04Processor;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class CodeKata04Main {

    public static void main(String[] args) {

        Kata04Processor processor = Kata04Processor.processor(args[1]);

        try (InputStreamReader reader = new InputStreamReader(new FileInputStream(args[0]), StandardCharsets.UTF_8)) {
            List<Record> records = processor.parse(reader);
            processor.handle(records);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
