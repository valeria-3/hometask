import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private WebDriver driver;

    public MainPage (WebDriver driver){

        this.driver = driver;
    }

    private By newPaste = By.id("postform-text");
    private By syntax = By.xpath("//span[@id='select2-postform-format-container']");
    private By pasteExpiration = By.xpath("//span[@id='select2-postform-expiration-container']");
    private By title = By.id("postform-name");
    private By submitButton = By.xpath("//button[text()= 'Create New Paste']");





    public MainPage typePaste(String newPasteText) {
        driver.findElement(newPaste).sendKeys(newPasteText);
        return this;
    }
    public MainPage typeTitle(String titleText) {
        driver.findElement(title).sendKeys(titleText);
        return this;
    }
    public MainPage selectSyntax(String syntaxType) {
        driver.findElement(syntax).click();
        String syntaxXpath = "//li[text() = '%s']";
        driver.findElement(By.xpath(String.format(syntaxXpath,syntaxType))).click();
        return this;
    }

    public MainPage selectPasteExpiration(String expirationValue) {
        driver.findElement(pasteExpiration).click();
        String expirationXpath = "//li[text() = '%s']";
        driver.findElement(By.xpath(String.format(expirationXpath, expirationValue))).click();
        return this;
    }

    public ResultPage clickSubmit(String newPasteText, String titleText, String syntaxType, String expirationValue) {
        this.typePaste(newPasteText);
        this.typeTitle(titleText);
        this.selectSyntax(syntaxType);
        this.selectPasteExpiration(expirationValue);
        driver.findElement(submitButton).click();
        return new ResultPage(driver);
    }



}
