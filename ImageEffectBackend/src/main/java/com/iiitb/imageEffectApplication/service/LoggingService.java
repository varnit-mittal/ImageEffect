package com.iiitb.imageEffectApplication.service;

import com.iiitb.imageEffectApplication.model.LogModel;
import org.springframework.stereotype.Service;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/**
 * Service class for logging image processing operations.
 */
@Service
public class LoggingService {

    /**
     * Adds a log entry for a specific image processing operation.
     */
    public void addLog(String fileName, String effectName, String optionValues) {
        try {
            // Check if the log file exists, create it if not
            File file = new File("log.log");
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Get the current timestamp
        LocalDateTime localDateTime = LocalDateTime.now();
        String timestamp = localDateTime.toString();

        try {
            // Append log entry to the log file
            FileWriter writer = new FileWriter("log.log", true);
            BufferedWriter buffer = new BufferedWriter(writer);
            buffer.write(effectName + "," + optionValues + "," + timestamp + "," + fileName + "\n");
            buffer.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Retrieves all logs stored in the log file.
     */
    public List<LogModel> getAllLogs() {
        List<LogModel> logs = new ArrayList<>();
        try {
            // Check if the log file exists, create it if not
            File file = new File("log.log");
            if (!file.exists()) {
                file.createNewFile();
            }

            // Read logs from the log file
            FileReader reader = new FileReader(file);
            BufferedReader buffer = new BufferedReader(reader);
            String line;
            while ((line = buffer.readLine()) != null) {
                String[] log = line.split(",");
                logs.add(new LogModel(log[2], log[3], log[0], log[1]));
            }
            // Reverse the order to get the latest logs first
            Collections.reverse(logs);
            buffer.close();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return logs;
    }

    /**
     * Retrieves logs for a specific image processing effect.
     */
    public List<LogModel> getLogsByEffect(String effectName) {
        List<LogModel> logs = new ArrayList<>();
        try {
            // Check if the log file exists, create it if not
            File file = new File("log.log");
            if (!file.exists()) {
                file.createNewFile();
            }

            // Read logs from the log file
            FileReader reader = new FileReader(file);
            BufferedReader buffer = new BufferedReader(reader);
            String line;
            while ((line = buffer.readLine()) != null) {
                String[] log = line.split(",");
                if (log[0].equalsIgnoreCase(effectName)) {
                    logs.add(new LogModel(log[2], log[3], log[0], log[1]));
                }
            }
            buffer.close();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return logs;
    }

    /**
     * Clears all logs from the log file.
     */
    public void clearLogs() {
        try {
            // Check if the log file exists, create it if not
            File file = new File("log.log");
            if (!file.exists()) {
                file.createNewFile();
            }

            // Clear the content of the log file
            FileWriter fw = new FileWriter(file, false);
            fw.write("");
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return;
    }

    /**
     * Retrieves logs between two specified timestamps.
     */
    public List<LogModel> getLogsBetweenTimestamps(LocalDateTime startTime, LocalDateTime endTime) {
        List<LogModel> logsBetweenTimestamps = new ArrayList<>();
        try {
            // Check if the log file exists, create it if not
            File file = new File("log.log");
            if (!file.exists()) {
                file.createNewFile();
            }

            // Read logs from the log file
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] sp = line.split(",");
                String timestamp = sp[2];
                String fileName = sp[3];
                String effectName = sp[0];
                String optionValues = sp[1];
                LocalDateTime effectTimeStamp = LocalDateTime.parse(timestamp);
                if (effectTimeStamp.isAfter(startTime) && effectTimeStamp.isBefore(endTime)) {
                    LogModel logModel = new LogModel(timestamp, fileName, effectName, optionValues);
                    logsBetweenTimestamps.add(logModel);
                }
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return logsBetweenTimestamps;
    }
}
