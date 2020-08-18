package framework.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadProperty {
    public static Properties readProperty() {
        FileInputStream propertiesFile = null;
        try {
            propertiesFile = new FileInputStream("./src/main/java/framework/config/wildberries.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Properties properties = new Properties();
        try {
            properties.load(propertiesFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
