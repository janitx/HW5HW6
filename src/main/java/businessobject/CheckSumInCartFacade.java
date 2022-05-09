package businessobject;

import model.FilterProductModel;
import org.testng.Assert;
import utils.*;

import static page.CartPage.getCartPage;
import static page.HomePage.getHomePage;
import static page.SearchPage.getSearchPage;

public class CheckSumInCartFacade {

    public static void runBeforeMethod() {
        String url = new PropertiesReader().getUrl();
        WebDriverMultitonSingleton.getInstance().manage().window().maximize();
        WebDriverMultitonSingleton.getInstance().get(url);
    }

    public static void runAfterMethod() {
        WebDriverMultitonSingleton.closeBrowser();
    }

    public static Object[][] getData() {
        FilterProductModel model = XmlToModelReader.read(new PropertiesReader().getPathToFiltersFileXml());

        Object[][] array = model.getCollection().stream()
                .map(productModel -> new Object[]{
                        productModel.getId(), productModel.getProduct(), productModel.getBrand(), productModel.getPrice()
                }).toArray(Object[][]::new);

        return array;
    }

    public static void runTest(int id, String product, String brand, int maxPrice) {
        getHomePage(WebDriverMultitonSingleton.getInstance()).inputSearchQuery(product).clickOnFindButton();

        getHomePage(WebDriverMultitonSingleton.getInstance()).inputSearchQuery(product).clickOnFindButton();

        getSearchPage(WebDriverMultitonSingleton.getInstance()).clickOnBrand(brand).selectDropDownFilter().clickOnBuyButton().clickOnCartButton();

        int cartPrice = getCartPage(WebDriverMultitonSingleton.getInstance()).getTextOfPriceProductInCart();

        Assert.assertTrue(cartPrice < maxPrice, String.format(" Id%s cartPrice(%s) < maxPrice(%s)", id, cartPrice, maxPrice));
    }
}
