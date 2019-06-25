package lesson6.steps;

import lesson6.HomePage;
import lesson6.hooks.TestContext;

public abstract class BaseStep {

    protected HomePage homePage;

    public BaseStep() {
        homePage = HomePage.getInstance(TestContext.getDriver());
    }

}
