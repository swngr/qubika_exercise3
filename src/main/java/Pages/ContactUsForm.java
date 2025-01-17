package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class ContactUsForm {
    private WebDriver driver;
    private By firstName = By.name("firstname");
    private By lastName = By.name("lastname");
    private By email = By.name("email");
    private By company = By.name("company");
    private By contactType = By.name("contact_type");
    private By message = By.name("message");
    private By submitButton = By.xpath("//input[@type='submit']");

    public ContactUsForm(WebDriver driver) {
        this.driver = driver;
    }

    public void inputFirstName(String userFirstName) {
        driver.findElement(firstName).sendKeys(userFirstName);
    }

    public void inputLastName(String userLastName) {
        driver.findElement(lastName).sendKeys(userLastName);
    }

    public void inputEmail(String userEmail) {
        driver.findElement(email).sendKeys(userEmail);
    }

    public void inputCompany(String userCompany) {
        driver.findElement(company).sendKeys(userCompany);
    }

    public void inputContactType(String value) {
        try {
            // Locate the dropdown element
            WebElement dropdownElement = driver.findElement(contactType);
            // Create a Select instance
            Select dropdown = new Select(dropdownElement);
            // select by value attribute
            dropdown.selectByValue(value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void inputMessage(String userMessage) {
        driver.findElement(message).sendKeys(userMessage);
    }

    public void clickOnSubmitButton() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(submitButton).click();
    }

    public void validateErrorMessages(String[] fieldsWithErrors) {
        for (String field : fieldsWithErrors) {
            switch (field) {
                case "First Name":
                    field = "firstname";
                    break;
                case "Last Name":
                    field = "lastname";
                    break;
                case "Email":
                    field = "email";
                    break;
                case "Company name":
                    field = "company";
                    break;
                case "Contact type":
                    field = "contact_type";
                    break;
                case "Message":
                    field = "message";
                    break;

            }
            WebElement errorMessage;
            if (field.equals("contact_type"))
                errorMessage = driver.findElement(By.xpath("//*[contains(@name,'" + field + "')]/../../../*[contains(@class, 'hs-error-msgs')]"));
            else
                errorMessage = driver.findElement(By.xpath("//*[contains(@name,'" + field + "')]/../../*[contains(@class, 'hs-error-msgs')]"));
            Assert.assertTrue(errorMessage.isDisplayed(), "Error message for " + field + " is not displayed.");
            Assert.assertEquals(errorMessage.getText(), "Please complete this required field.");
        }
    }

    public void fillMandatoryFieldsExcept(String exceptField) {
        if (!exceptField.equals("First Name")) {
            inputFirstName("John");
        }
        if (!exceptField.equals("Last Name")) {
            inputLastName("Doe");
        }
        if (!exceptField.equals("Email")) {
            inputEmail("john.doe@corporation.com");
        }
        if (!exceptField.equals("Company name")) {
            inputCompany("Qubika Corp");
        }
        if (!exceptField.equals("Contact Type")) {
             inputContactType("Interested in Qubika services");
        }
        if (!exceptField.equals("Message")) {
            inputMessage("This is a test message");
        }
    }

    public void clearFieldsData() {
        driver.findElement(firstName).clear();
        driver.findElement(lastName).clear();
        driver.findElement(email).clear();
        driver.findElement(company).clear();
        driver.findElement(message).clear();
    }

}
