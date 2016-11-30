package config.properties_handling;

/**
 * Created by alex on 30.11.16.
 */
public enum  PropertyNames {
    LOG_LEVEL ("logLevel"),
    BROWSER_NAME ("browser");

    private final String name;

    private PropertyNames(String name){
        this.name = name;
    }

    public String getPropertyName(){
        return this.name;
    }
}
