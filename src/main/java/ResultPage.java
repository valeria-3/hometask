import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class ResultPage {
    private WebDriver driver;

    public ResultPage(WebDriver driver) {
        this.driver = driver;
    }

    private By syntaxButton = By.xpath("//div[@class='left']/a[@class='btn -small h_800']");

    public String getResultText(String syntaxType){
        String resultPasteXpath = "//ol[@class='%s']";
        return driver.findElement(By.xpath(String.format(resultPasteXpath, syntaxType.toLowerCase(Locale.ROOT)))).getText();
    }
    public String getSyntax(){
        return driver.findElement(syntaxButton).getText();}

 public String getTitle() {
     WebDriverWait wait = new WebDriverWait (driver, 5);
     wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='notice -success -post-view']")));
     return driver.getTitle();

 } }