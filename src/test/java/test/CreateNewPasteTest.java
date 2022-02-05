package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import page.PastebinPage;

public class CreateNewPasteTest {
    private WebDriver driver;

    private String code = "Hello from WebDriver";
    private String pasteExpiration = "10 Minutes";
    private String title = "helloweb";

    @BeforeMethod (alwaysRun = true)
    public void setupBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void createNewPaste() {
        new PastebinPage(driver)
                .openPage()
                .closeCookiesPolice()
                .enterPastTextCode(code)
                .choosePasteExpiration(pasteExpiration)
                .enterPasteTitle(title);
    }

    @AfterMethod (alwaysRun = true)
    public void closeBrowser() {
        driver.quit();
        driver = null;
    }
}
