package config;

import config.properties_handling.ConfigPropertyManager;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * Created by avvasi78 on 29.11.2016.
 */
public class LogHelper {
    private static Logger logger;
    private static ConfigPropertyManager configPropertyManager = ConfigPropertyManager.getInstance();

    public static Logger getInstance() {
        if (logger == null) {
            logger = Logger.getLogger("MyLogs");
            initLogger();
            setLoggingLevel();
            return logger;
        } else {
            return logger;
        }
    }

    private static void initLogger() {
        try {
            FileHandler fh = new FileHandler("./logs/LogFile.log");
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static void setLoggingLevel() {
        String logLevel = configPropertyManager.getLogLevel();
        logger.info("LOG LEVEL: " + logLevel);
        Map<String, Level> mapOfLevels = new HashMap<String, Level>();
        mapOfLevels.put("ALL", Level.ALL);
        mapOfLevels.put("SEVERE", Level.SEVERE);
        mapOfLevels.put("WARNING", Level.WARNING);
        mapOfLevels.put("CONFIG", Level.CONFIG);
        mapOfLevels.put("FINE", Level.FINE);
        mapOfLevels.put("FINER", Level.FINER);
        mapOfLevels.put("FINEST", Level.FINEST);
        mapOfLevels.put("INFO", Level.INFO);
        mapOfLevels.put("OFF", Level.OFF);
        logger.setLevel(mapOfLevels.get(logLevel));
    }
}

