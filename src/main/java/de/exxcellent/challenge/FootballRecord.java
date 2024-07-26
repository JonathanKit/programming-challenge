package de.exxcellent.challenge;

public class FootballRecord {
    private final String teamName;
    private final int goalsScored;
    private final int goalsAllowed;

    public FootballRecord(String teamName, int goalsScored, int goalsAllowed) {
        this.teamName = teamName;
        this.goalsScored = goalsScored;
        this.goalsAllowed = goalsAllowed;
    }

    public String getTeamName() {
        return teamName;
    }

    public int getGoalDifference() {
        return Math.abs(goalsScored - goalsAllowed);
    }
}