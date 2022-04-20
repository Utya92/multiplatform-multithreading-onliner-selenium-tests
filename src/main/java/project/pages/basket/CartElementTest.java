package project.pages.basket;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import project.pages.base.BasePage;

public class CartElementTest extends BasePage {

    public CartElementTest(WebDriver webDriver) {
        super(webDriver);
    }

    private final By addToCartButton = By.xpath("//a[@Class='button-style button-style_base-alter button-style_primary product-aside__button product-aside__button_narrow product-aside__button_cart button-style_expletive']");
    private final By cartButton = By.xpath("//*[@id='container']/div/div/div/div/div[2]/div[1]/main/div/div/aside/div[1]/div[3]/div[1]/div[1]/div[4]/a[2]");

    private final By counterOfGoods = By.xpath("//div[@class='cart-form__description cart-form__description_other cart-form__description_extended']");

    private final By countOfGoodsField = By.xpath("//input[@class='input-style input-style_primary input-style_small input-style_text_center cart-form__input cart-form__input_max-width_xxxxsssss cart-form__input_nonadaptive']");

    public void addItemToCart() {
        webDriver.findElement(addToCartButton).click();
        webDriver.findElement(cartButton).click();
        String check = webDriver.findElement(counterOfGoods).getText();
        System.out.println(check.charAt(0));
        Assertions.assertEquals(1, Integer.parseInt(String.valueOf(check.charAt(0))));

    }
}
