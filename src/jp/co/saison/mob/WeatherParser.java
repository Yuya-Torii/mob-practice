package jp.co.saison.mob;

import static jp.co.saison.mob.WeatherFormat.DY_END;
import static jp.co.saison.mob.WeatherFormat.DY_START;
import static jp.co.saison.mob.WeatherFormat.MNT_END;
import static jp.co.saison.mob.WeatherFormat.MNT_START;
import static jp.co.saison.mob.WeatherFormat.MXT_END;
import static jp.co.saison.mob.WeatherFormat.MXT_START;

public class WeatherParser implements KataParser {
    @Override
    public WeatherRecord setRecord(String text) {
        if (text.contains("mo") || text.contains("Dy")) {
            return null;
        }
        if (text.length() == 0) {
            return null;
        }
        String dy = this.extractWeatherField(text, DY_START, DY_END);
        String mxt = this.extractWeatherField(text, MXT_START, MXT_END);
        String mnt = this.extractWeatherField(text, MNT_START, MNT_END);
        final int intDay = Integer.parseInt(dy);
        final int intMxt = Integer.parseInt(mxt);
        final int intMnt = Integer.parseInt(mnt);
        return new WeatherRecord(intDay, intMxt, intMnt);
    }

    private String extractWeatherField(String text, int start, int end){
        return text.substring(start, end).replace(" ", "").replace("*", "");
    }
}
