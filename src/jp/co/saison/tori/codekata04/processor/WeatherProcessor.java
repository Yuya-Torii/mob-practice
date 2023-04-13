package jp.co.saison.tori.codekata04.processor;

import jp.co.saison.tori.codekata04.parser.Record;
import jp.co.saison.tori.codekata04.parser.RecordDefinition;

import java.util.ArrayList;
import java.util.List;

class WeatherProcessor extends Kata04Processor {

    static final String TYPE_NAME = "weather";

    public WeatherProcessor() {
        super();
    }

    @Override
    public String handle(List<Record> records) {
        List<String> stableTemperatureDays = extractStableTemperatureDays(records);
        return "Most stable day(s) are " + String.join(", ", stableTemperatureDays);
    }

    private List<String> extractStableTemperatureDays(List<Record> records) {
        int minDiff = Integer.MAX_VALUE;
        List<String> stableDays = new ArrayList<>();
        for (Record r : records) {
            int max = Integer.parseInt(r.getProcessedValue("MxT", String::trim));
            int min = Integer.parseInt(r.getProcessedValue("MnT", String::trim));
            if (max - min <= minDiff) {
                minDiff = max - min;
                stableDays.add(r.getProcessedValue("Day", String::trim));
            }
        }
        return stableDays;
    }

    @Override
    RecordDefinition defineRecords() {
        return new RecordDefinition.RecordDefinitionBuilder()
                .column("Dy", 4)
                .column("MxT", 4)
                .column("MnT", 6)
                .column("AvT", 6)
                .column("HDDay", 8)
                .column("AvDP", 6)
                .column("HrP", 5)
                .column("TPcpn", 6)
                .column("WxType", 7)
                .column("PDir", 5)
                .column("AvSp", 5)
                .column("Dir", 4)
                .column("MxS", 4)
                .column("SkyC", 5)
                .column("MxR", 4)
                .column("MnR", 4)
                .column("AvSLP", 6)
                .build();
    }
}
