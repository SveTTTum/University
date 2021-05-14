import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class TaskICanWin {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        By forInputText = By.id("postform-text");
        By forChooseExpiration = By.xpath("//*[@value='10M']");
        By forInputName = By.id("postform-name");
        By forButtonExpiration = By.xpath("//div[@class='form-group field-postform-expiration']//span[@class='select2-selection__arrow']");
        driver.get("https://pastebin.com");

        WebElement inputText = waitForElementLocatedBy(driver, forInputText);
        inputText.sendKeys("Hello from WebDriver");

        WebElement pasteName = waitForElementLocatedBy(driver, forInputName);
        pasteName.sendKeys("helloweb");

        //открывает выпадающий список
        WebElement buttonExpiration = waitForElementLocatedBy(driver, forButtonExpiration);
        buttonExpiration.click();
        //должно выбирать нужный элемент из выпадающего списка
//        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(forChooseExpiration));
//        Select selectExpirationElement = new Select(driver.findElement(forChooseExpiration));
//        selectExpirationElement.selectByVisibleText("10 Minutes");
//        WebElement selectExpirationElement = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(forChooseExpiration));
//        //  selectExpirationElement.findElement(forChooseExpiration);
//        selectExpirationElement.click();
        List<WebElement> lst = driver.findElements(By.xpath("//*[@id='postform-expiration']/option"));
        lst.get(3).click();


        Thread.sleep(2000);
        driver.quit();
   }

    private static WebElement waitForElementLocatedBy (WebDriver driver, By by) {
        return new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }
}