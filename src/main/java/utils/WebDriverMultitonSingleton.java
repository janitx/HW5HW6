package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

// WebDriverMultitonSingleton
public final class WebDriverMultitonSingleton {

    private static ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();

    private WebDriverMultitonSingleton() {
    }

    public static WebDriver getInstance() {

        if (webDriverThreadLocal.get() != null) {
            return webDriverThreadLocal.get();
        }

        chromedriver().setup();
        WebDriver instance = new ChromeDriver();

        webDriverThreadLocal.set(instance);


        return webDriverThreadLocal.get();
    }

    public static void closeBrowser() {
        webDriverThreadLocal.get().quit();
    }

}