package base;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

    public static WebDriver driver;
    public static Properties prop = new Properties();
    public static Properties loc = new Properties();

    @BeforeMethod
    public void setup() throws IOException {

        if (driver == null) {
            FileReader fr = new FileReader(
                    System.getProperty("user.dir") + "\\src\\test\\resources\\configfile\\Config.properties");
            FileReader frl = new FileReader(
                    System.getProperty("user.dir") + "\\src\\test\\resources\\configfile\\locaters.properties");
            prop.load(fr);
           loc.load(frl);
        }

        if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();  // Assign to the class-level driver
        } 
        else if (prop.getProperty("browser").equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();  // Assign to the class-level driver
        }
        
        driver.get(prop.getProperty("testurl"));
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.close();  // This will now close the browser without causing a NullPointerException
            System.out.println("Test Successfully");
        }
    }

}
