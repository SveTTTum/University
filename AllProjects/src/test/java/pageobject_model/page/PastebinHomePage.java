package pageobject_model.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PastebinHomePage extends AbstractPage {
    private static final String HOMEPAGE_URL = "https://pastebin.com";

    @FindBy(id = "postform-text")
    private WebElement inputText;

    @FindBy(xpath = "//*[@id='select2-postform-expiration-container' and @title='10 Minutes']")
    private WebElement pasteExpiration;

    @FindBy(id = "postform-name")
    private WebElement pasteName;

    public PastebinHomePage(WebDriver driver) {
        super(driver);
    }

    public PastebinHomePage openPage() {
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(CustomCondition.jQueryAJAXsCompleted());
        return this;
    }

    public PastebinHomePage inputNewPaste(String code) {
        inputText.sendKeys(code);
        return this;
    }

    public PastebinHomePage setExpiration() {
        pasteExpiration.click();
        return this;
    }

    public PastebinHomePage inputName(String name) {
        pasteName.sendKeys(name);
        return this;
    }
}
