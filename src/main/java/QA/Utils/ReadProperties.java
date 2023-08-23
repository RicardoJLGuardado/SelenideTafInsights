package QA.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;


//Add methods in order to get the properties

public class ReadProperties {

    private static ReadProperties instance = null;
    private Properties configProperties;

    public ReadProperties(){

        File configuration = new File("Resources/Resources.properties");
        configProperties = readFile(configuration);

    }

    public Properties readFile(File file){
        Properties properties = null;

        try {
            FileInputStream fis = new FileInputStream(file);
            properties = new Properties();
            properties.load(fis);
            fis.close();

        }catch (Exception e){
            System.out.println("Error reading file: " + e);
        }
        return properties;
    }

    public static ReadProperties getInstance(){

        if(instance == null){

            return new ReadProperties();
        }

        return instance;
    }

    //Methods to get properties add if necessary

    public String getUrl(){

        String url = configProperties.getProperty("url");
        return url;
    }

    public String getBrowser(){

        String browser = configProperties.getProperty("browser");
        return browser;
    }




}
