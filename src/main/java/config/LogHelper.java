package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * Created by avvasi78 on 29.11.2016.
 */
public class LogHelper {
    private static final String LOG_LEVEL = "logLevel";
    private static Logger logger;
    private static FileHandler fh;

    public static Logger getInstance(){
        if (logger == null){
            logger = Logger.getLogger("MyLogs");
            initLogger();
            setLoggingLevel();
            return logger;
        }else {
            return logger;
        }
    }

    private static void initLogger() {
        try {
            fh = new FileHandler("./logs/LogFile.log");
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
        } catch (IOException ex) {

        }
    }

    private static void setLoggingLevel(){
        Properties properties = new Properties();
        InputStream inputStream;

        try{
            inputStream = new FileInputStream("./resources/config.properties");
            properties.load(inputStream);
            String logLevel = properties.getProperty(LOG_LEVEL);
            if (logLevel.equals("ALL")) {
                logger.setLevel(Level.ALL);
            } else if (logLevel.equals("SEVERE")) {
                logger.setLevel(Level.SEVERE);
            } else if (logLevel.equals("WARNING")) {
                logger.setLevel(Level.WARNING);
            } else if (logLevel.equals("CONFIG")) {
                logger.setLevel(Level.CONFIG);
            } else if (logLevel.equals("FINE")) {
                logger.setLevel(Level.FINE);
            } else if (logLevel.equals("INFO")) {
                logger.setLevel(Level.INFO);
            } else if (logLevel.equals("FINER")) {
                logger.setLevel(Level.FINER);
            } else if (logLevel.equals("FINEST")) {
                logger.setLevel(Level.FINEST);
            } else if (logLevel.equals("OFF")) {
                logger.setLevel(Level.OFF);
            } else {
                logger.setLevel(Level.ALL);
            }

        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
