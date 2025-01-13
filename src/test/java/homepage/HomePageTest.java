package homepage;

import Pages.*;
import base.BaseTest;
import org.testng.annotations.Test;


public class HomePageTest extends BaseTest {

    @Test(priority = 1)
    public void testVerifyUrlAndLogo() throws InterruptedException {
        // Define the expected URL
        String expectedUrl = "https://qubika.com/";
        // Verify if the current URL matches the expected URL
        homePage.verifyUrl(expectedUrl);
        homePage.logoValidation();

    }

    @Test(priority = 2)
    public void testValidateContactUsForm() throws InterruptedException {

        ContactUsForm contactUsForm = homePage.clickOnContactUsButton();

        contactUsForm.clickOnSubmitButton();
        contactUsForm.validateErrorMessages(new String[]{"First Name", "Last Name", "Email", "Company name", "Contact type", "Message"});
        contactUsForm.fillMandatoryFieldsExcept("First Name");
        contactUsForm.clickOnSubmitButton();
        contactUsForm.validateErrorMessages(new String[]{"First Name"});
        contactUsForm.clearFieldsData();
        contactUsForm.inputFirstName("Test name");
        contactUsForm.clickOnSubmitButton();
        contactUsForm.validateErrorMessages(new String[]{"Last Name", "Email", "Company name", "Message"});
        contactUsForm.clearFieldsData();
        contactUsForm.inputFirstName("John");
        contactUsForm.inputLastName("Doe");
        contactUsForm.inputCompany("Qubika Corp");
        contactUsForm.inputContactType("Interested in Qubika services");
        contactUsForm.inputMessage("This is a test message");
        contactUsForm.clickOnSubmitButton();
        contactUsForm.validateErrorMessages(new String[]{"Email"});
    }
}
