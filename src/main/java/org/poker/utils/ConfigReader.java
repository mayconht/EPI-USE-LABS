package org.poker.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//Reference: from https://www.baeldung.com/java-properties
//Reference: https://mkyong.com/java/java-properties-file-examples/
public class ConfigReader {
    private final Properties properties = new Properties();

    public ConfigReader() {
        try (final InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
                return;
            }
            this.properties.load(input);
        } catch (final IOException ex) {
            ex.printStackTrace();
        }
    }

    public String[] getRanks() {
        return this.properties.getProperty("ranks").split(",");
    }

    public String[] getSuits() {
        return this.properties.getProperty("suits").split(",");
    }
}
