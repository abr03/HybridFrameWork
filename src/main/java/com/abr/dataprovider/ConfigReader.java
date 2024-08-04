package com.abr.dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    public static String getProperty(String key) {
        Properties pro = new Properties();
       
        
        try {
            FileInputStream fis = new FileInputStream(new File("./ConfigFiles/ConfigPropoerties.txt"));
            pro.load(fis);
        } catch (FileNotFoundException e) {
            System.out.println("File not Found check location: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Could not read the file: " + e.getMessage());
        }

        String value = pro.getProperty(key);
       // System.out.println(value);
        return value;
    }

  
}
