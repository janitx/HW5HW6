package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class SearchPage extends BasePage {

    private List<WebElement> checkboxBrands;
    private WebElement dropdownFilter;
    private WebElement cartButton;

    public SearchPage(WebDriver driver) {
        super(driver);
        init();
    }

    private void init() {
        checkboxBrands = findElementsByXpath("(//div/rz-scrollbar/div/div)[3]//a", Duration.ofSeconds(20));
    }

    public SearchPage clickOnBrand(String brand) {

        for (int i = 0; i < checkboxBrands.size(); i++) {
            String text = checkboxBrands.get(i).getText();

            if (text.startsWith(brand)) {
                checkboxBrands.get(i).click();
                break;
            }
        }

        return this;
    }

    public SearchPage selectDropDownFilter() {
        dropdownFilter = findElementByXpath("//select", Duration.ofSeconds(20));
        Select dropdown = new Select(dropdownFilter);
        dropdown.selectByVisibleText("От дорогих к дешевым");
        return this;
    }

    public SearchPage clickOnBuyButton() {
        List<WebElement> productsBuyButton = findElementsByXpath("//button[contains(@class,'buy-button')]", Duration.ofSeconds(20));
        productsBuyButton.get(0).click();
        return this;
    }

    public SearchPage clickOnCartButton() {
        try {
            cartButton = findElementByXpath("//li[7]/rz-cart/button", Duration.ofSeconds(10));
            cartButton.click();
        } catch (org.openqa.selenium.ElementClickInterceptedException e) {
            cartButton = findElementByXpath("//li[7]/rz-cart/button", Duration.ofSeconds(20));
            cartButton.click();
        }

        return this;
    }

    public static SearchPage getSearchPage(WebDriver driver) {
        return new SearchPage(driver);
    }


}
