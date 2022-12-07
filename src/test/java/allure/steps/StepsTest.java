package allure.steps;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class StepsTest {
    private static final String REPOSITORY = "Kirill2602/allure_example";
    private static final String ISSUE_TEXT = "Test issue";

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Test", url = "https://github.com/Kirill2602/allure_example")
    @DisplayName("Checking for availability issue text on page")
    @Owner("Kirill")
    public void lambdaStepsTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        SelenideElement searchInput = $(".header-search-input");

        step("Open main page", () -> {
            open("https://github.com");
        });

        step("Find repository", () -> {
            searchInput.click();
            searchInput.sendKeys(REPOSITORY);
            searchInput.submit();
        });

        step("Click to repository link", () -> {
            $(linkText(REPOSITORY)).click();
        });

        step("Go to issue tab", () -> {
            $("#issues-tab").click();
        });

        step("Checking for availability issue text on page", () -> {
            $(withText(ISSUE_TEXT)).shouldBe(exist);
        });
    }
}
