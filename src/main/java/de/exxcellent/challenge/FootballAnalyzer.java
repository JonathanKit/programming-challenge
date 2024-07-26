package de.exxcellent.challenge;

import java.io.IOException;
import java.util.List;

public class FootballAnalyzer {
    private final String filename;

    public FootballAnalyzer(String filename) {
        this.filename = filename;
    }

    public List<FootballRecord> getFootballData(String filename) {
        // The file with football data has in column 0: team name, column 5: goals scored, column 6: goals allowed
        FileReaderCsv<FootballRecord> footballReader = new FileReaderCsv<>(values -> new FootballRecord(
                values[0],
                Integer.parseInt(values[5]),
                Integer.parseInt(values[6])
        ));
        List<FootballRecord> footballData;
        try {
            footballData = footballReader.readData(filename);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return footballData;
    }

    public String findRecordWithSmallestSpread() {
        List<FootballRecord> footballData;
        try {
            footballData = getFootballData(this.filename);
        } catch(Exception e) {
            System.out.println("Failed to get football data");
            throw new RuntimeException(e);
        }
        String minSpreadTeam = "";
        double minSpread = Double.MAX_VALUE;
        for (FootballRecord footballRecord : footballData) {
            double spread = footballRecord.getGoalDifference();
            if (spread < minSpread) {
                minSpread = spread;
                minSpreadTeam = footballRecord.getTeamName();
            }
        }
        return minSpreadTeam;
    }
}
