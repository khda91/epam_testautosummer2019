package lesson_jdi;

import com.epam.jdi.light.driver.WebDriverFactory;
import lesson_jdi.entities.Users;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.epam.jdi.light.ui.html.PageFactory.initElements;

public class JdiSiteTest {
    @BeforeClass
    public void beforeClass() {
        WebDriverFactory.useDriver("myChrome", () -> {
            return new ChromeDriver();
        });
        WebDriverFactory.useDriver("myChrome");
        initElements(JdiSite.class);
    }

    @Test
    public void loginTest() {
        JdiSite.open();
        JdiSite.homePage.login(Users.PETER);
        JdiSite.homePage.checkLoggedin(Users.PETER);
    }
}
