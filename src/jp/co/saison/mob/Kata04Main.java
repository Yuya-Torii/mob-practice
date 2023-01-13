package jp.co.saison.mob;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;

public class Kata04Main {

    public static void main(String[] args) {
        String filename = args[0];
        String parserType = args[1];
        final File file = new File(filename);
        try (final FileReader fileReader = new FileReader(file);
             final BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String text;
            ArrayList<KataRecord> kataRecords = new ArrayList<>();
            KataParser parser = KataParserFactory.createParser(parserType);
            while ((text = bufferedReader.readLine()) != null) {
                if (parser.setRecord(text) != null) {
                    kataRecords.add(parser.setRecord(text));
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
