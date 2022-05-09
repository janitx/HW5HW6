import businessobject.CheckSumInCartFacade;
import listener.CheckSumInCartListener;
import org.testng.annotations.*;


@Listeners(CheckSumInCartListener.class)
public class CheckSumInCartTest {

    @BeforeMethod
    public void beforeMethod() {
        CheckSumInCartFacade.runBeforeMethod();
    }

    @DataProvider(name = "filters-file-xml", parallel = true)
    public Object[][] getData() {
        return CheckSumInCartFacade.getData();
    }

    @Test(dataProvider = "filters-file-xml")
    public void checkIfSumInCartIsLess(int id, String product, String brand, int maxPrice) {
        CheckSumInCartFacade.runTest(id, product, brand, maxPrice);
    }

    @AfterMethod
    public void afterMethod() {
        CheckSumInCartFacade.runAfterMethod();
    }
}
