package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by avvasi78 on 29.11.2016.
 */
public class PropertyManager {
    private static final String LOG_LEVEL = "logLevel";
    private static final String BROWSER = "browser";

    private static Properties properties;
    private static InputStream inputStream;

    private static void init(){
        properties = new Properties();
        try {
            inputStream = new FileInputStream("./resources/config.properties");
            properties.load(inputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static String getLogLevel(){
        if (properties == null) init();
        return properties.getProperty(LOG_LEVEL);
    }

    public static String getBrowserName(){
        if (properties == null) init();
        return properties.getProperty(BROWSER);
    }
}
