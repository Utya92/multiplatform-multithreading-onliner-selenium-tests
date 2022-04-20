package project.pages.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static project.constants.WebConstants.WebDriverWaitConstants.EXPLICIT_WAIT;

public class BasePage {

    public WebDriver webDriver;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }


    public void goToUrl(String URL) {
        webDriver.get(URL);
    }


    //wait for visibility of element
    public WebElement waitElementIsVisible(WebElement webElement) {
        new WebDriverWait(webDriver, EXPLICIT_WAIT)
                .until(ExpectedConditions.visibilityOf(webElement));
        return webElement;
    }


}


