package Utility;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class EnvProperties {

    Properties properties = new Properties();
    
    public EnvProperties() {

        java.net.URL url = ClassLoader.getSystemResource("config.properties");

        try  {
            properties.load(url.openStream());
        } catch (FileNotFoundException fie) {
            fie.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getProperty(String name) {
        return properties.getProperty(name);
    }
}
