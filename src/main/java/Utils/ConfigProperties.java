package Utils;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;

/**
 * Created by bogash on 22.06.15.
 */
public class ConfigProperties {
    private static Properties PROPERTIES;
    private static String key;

    static {
        PROPERTIES=new Properties();
        URL props=ClassLoader.getSystemResource("Config.properties");
        try {
            PROPERTIES.load(props.openStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static String getProperty(String key){
        return PROPERTIES.getProperty(key);
    }

    public static boolean getBoolProperty(String key){

        if (PROPERTIES.getProperty(key).equals("true")) {
            return true;
        }
        else return false;
    }
}
