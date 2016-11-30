package config.properties_handling;

import config.LogHelper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import static config.properties_handling.PropertyNames.*;

/**
 * Created by avvasi78 on 29.11.2016.
 */
public class PropertyManager {
    //private final String LOG_LEVEL = "logLevel";
    //private final String BROWSER = "browser";
    private static PropertyManager instance;

    private Properties properties;

    public static PropertyManager getInstance(){
        if (instance == null){
            instance = new PropertyManager();
            return instance;
        }else {
            return instance;
        }
    }

    private PropertyManager(){
        if (properties == null){
            properties = new Properties();
            try {
                InputStream inputStream = new FileInputStream("./resources/config.properties");
                properties.load(inputStream);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String getLogLevel(){
        LogHelper.getInstance().info(LOG_LEVEL.getPropertyName());
        return properties.getProperty(LOG_LEVEL.getPropertyName());
    }

    public String getBrowserName(){
        return properties.getProperty(BROWSER_NAME.getPropertyName());
    }
}
