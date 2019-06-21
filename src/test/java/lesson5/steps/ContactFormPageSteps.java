package lesson5.steps;

import io.qameta.allure.Step;
import lesson3.enums.LeftSideMenu;
import lesson5.ContactFormPage;
import org.openqa.selenium.WebDriver;

public class ContactFormPageSteps {

    private WebDriver driver;

    private ContactFormPage contactFormPage;

    public ContactFormPageSteps(WebDriver driver) {
        this.driver = driver;
        contactFormPage = new ContactFormPage(driver);
    }

    @Step("Natigate to Contact Form page")
    public void goToContactFormPage() {
        contactFormPage.clickLeftSideMenu(LeftSideMenu.CONTACT_FORM);
    }

    @Step("Fill Contact Form")
    public void fillContactFormData(String gender, String lastName) {
        contactFormPage.selectGender(gender);
        contactFormPage.setTextLastNameTextField(lastName);
    }
}
