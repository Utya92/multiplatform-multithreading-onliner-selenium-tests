package tests.base;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import project.common.CommonActions;
import project.pages.base.BasePage;
import project.pages.basket.CartElementTest;

import static project.common.Config.CLEAR_COOKIES;
import static project.common.Config.HOLD_BROWSER_OPEN;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {

    protected WebDriver webDriver = CommonActions.createWebdriver();
    protected BasePage basePage = new BasePage(webDriver);

    protected CartElementTest cartElementTest = new CartElementTest(webDriver);

    @AfterEach
    void clearCookiesAndLocalStorage() {
        if (CLEAR_COOKIES) {
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) webDriver;
            webDriver.manage().deleteAllCookies();
            javascriptExecutor.executeScript("window.sessionStorage.clear()");
        }
    }

    @AfterAll
    void clearBrowser() {
        if (!HOLD_BROWSER_OPEN) {
            webDriver.close();
        }
    }


}


