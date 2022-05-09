package element;

import org.openqa.selenium.WebElement;
import utils.Log;


public class Button extends AbstractElement{

    public Button(WebElement element) {
        super(element);
        Log.setNameClass("Button");
    }

    @Override
    public void click() {
        if(element.isEnabled()){
            element.click();
            Log.info("Button click()");
        }
    }
}
