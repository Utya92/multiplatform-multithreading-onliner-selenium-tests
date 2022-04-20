package tests.basket.positive;

import org.junit.jupiter.api.Test;
import tests.base.BaseTest;

public class CartElementTest extends BaseTest {


    @Test
    public void testAddElement() {
        basePage.goToUrl("https://catalog.onliner.by/phoneaccum/nokia_copy/bl5c");
        cartElementTest.addItemToCart();
    }


}
