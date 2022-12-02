package jp.co.saison.mob;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        // write your code here
        File file = new File("resource/football.dat");
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String text;
            final Map<Integer, Integer> map = new HashMap<>();
            br.readLine();

            int min = Integer.MAX_VALUE;
            int minDay = 0;
            while ((text = br.readLine()) != null) {
//                if ("".equals(text)) {
//                    continue;
//                }
                if (text.contains("--")) {
                    continue;
                }
                String team = text.substring(7, 22).replace(" ", "");
                //System.out.println(team);
                String f = text.substring(43, 47).trim();
                String a = text.substring(50, 54).trim();
                //System.out.println(f);
                //System.out.println(a);
                //String mnt = text.substring(9, 14).replace(" ", "").replace("*", "");
                final int intF = Integer.parseInt(f);
                final int intA = Integer.parseInt(a);
                System.out.println(intA);
                //WeatherRecord weatherRecord = new WeatherRecord(intDay, intMxt, intMnt);
                //final int temperatureDiff = weatherRecord.getTemperatureDiff();
                //if (min > temperatureDiff) {
                 //   min = temperatureDiff;
                  //  minDay = intDay;
                //}
//                map.put(intDay, weatherRecord.getTemperatureDiff());

                //System.out.println(intDay);
//                System.out.println(mxt);
//                System.out.println(mnt);
            }
            // mapのvalueを比較
            //System.out.println("minimum diff day is " + minDay);
            //System.out.println("minimum temp diff is " + min);
//            final Integer min = Collections.min(map.values());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
