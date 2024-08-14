package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {

    public static WebDriver driver;
    //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

    public static Properties prop = new Properties();
    public static Properties loc = new Properties();
    public static FileReader fr_prop;
    public static FileReader fr_loc;

    //@BeforeTest
    // Setup should be run fefore calling the method(=first test), here drivers should be loaded.
    @BeforeMethod
    public void setUP() throws IOException {
        if (driver == null) {
            // System.out.println("The path is: " + System.getProperty("user.dir")); // Path of the Project
            FileReader fr_prop = new FileReader(System.getProperty("user.dir") + "\\src\\test\\resources\\configfiles\\config.properties");
            FileReader fr_loc = new FileReader(System.getProperty("user.dir") + "\\src\\test\\resources\\configfiles\\locators.properties");

            prop.load(fr_prop);
            loc.load(fr_loc);
        }

        if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
           // WebDriverManager.chromedriver().driverVersion("125.0.6422.78").setup();
            //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            driver = new ChromeDriver();
          //  driver.manage().window().maximize();
            driver.get(prop.getProperty("testurl"));
        } else if (prop.getProperty("browser").equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.get(prop.getProperty("testurl"));
        }
    }

   // @AfterTest
    // Teardown should be called after running the 'First Test' method.
    /*@AfterMethod
    public void tearDown() {
        driver.close();
        System.out.println("Teardown worked successfully!!");
    }*/

}
