package jp.co.saison.mob;

public class FootballParser implements KataParser {
    @Override
    public KataRecord setRecord(String text) {
        String name = text.substring(7, 21).replace(" ", "");
        if (name.contains("--") || text.contains("Team")) {
            return null;
        }
        String forGoal = text.substring(43, 45);
        String againstGoal = text.substring(50, 52);

        return new FootballRecord(name, forGoal, againstGoal);
    }
}
