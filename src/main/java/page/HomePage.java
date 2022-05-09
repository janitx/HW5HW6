package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;


public class HomePage extends BasePage {

    private static final int SECONDS = 20;

    private WebElement searchBar;
    private WebElement findButton;

    public HomePage(WebDriver driver) {
        super(driver);
         init();
    }

    private void init() {
        searchBar = findElementByXpath("//input[@name='search']", Duration.ofSeconds(SECONDS));
        findButton = findElementByXpath("//button[contains(@class,'search-form__submit')]", Duration.ofSeconds(SECONDS));
    }

    public HomePage inputSearchQuery(String searchQuery) {
        searchBar.clear();
        searchBar.sendKeys(searchQuery);
        return this;
    }

    public HomePage clickOnFindButton() {
        findButton.click();
        return this;
    }

    public static HomePage getHomePage(WebDriver driver) {
        return new HomePage(driver);
    }
}

