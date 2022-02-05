package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PastebinPage {
    private WebDriver driver;
    private static final String PASTEBIN_HOME = "https://pastebin.com";

    @FindBy(xpath = "//textarea[@id='postform-text']")
    private WebElement codeTextArea;

    @FindBy(xpath = "//*[@class='select2-selection select2-selection--single']")
    private WebElement syntaxHighlightingDropMenu;

    @FindBy(xpath = "//label[text()='Paste Expiration:']/..//span[@class='select2-selection select2-selection--single']")
    private WebElement pasteExpirationDropMenu;

    @FindBy(xpath = "//input[@name='PostForm[name]']")
    private WebElement titleTextArea;

    @FindBy(xpath = "//button[@type='submit' and text()='Create New Paste']")
    private WebElement createNewPasteButton;

    @FindBy(xpath = "//div[@class='qc-cmp2-summary-buttons']//button[text()='AGREE']")
    private WebElement agreeCookiesButton;

    @FindBy(xpath = "//input[@id='paste-raw-on']/..//label[@for='paste-raw-on']")
    private WebElement syntaxHighlightingSwitch;

    @FindBy(xpath = "//div[@class='header_sign']//a[@href='/login']")
    private WebElement logInButton;

    public PastebinPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public PastebinPage openPage() {
        driver.get(PASTEBIN_HOME);
        return this;
    }

    public PastebinPage enterPastTextCode(String code) {
        codeTextArea.sendKeys(code);
        return this;
    }

    public PastebinPage chooseSyntaxHighlighting(String syntaxHighlighting) {
        syntaxHighlightingDropMenu.click();
        WebElement syntaxHighlightingResultPoint = driver.findElement(By.xpath("//li[text()='" + syntaxHighlighting + "']"));
        syntaxHighlightingResultPoint.click();
        return this;
    }

    public PastebinPage choosePasteExpiration(String pasteExpiration) {
        pasteExpirationDropMenu.click();
        WebElement pasteExpirationResultPoint = driver.findElement(By.xpath("//li[text()='" + pasteExpiration + "']"));
        pasteExpirationResultPoint.click();
        return this;
    }

    public PastebinPage enterPasteTitle(String title) {
        titleTextArea.sendKeys(title);
        return this;
    }

    public PastePage savePaste() {
        createNewPasteButton.click();
        return new PastePage(driver);
    }

    public PastebinPage closeCookiesPolice() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(agreeCookiesButton)).click();
        return this;
    }
}
