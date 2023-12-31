package com.iiitb.imageEffectApplication.service;

import com.iiitb.imageEffectApplication.model.LogModel;
import org.springframework.stereotype.Service;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class LoggingService {

    public void addLog(String fileName, String effectName, String optionValues) {
        try
        {
            File file = new File("log.log");
            if(!file.exists())
            {
                file.createNewFile();
            }

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        LocalDateTime localDateTime = LocalDateTime.now();
        String timestamp = localDateTime.toString();
        try
        {
            FileWriter writer=new FileWriter("log.log",true);
            BufferedWriter buffer = new BufferedWriter(writer);
            buffer.write(effectName+","+optionValues+","+timestamp+","+fileName+"\n");
            buffer.close();
            writer.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public List<LogModel> getAllLogs() {

        List<LogModel> logs=new ArrayList<>();
        try
        {
            File file = new File("log.log");
            if(!file.exists())
            {
                file.createNewFile();
            }
            FileReader reader=new FileReader(file);
            BufferedReader buffer = new BufferedReader(reader);
            String line;
            while((line=buffer.readLine())!=null)
            {
                String[] log=line.split(",");
                logs.add(new LogModel(log[2],log[3],log[0],log[1]));
            }
            Collections.reverse(logs);
            buffer.close();
            reader.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return logs;
    }

    public List<LogModel> getLogsByEffect(String effectName) {
        List<LogModel> logs=new ArrayList<>();
        try
        {
            File file = new File("log.log");
            if(!file.exists())
            {
                file.createNewFile();
            }
            FileReader reader=new FileReader(file);
            BufferedReader buffer = new BufferedReader(reader);
            String line;
            while((line=buffer.readLine())!=null)
            {
                String[] log=line.split(",");
                if(log[0].equals(effectName))
                {
                    logs.add(new LogModel(log[2],log[3],log[0],log[1]));
                }
            }
            buffer.close();
            reader.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return logs;
    }

    public void clearLogs() {
        try
        {
            File file = new File("log.log");
            if(!file.exists())
            {
                file.createNewFile();
            }
            FileWriter fw= new FileWriter(file, false);
            fw.write("");
            fw.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return;
    }
    public List<LogModel> getLogsBetweenTimestamps(LocalDateTime startTime, LocalDateTime endTime)
    {
        List<LogModel> logsBetweenTimestamps= new ArrayList<>();
        try{
            File file = new File("log.log");
            if(!file.exists())
            {
                file.createNewFile();
            }
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null){
                String [] sp = line.split(",");
                String timestamp = sp[2];
                String fileName = sp[3];
                String effectName = sp[0];
                String optionValues = sp[1];
                LocalDateTime effectTimeStamp = LocalDateTime.parse(timestamp);
                if (effectTimeStamp.isAfter(startTime) && effectTimeStamp.isBefore(endTime))
                {
                    LogModel logModel = new LogModel(timestamp, fileName, effectName, optionValues);
                    logsBetweenTimestamps.add(logModel);
                }
            }
            bufferedReader.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return logsBetweenTimestamps;
    }
}
