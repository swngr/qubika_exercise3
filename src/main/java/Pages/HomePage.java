package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import Helpers.WaitForLoad;

public class HomePage {
    private WebDriver driver;
    private WaitForLoad waitForLoad;
    // Define the href link to verify
    String expectedHref = "https://qubika.com/wp-content/uploads/2024/10/qubika-fav-120x120.png";
    //Page's fav icon
    private By pageFavIcon = By.xpath("//head/link[contains(@href,'" + expectedHref + "')]");
    private By contactUsButton = By.xpath("//a[contains(text(), 'Contact')]");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.waitForLoad = new WaitForLoad(driver);
    }

    // Method to verify if the current URL matches the expected URL
    public void verifyUrl(String expectedUrl) {
        waitForLoad.waitForPageToLoad();
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "The actual URL does not match the expected URL.");
    }

    public void logoValidation() {
        waitForLoad.waitForPageToLoad();
        WebElement linkElement = driver.findElement(pageFavIcon);
        Assert.assertTrue(linkElement.isEnabled(), "Qubika logo is not displayed.");
    }
    public ContactUsForm clickOnContactUsButton() {
        driver.findElement(contactUsButton).click();
        return new ContactUsForm(driver);
    }

}