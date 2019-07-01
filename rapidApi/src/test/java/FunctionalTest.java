import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.concurrent.TimeUnit;

public class FunctionalTest {
    public static WebDriver driver;

    static final String INPUT_PATH = "\\src\\test\\java\\drivers\\chromedriver.exe";

    @Before
    public void initialize() {

        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + INPUT_PATH);
        driver = new ChromeDriver();
//To maximize browser
        driver.manage().window().maximize();
//Implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//To open testPage
        driver.get("http://the-internet.herokuapp.com/dynamic_loading/2");


    }

    @After
    public void cleanUp() {
        driver.navigate().refresh();
        driver.close();
    }

}
