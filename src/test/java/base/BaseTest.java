package base;

import Pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    private WebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public void setUp() {
        // Set up the WebDriver (using ChromeDriver as an example)
        System.setProperty("webdriver.chrome.driver","browser/chromedriver");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);

        // Navigate to the target URL
        driver.manage().window().maximize();
        driver.get("https://qubika.com/");

        System.out.println(driver.getTitle());

        // Initialize the HomePage object
        homePage = new HomePage(driver);

    }

//    @AfterClass
//    public void tearDown() {
//        driver.quit();
//    }

}
