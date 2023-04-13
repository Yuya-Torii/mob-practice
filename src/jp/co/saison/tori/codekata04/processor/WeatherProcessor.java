package jp.co.saison.tori.codekata04.processor;

import jp.co.saison.tori.codekata04.parser.ColumnDefinition.DataType;
import jp.co.saison.tori.codekata04.parser.FileDefinition;
import jp.co.saison.tori.codekata04.parser.Record;
import jp.co.saison.tori.codekata04.parser.RecordDefinition;

import java.util.List;

class WeatherProcessor extends Kata04Processor {

    static final String TYPE_NAME = "weather";

    protected WeatherProcessor(String path) {
        super(path);
    }

    @Override
    public String handle(List<Record> records) {
        String stableTemperatureDays = extractStableTemperatureDays(records);
        return "Most stable day is " + stableTemperatureDays;
    }

    @Override
    protected FileDefinition defineFile(String path) {
        return new FileDefinition(path, 2, 1);
    }

    private String extractStableTemperatureDays(List<Record> records) {
        int minDiff = Integer.MAX_VALUE;
        String stableDay = null;
        for (Record r : records) {
            int max = Integer.parseInt(r.getValue("MxT"));
            int min = Integer.parseInt(r.getValue("MnT"));
            if (max - min <= minDiff) {
                minDiff = max - min;
                stableDay = r.getValue("Dy");
            }
        }
        return stableDay;
    }

    @Override
    protected RecordDefinition defineRecords() {
        return new RecordDefinition.RecordDefinitionBuilder()
                .column("Dy", 5, DataType.NUMBER, String::trim)
                .column("MxT", 6, DataType.NUMBER, this::removeAsterisk)
                .column("MnT", 6, DataType.NUMBER, this::removeAsterisk)
                .column("AvT", 6, DataType.NUMBER, String::trim)
                .column("HDDay", 6, DataType.NUMBER, String::trim)
                .column("AvDP", 6, DataType.NUMBER, String::trim)
                .column("HrP", 5, DataType.NUMBER, String::trim)
                .column("TPcpn", 6, DataType.NUMBER, String::trim)
                .column("WxType", 7, DataType.TEXT, String::trim)
                .column("PDir", 5, DataType.NUMBER, String::trim)
                .column("AvSp", 5, DataType.NUMBER, String::trim)
                .column("Dir", 4, DataType.NUMBER, String::trim)
                .column("MxS", 4, DataType.NUMBER, this::removeAsterisk)
                .column("SkyC", 5, DataType.NUMBER, String::trim)
                .column("MxR", 4, DataType.NUMBER, String::trim)
                .column("MnR", 3, DataType.NUMBER, String::trim)
                .column("AvSLP", 6, DataType.NUMBER, String::trim)
                .build();
    }

    private String removeAsterisk(String value) {
        return value.trim().replace("*", "");
    }
}
