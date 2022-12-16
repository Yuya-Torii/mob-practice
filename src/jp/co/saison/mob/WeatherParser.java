package jp.co.saison.mob;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WeatherParser implements KataParser {
    @Override
    public WeatherRecord getRecord(String filename) {
        String dy = filename.substring(0, 4).replace(" ", "").replace("*", "");
        String mxt = filename.substring(4, 9).replace(" ", "").replace("*", "");
        String mnt = filename.substring(9, 14).replace(" ", "").replace("*", "");
        final int intDay = Integer.parseInt(dy);
        final int intMxt = Integer.parseInt(mxt);
        final int intMnt = Integer.parseInt(mnt);
        WeatherRecord weatherRecord = new WeatherRecord(intDay, intMxt, intMnt);
        return weatherRecord;
    }
}
