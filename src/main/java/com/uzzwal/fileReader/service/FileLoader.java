package com.uzzwal.fileReader.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.uzzwal.fileReader.model.NameModel;

import jakarta.annotation.PostConstruct;

@Service
public class FileLoader {

    @Autowired
    NameModel model;

    public static final Map<String, NameModel> dataEntry = new HashMap<>();

    private FileLoader() {

    }

    @PostConstruct
    public static void getData() {
        try {
            System.out.println("Reading file in FileLoader Class");
            File file = ResourceUtils.getFile("classpath:DataEntry.csv");
            readConfig(file);

        } catch (Exception ex) {
            System.out.println("Exception in Config Class" + ex.getLocalizedMessage());
        }
    }

    public static void readConfig(File file) {
        try {
            BufferedReader scanner = new BufferedReader(new FileReader(file));
            String line = "";
            line = scanner.readLine(); // To skip the column names
            while (null != (line = scanner.readLine())) {
                List<String> columns = Arrays.asList(line.split(","));
                NameModel entry = new NameModel();
                String email = columns.get(1);
                entry.setName(columns.get(0));
                entry.setEmail(columns.get(1));
                entry.setAge(columns.get(2));
                dataEntry.put(email, entry);
            }
            scanner.close();
        } catch (Exception ex) {
            System.out.println("Exception occured while reading file" + ex.getLocalizedMessage());
        }
    }
}
