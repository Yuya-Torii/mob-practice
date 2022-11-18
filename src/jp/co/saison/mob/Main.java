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
            final List<WeatherRecord> list = new ArrayList<>();
            br.readLine();
            br.readLine();
            while ((text = br.readLine()) != null) {
//                if ("".equals(text)) {
//                    continue;
//                }
                if (text.contains("mo")) {
                    continue;
                }
                String dy = text.substring(0, 4).replace(" ","");
                String mxt = text.substring(4,9).replace(" ","");
                String mnt = text.substring(9,14).replace(" ","");
                final int intDay = Integer.parseInt(dy);
                final int intMxt = Integer.parseInt(mxt);
                final int intMnt = Integer.parseInt(mnt);
                WeatherRecord weatherRecord = new WeatherRecord(intDay, intMxt, intMnt);

                System.out.println(intDay);
//                System.out.println(mxt);
//                System.out.println(mnt);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
