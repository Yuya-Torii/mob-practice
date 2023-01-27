package jp.co.saison.mob;

public class WeatherParser implements KataParser {
    @Override
    public WeatherRecord setRecord(String text) {
        if (text.contains("mo") || text.contains("Dy")) {
            return null;
        }
        if (text.length() == 0) {
            return null;
        }
        String dy = text.substring(0, 4).replace(" ", "").replace("*", "");
        String mxt = text.substring(4, 9).replace(" ", "").replace("*", "");
        String mnt = text.substring(9, 14).replace(" ", "").replace("*", "");
        final int intDay = Integer.parseInt(dy);
        final int intMxt = Integer.parseInt(mxt);
        final int intMnt = Integer.parseInt(mnt);

        return new WeatherRecord(intDay, intMxt, intMnt);
    }
}
