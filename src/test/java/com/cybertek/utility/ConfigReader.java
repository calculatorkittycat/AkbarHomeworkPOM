package com.cybertek.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * this class has a method called "read" that takes care of reading from the properties file
 * since it is a static method all we have to do to use it is call it by the class name like this
 * ConfigReader.read - when we want to use it
 * It accepts a string parameter named "key"
 *
 * to read from the properties file you need a new Properties object
 * also a new FileInputStream object must be declared
 * the FileInputStream object throws an IOException
 * it will be handled here with try and catch blocks
 *
 * The FileInputStream loads the config.properties here
 * then the Properties object uses that file
 * as you can see it says properties.load(in) "in" is the FileInputStream loading the file
 * it is passed into the properties objects method "load"
 * like the Scanner the FileInputStream must be closed after use, to save memory
 */

public class ConfigReader {

    private static Properties properties = new Properties();

    static {

        try{
            FileInputStream in = new FileInputStream("config.properties");
            properties.load(in);
            in.close();
        } catch (IOException e) {
            System.out.println("Error occurred, likely key mismatch");
        }
    }

    public static String read(String key){
        return properties.getProperty(key);
    }

}
