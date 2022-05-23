package demo.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Config {
    public static Properties properties;

    public Config() {
        try {
            properties = new Properties();
            FileInputStream fileInputStream = new FileInputStream("src/test/resources/properties/env.properties");
            properties.load(fileInputStream);
        } catch(FileNotFoundException e) {
            throw new RuntimeException("FileNotFoundException", e);
        } catch (IOException e) {
            throw new RuntimeException("IOException", e);
        }
    }

    public String getProperty(String property) {
        return properties.getProperty(property);
    }
}
