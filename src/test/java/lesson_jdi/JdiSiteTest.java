package lesson_jdi;

import com.epam.jdi.light.driver.get.DriverData;
import lesson_jdi.entities.Users;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.driver.get.DriverData.*;
import static com.epam.jdi.light.ui.html.PageFactory.initElements;
import static org.openqa.selenium.UnexpectedAlertBehaviour.ACCEPT;
import static org.openqa.selenium.ie.InternetExplorerDriver.UNEXPECTED_ALERT_BEHAVIOR;
import static org.openqa.selenium.remote.CapabilityType.ACCEPT_SSL_CERTS;

public class JdiSiteTest {
    @BeforeClass
    public void beforeClass() {
//        WebDriverFactory.useDriver("myChrome", () -> {
//            return new ChromeDriver();
//        });
//        WebDriverFactory.useDriver("myChrome");
        DriverData.CHROME_OPTIONS = () -> {
            ChromeOptions cap = new ChromeOptions();
            cap.addArguments("--start-maximized");
            return cap;
        };
        initElements(JdiSite.class);
    }

    @Test
    public void loginTest() {
        JdiSite.open();
        JdiSite.homePage.login(Users.PETER);
        JdiSite.homePage.checkLoggedin(Users.PETER);
    }

    @AfterClass
    public void afterClass() {
        killAllSeleniumDrivers();
    }
}
