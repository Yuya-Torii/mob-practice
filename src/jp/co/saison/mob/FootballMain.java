package jp.co.saison.mob;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class FootballMain {
    public static void main(String[] args) {
        final File file = new File("resource/football.dat");
        try {
            final FileReader fileReader = new FileReader(file);
            final BufferedReader bufferedReader = new BufferedReader(fileReader);
            String text;
            while ((text = bufferedReader.readLine()) != null) {

            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
