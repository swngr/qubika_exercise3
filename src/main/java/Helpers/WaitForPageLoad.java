package Helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitForPageLoad{

    private WebDriver driver;
    WebDriverWait wait ;

    public WaitForPageLoad(WebDriver driver) {
       this.driver = driver;
    }

    public void waitForPageToLoad() {
        // Use WebDriverWait to wait for the document.readyState to be 'complete'
        new WebDriverWait(driver, 30).until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
    }

    public void waitForElement(String elementName) {
        try {
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            // Wait for the element to be clickable
            //submitButton = By.xpath("//input[@type='submit']");
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='" + elementName + "']")));

            // Perform actions on the element
            element.click();
        } catch (Exception e) {
            System.out.println("Element not interactable or not found within the wait time.");

        }
    }


}
