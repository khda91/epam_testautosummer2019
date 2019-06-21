package lesson5;

import base.BaseTest;
import lesson5.steps.ContactFormPageSteps;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(AllureAttachmentListener.class)
public class Example01 extends BaseTest {

    ContactFormPageSteps contactFormPageSteps;

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        contactFormPageSteps = new ContactFormPageSteps(driver);
    }

    @Test
    public void simpleStepTest() {
        HomePage hp = PageFactory.initElements(driver, HomePage.class);
        hp.login("epam", "1234");

        contactFormPageSteps.goToContactFormPage();
        contactFormPageSteps.fillContactFormData("Male", "Some name");

        // assert
    }
}
