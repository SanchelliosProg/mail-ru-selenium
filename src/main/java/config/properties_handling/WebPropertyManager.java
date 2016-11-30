package config.properties_handling;

/**
 * Created by avvasi78 on 30.11.2016.
 */
public class WebPropertyManager extends PropertyManager {
    private static WebPropertyManager instance;
    private static final String PATH = "./resources/web.properties";

    protected WebPropertyManager(String pathToFile) {
        super(pathToFile);
    }

    public static WebPropertyManager getInstance() {
        if (instance == null) {
            instance = new WebPropertyManager(PATH);
            return instance;
        } else {
            return instance;
        }
    }

    public String getBaseUrl(){
        return properties.getProperty(PropertyNames.BASE_URL.getPropertyName());
    }
}
