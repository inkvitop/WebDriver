package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.PastebinPage;

public class CreateAndSaveNewPasteTest {
    private WebDriver driver;

    private String code =   "git config --global user.name  \"New Sheriff in Town\"\n" +
                            "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                            "git push origin master --force";
    private String syntaxHighlighting = "Bash";
    private String pasteExpiration = "10 Minutes";
    private String title = "how to gain dominance among developers";

    @BeforeMethod(alwaysRun = true)
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
                .chooseSyntaxHighlighting(syntaxHighlighting)
                .choosePasteExpiration(pasteExpiration)
                .enterPasteTitle(title)
                .savePaste()
                .closeCookiesPolice()
                .checkPasteTitle(title)
                .checkPasteSyntaxHighlighting()
                .checkPasteCode(code);
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        driver.quit();
        driver = null;
    }
}
