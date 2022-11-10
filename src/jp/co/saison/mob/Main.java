package jp.co.saison.mob;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        // write your code here
        File file = new File("../../../../../resource/weather.dat");
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String text = br.readLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
