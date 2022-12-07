package allure.websteps;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.nio.file.WatchEvent;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class WebSteps {
    public SelenideElement searchInput = $(".header-search-input");

    @Step("Open main page")
    public void openMainPage() {
        open("https://github.com");
    }

    @Step("Find repository {repo}")
    public void findRepository(String repo) {
        searchInput.click();
        searchInput.sendKeys(repo);
        searchInput.submit();
    }

    @Step("Click to {repo} link")
    public void clickToRepositoryLink(String repo) {
        $(linkText(repo)).click();
    }
    @Step("Go to issue tab")
    public void clickToIssueTab() {
        $("#issues-tab").click();
    }

    @Step("Checking for availability issue text on page")
    public void checkingForAvailabilityIssueTextOnPage(String issue) {
        $(withText(issue)).shouldBe(exist);
        takeScreenshot();
    }

    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
