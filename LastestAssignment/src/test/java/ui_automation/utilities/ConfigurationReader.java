package ui_automation.utilities;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
public class ConfigurationReader {
    private static Properties properties;
    public static String getProperty(String fileName, String key) {
        try {
            // we are dynamically generating path to the specified file
            String path = "src/test/resources/"+ fileName;
            // create fileInputStream obj
            FileInputStream stream = new FileInputStream(path);
            // create Properties obj
            properties = new Properties();
            // send fileInputStream obj to properties constructor
            properties.load(stream);
            // close()
            stream.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
        return properties.getProperty(key); }
}