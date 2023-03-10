package jp.co.saison.mob;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.*;

public class Kata04MainNew {

    public static void main(String[] args) {
        String filename = args[0];
        final File file = new File(filename);
        try (final FileReader fileReader = new FileReader(file);
             final BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            final int headerCount = 2;

            // ColumnのSetをつくる
            Set<Column> columnSet = new HashSet<>();
            final Column dy = new Column("Dy", 0, 4, ColumnType.Number);
            columnSet.add(dy);
            final Column mxt = new Column("MxT", 4, 6, ColumnType.Number);
            columnSet.add(mxt);
            final Column mnt = new Column("MnT", 10, 6, ColumnType.Number);
            columnSet.add(mnt);

            // Formatをつくる
            final Format format = new Format(columnSet);

            // Parserをつくる
            final Parser parser = new Parser(format);

            // TODO 空行をどうスキップするか （ヘッダとか、非データ行の定義、情報をどう扱うか）
            // TODO *付きなど、特殊なルールをどう扱うか
            // TODO 小数点は処理できてる？
            String text;
            List<Record> records = new ArrayList<>();
            while ((text = bufferedReader.readLine()) != null) {
                try {
                    records.add(parser.parse(text));
                } catch (NumberFormatException e) {
                    continue;
                }
            }

            // TODO minの中が冗長すぎる。短くしたい
            // TODO キャストのやり方は大丈夫か、チェックしなくていい？
            // TODO orElseThrow(NullPointerException いいの？
            final Record minRecord = records.stream()
                    .min(Comparator.comparing(r -> ((BigDecimal) r.items.get("MxT")).subtract(((BigDecimal) r.items.get("MnT")))))
                    .orElseThrow(NullPointerException::new);

            final Object minDiffDay = minRecord.items.get("Dy");
            System.out.println(minDiffDay);

//            KataRecord minRecord = kataRecords.stream()
//                    .min(Comparator.comparing(KataRecord::getDiff))
//                    .orElseThrow(NullPointerException::new);

            //           System.out.println(minRecord.getDisplayName());

            // TODO WeatherとFootballの切り替えってどうやるの？
//            String result = parser.getRecord(filename);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
