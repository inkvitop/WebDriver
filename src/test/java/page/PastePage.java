package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PastePage {
    private WebDriver driver;

    @FindBy(xpath = "//div[@class='info-top']/h1")
    private WebElement postTitle;

    @FindBy(xpath = "//div[@class='qc-cmp2-summary-buttons']//button[text()='AGREE']")
    private WebElement agreeCookiesButton;

    @FindBy(xpath = "//div[@class='post-view']//textarea[@class='textarea']")
    private WebElement postCodeText;

    @FindBy(xpath = "//div[@class='highlighted-code']//a[text()='Bash']")
    private WebElement bashHighlightsButton;

    public PastePage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public PastePage checkPasteTitle(String title) {
        Assert.assertEquals(postTitle.getText(), title, "The published title does not correspond to the entered one.");
        return this;
    }

    public PastePage checkPasteSyntaxHighlighting() {
        Assert.assertTrue(bashHighlightsButton.isDisplayed(), "The entered code is not highlighted with the appropriate syntax.");
        return this;
    }

    public PastePage checkPasteCode(String code) {
        Assert.assertEquals(code, postCodeText.getText(), "The entered code does not match the published one.");
        return this;
    }

    public PastePage closeCookiesPolice() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='qc-cmp2-summary-buttons']//button[text()='AGREE']"))).click();
        return this;
    }
}
