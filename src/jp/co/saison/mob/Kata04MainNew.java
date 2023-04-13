package jp.co.saison.mob;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.*;

public class Kata04MainNew {

    public static void main(String[] args) {
        String filename = args[0];
        String type = args[1];

        Strategy strategy = new FootballStrategy();

        final File file = new File(filename);
        try (final FileReader fileReader = new FileReader(file);
             final BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            // Formatをつくる
            final Format format = new Format(strategy.makeColumnSet());

            // Parserをつくる
            final Parser parser = new Parser(format);

            // TODO 空行をどうスキップするか （ヘッダとか、非データ行の定義、情報をどう扱うか）
            // TODO *付きなど、特殊なルールをどう扱うか
            // TODO 小数点は処理できてる？
            String text;
            List<Record> records = new ArrayList<>();
            while ((text = bufferedReader.readLine()) != null) {
                try {
                    final Record record = parser.parse(text);
                    if (record == null) {
                        continue;
                    }
                    records.add(record);
                } catch (NumberFormatException e) {
                    continue;
                }
            }

            // TODO minの中が冗長すぎる。短くしたい
            // TODO キャストのやり方は大丈夫か、チェックしなくていい？
            // TODO orElseThrow(NullPointerException いいの？
            strategy.handle(records);

            // TODO WeatherとFootballの切り替えってどうやるの？
//            String result = parser.getRecord(filename);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
