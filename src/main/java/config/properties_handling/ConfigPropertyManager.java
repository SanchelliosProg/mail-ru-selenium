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
public class ConfigPropertyManager extends PropertyManager{
    private static ConfigPropertyManager instance;
    private static final String PATH = "./resources/config.properties";


    protected ConfigPropertyManager(String pathToFile) {
        super(pathToFile);
    }

    public static ConfigPropertyManager getInstance(){
        if (instance == null){
            instance = new ConfigPropertyManager(PATH);
            return instance;
        }else {
            return instance;
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
