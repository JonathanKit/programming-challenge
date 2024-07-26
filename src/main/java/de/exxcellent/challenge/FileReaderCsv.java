package de.exxcellent.challenge;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FileReaderCsv<T> {
    private final Function<String[], T> mapper;

    public FileReaderCsv(Function<String[], T> mapper) {
        this.mapper = mapper;
    }

    public List<T> readData(String filename) throws IOException {
        List<T> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            // Skip header
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                data.add(mapper.apply(values));
            }
        } catch (IOException e) {
            // Handle file not found or other IO errors
            System.err.println("Error with file: " + filename);
            throw e; // Rethrow the exception to the caller
        }
        return data;
    }
}
