package de.exxcellent.challenge;

import java.io.IOException;
import java.util.List;

public class FootballAnalyzer {
    private final String filename;

    public FootballAnalyzer(String filename) {
        this.filename = filename;
    }

    public List<FootballRecord> getFootballData(String filename) {
        FileReaderCsv<FootballRecord> footballReader = new FileReaderCsv<>(values -> new FootballRecord(
                values[0],
                Integer.parseInt(values[1]),
                Integer.parseInt(values[2])
        ));
        List<FootballRecord> footballData;
        try {
            footballData = footballReader.readData(this.filename);
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
