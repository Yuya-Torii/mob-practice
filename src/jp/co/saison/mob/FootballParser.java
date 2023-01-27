package jp.co.saison.mob;

import static jp.co.saison.mob.FootballFormat.AGAINST_GOAL_END;
import static jp.co.saison.mob.FootballFormat.AGAINST_GOAL_START;
import static jp.co.saison.mob.FootballFormat.FOR_GOAL_END;
import static jp.co.saison.mob.FootballFormat.FOR_GOAL_START;
import static jp.co.saison.mob.FootballFormat.NAME_END;
import static jp.co.saison.mob.FootballFormat.NAME_START;

public class FootballParser implements KataParser {
    @Override
    public KataRecord setRecord(String text) {
        String name = text.substring(NAME_START, NAME_END).replace(" ", "");
        if (name.contains("--") || text.contains("Team")) {
            return null;
        }
        String forGoal = text.substring(FOR_GOAL_START, FOR_GOAL_END);
        String againstGoal = text.substring(AGAINST_GOAL_START, AGAINST_GOAL_END);

        return new FootballRecord(name, forGoal, againstGoal);
    }
}
