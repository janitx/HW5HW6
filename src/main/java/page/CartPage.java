package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class CartPage extends BasePage {

    private static final String URL = "https://rozetka.com.ua/cart/";
    private WebElement priceProductInCart;

    public CartPage(WebDriver driver) {
        super(driver);
        init();
    }

    private void init() {
        priceProductInCart = findElementByXpath("(//div[@class='cart-receipt__sum-price']/span)[1]", Duration.ofSeconds(20));
    }

    public int getTextOfPriceProductInCart() {
        return Integer.parseInt(priceProductInCart.getText().trim());
    }

    public CartPage getCart() {
        driver.navigate().to(URL);
        return this;
    }

    public static CartPage getCartPage(WebDriver driver) {
        return new CartPage(driver);
    }


}