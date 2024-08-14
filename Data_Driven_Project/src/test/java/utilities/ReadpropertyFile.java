package utilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


// The property file should be read and load here

public class ReadpropertyFile {
    public static void main(String[] args) throws IOException {
        FileReader fr_prop = new FileReader("E:\\QA Automation\\Data_Driven_Project\\src\\test\\resources\\configfiles\\config.properties");
        Properties p = new Properties();
        p.load(fr_prop);

        /*System.out.println(p.getProperty("browser"));
        System.out.println(p.getProperty("testurl"));*/
    }
}
