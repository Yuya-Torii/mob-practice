package jp.co.saison.mob;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Kata04Main {

    public static void main(String[] args) {
        String filename = args[0];
        String parserType = args[1];
        final File file = new File(filename);
        try {
            final FileReader fileReader = new FileReader(file);
            final BufferedReader bufferedReader = new BufferedReader(fileReader);
            bufferedReader.readLine();

            ArrayList<FootballRecord> records = new ArrayList<>();
            String text;

        try {
            KataParser parser = KataParserFactory.createParser(parserType);
//            String result = parser.getRecord(filename);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
