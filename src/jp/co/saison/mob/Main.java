package jp.co.saison.mob;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // write your code here
        File file = new File("resource/weather.dat");
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String text;
            WeatherRecord weatherRecord = new WeatherRecord();
            final List<WeatherRecord> list = new ArrayList<>();
            while ((text = br.readLine()) != null) {
                if ("".equals(text)) {
                    continue;
                }
                String dy = text.substring(0, 4);
                String mxt = text.substring(4,8);
                System.out.println(dy);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
