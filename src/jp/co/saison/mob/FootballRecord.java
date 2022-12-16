package jp.co.saison.mob;

public class FootballRecord implements KataRecord{

    private final String name;
    private final int forGoal;
    private final int againstGoal;

    public FootballRecord(String name, String forGoal, String againstGoal) {
        this.name = name;
        this.forGoal = Integer.parseInt(forGoal);
        this.againstGoal = Integer.parseInt(againstGoal);
    }

    public int getGoalDiff() {
        return Math.abs(forGoal - againstGoal);
    }

    @Override
    public String getDisplayName() {
        return name;
    }

    @Override
    public int getDiff() {
        return Math.abs(forGoal - againstGoal);
    }
}
