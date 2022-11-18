package jp.co.saison.mob;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // write your code here
        File file = new File("resource/weather.dat");
        ArrayList<String> day = new ArrayList<>();
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String text;
            WeatherRecord weatherRecord = new WeatherRecord();
            while ((text = br.readLine()) != null) {
                if ("".equals(text)) {
                    continue;
                }
                String dy = text.substring(0, 4);
                System.out.println(dy);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
