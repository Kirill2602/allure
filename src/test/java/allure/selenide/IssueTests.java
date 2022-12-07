package allure.selenide;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class IssueTests {
    SelenideElement searchInput = $(".header-search-input");

    @Test
    void issueSearchTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        open("https://github.com");

        searchInput.click();
        searchInput.sendKeys("Kirill2602/allure_example");
        searchInput.submit();

        $(linkText("Kirill2602/allure_example")).click();
        $("#issues-tab").click();
        $(withText("Test issue")).shouldBe(exist);
    }
}
