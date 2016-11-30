package config;

import config.properties_handling.PropertyManager;

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
    private static PropertyManager propertyManager = PropertyManager.getInstance();

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
        String logLevel = propertyManager.getLogLevel();
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
        //TODO Create map here (STRING, LEVEL)
//        if (logLevel.equals("ALL")) {
//            logger.setLevel(Level.ALL);
//        } else if (logLevel.equals("SEVERE")) {
//            logger.setLevel(Level.SEVERE);
//        } else if (logLevel.equals("WARNING")) {
//            logger.setLevel(Level.WARNING);
//        } else if (logLevel.equals("CONFIG")) {
//            logger.setLevel(Level.CONFIG);
//        } else if (logLevel.equals("FINE")) {
//            logger.setLevel(Level.FINE);
//        } else if (logLevel.equals("INFO")) {
//            logger.setLevel(Level.INFO);
//        } else if (logLevel.equals("FINER")) {
//            logger.setLevel(Level.FINER);
//        } else if (logLevel.equals("FINEST")) {
//            logger.setLevel(Level.FINEST);
//        } else if (logLevel.equals("OFF")) {
//            logger.setLevel(Level.OFF);
//        } else {
//            logger.setLevel(Level.ALL);
//        }
        logger.setLevel(mapOfLevels.get(logLevel));
    }
}

