package config.properties_handling;

import config.LogHelper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static config.properties_handling.PropertyNames.BROWSER_NAME;
import static config.properties_handling.PropertyNames.LOG_LEVEL;

/**
 * Created by avvasi78 on 30.11.2016.
 */
public abstract class PropertyManager {

    protected Properties properties;

    protected PropertyManager(String pathToFile){
        if (properties == null){
            properties = new Properties();
            try {
                InputStream inputStream = new FileInputStream(pathToFile);
                properties.load(inputStream);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
