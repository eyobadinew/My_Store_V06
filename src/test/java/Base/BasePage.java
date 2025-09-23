package Base;

import com.beust.jcommander.Parameter;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.SecureRandom;
import java.sql.Driver;
import java.time.Duration;
import java.util.Properties;

public class BasePage {


    public static WebDriver driver;
    public static Properties prop;

    /**
     * This method is used to initialize the browser on the basis of the given browser
     * @author eyoba
     *
     */

      @BeforeTest
      @Parameters("browserName")
    public WebDriver init_driver() {


         String browserName = prop.getProperty("browser");
          /*if (browserName == null) {
              browserName = System.getProperty("browser", "chrome");
              System.out.println("Using browser from system property: " + browserName);
          }
*/
        System.out.println("The browser value is " +browserName);
        if(browserName.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        }
        else if(browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        }
        else if(browserName.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        }
        else if(browserName.equalsIgnoreCase("safari")) {
            driver = new SafariDriver();
        }
        else {System.out.println("The browser is "+browserName);
        }
        driver.manage().deleteAllCookies();
      //  driver.manage().window().fullscreen();
          driver.manage().window().maximize();;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));


        return driver;

    }


    /**
     * This method is used to load properties from config.properties file
     * @return it returns Properties prop reference*/

    public Properties init_properties() {
        prop = new Properties();

        try {
            FileInputStream file = new FileInputStream("./src/test/java/Config/config.properties");
            prop.load(file);
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        }
        return prop;
    }

    public String randomAlphaNumeric(){
        SecureRandom secureRandom = new SecureRandom();

        // Generate a 20-character alphanumeric secure random string
        String secureRandomString = RandomStringUtils.random(8, 0, 0, true, true, null, secureRandom);

        System.out.println("Secure Random String: " + secureRandomString);
        return secureRandomString;
    }

    public String randomNumber(){
        SecureRandom secureRandom = new SecureRandom();

        // Generate a 20-character alphanumeric secure random string
        String secureRandomString = RandomStringUtils.random(8, 0, 0, false, true, null, secureRandom);

        System.out.println("Secure Random String: " + secureRandomString);
        return secureRandomString;
    }
    public String randomString(){
        SecureRandom secureRandom = new SecureRandom();

        // Generate a 20-character alphanumeric secure random string
        String secureRandomString = RandomStringUtils.random(8, 0, 0, true, false, null, secureRandom);

        System.out.println("Secure Random String: " + secureRandomString);
        return secureRandomString;
    }


}
