package Helpers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForPageLoad{

    private WebDriver driver;

    public WaitForPageLoad(WebDriver driver) {
       this.driver = driver;
    }

    public void waitForPageToLoad() {
        // Use WebDriverWait to wait for the document.readyState to be 'complete'
        new WebDriverWait(driver, 30).until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
    }


}
