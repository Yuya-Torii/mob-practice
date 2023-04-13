package jp.co.saison.tori.codekata04;

import jp.co.saison.tori.codekata04.parser.Record;
import jp.co.saison.tori.codekata04.processor.Kata04Processor;

import java.util.List;

public class CodeKata04Main {

    public static void main(String[] args) {

        Kata04Processor processor = Kata04Processor.processor(args[0], args[1]);

        try {
            List<Record> records = processor.parse();
            String resultMessage = processor.handle(records);
            System.out.println(resultMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
