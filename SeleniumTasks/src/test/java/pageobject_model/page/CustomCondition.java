package pageobject_model.page;

import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CustomCondition {
    public static ExpectedCondition<Boolean>  jQueryAJAXsCompleted () {
        return new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver){
                return (Boolean) ((JavascriptExecutor)driver).executeScript("");
            }
        };
    }
}
