package jp.co.saison.mob;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // write your code here
        File file = new File("resource/football.dat");
        try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr)) {
            String text;
            br.readLine();

            int min = Integer.MAX_VALUE;
            List<String> minTeam = new ArrayList<>();
            while ((text = br.readLine()) != null) {
                if (text.contains("--")) {
                    continue;
                }
                String team = text.substring(7, 22).replace(" ", "");
                final int intF = Integer.parseInt(text.substring(43, 47).trim());
                final int intA = Integer.parseInt(text.substring(50, 54).trim());
                int abs = Math.abs(intF - intA);

                if (min > abs) {
                    min = abs;
                    minTeam.clear();
                    minTeam.add(team);
                } else if (min == abs) {
                    minTeam.add(team);
                }
            }
            for (String team : minTeam) {
                System.out.println(team);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
