package allure.websteps;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

public class WebStepsTest {
    public static final String ISSUE_TEXT = "Test issue";
    public static final String REPOSITORY = "Kirill2602/allure_example";

    @Test
    public void webStepsIssueTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();
        steps.openMainPage();
        steps.findRepository(REPOSITORY);
        steps.clickToRepositoryLink(REPOSITORY);
        steps.clickToIssueTab();
        steps.checkingForAvailabilityIssueTextOnPage(ISSUE_TEXT);
    }
}
