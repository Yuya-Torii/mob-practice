package jp.co.saison.mob;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;

public class Kata04MainNew {

    public static void main(String[] args) {
        String filename = args[0];
        String parserType = args[1];
        final File file = new File(filename);
        try (final FileReader fileReader = new FileReader(file);
             final BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String text;
            ArrayList<KataRecord> kataRecords = new ArrayList<>();

            // ColumnのSetをつくる
            // Formatをつくる
            // Parserをつくる
            KataParser kataParser = KataParserFactory.createParser(parserType);
//            Parser parser = new Parser();
//            final Column dy = new Column();

            while ((text = bufferedReader.readLine()) != null) {
                if (kataParser.setRecord(text) != null) {
                    kataRecords.add(kataParser.setRecord(text));
                }
            }

            KataRecord minRecord = kataRecords.stream()
                    .min(Comparator.comparing(KataRecord::getDiff))
                    .orElseThrow(NullPointerException::new);

			System.out.println(minRecord.getDisplayName());

//            String result = parser.getRecord(filename);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
