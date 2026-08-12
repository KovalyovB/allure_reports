package qa.guru.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class SelenideTest {

    @Test
    public void TestIssueSearch() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com/");

        $(".HeaderSearch-module__trigger__zsF9q").click();
        $(".prc-components-Input-IwWrt").sendKeys("KovalyovB/allure_reports");
        $(".prc-components-Input-IwWrt").pressEnter();

        $(linkText("KovalyovB/allure_reports")).click();
        $("#issues-tab").click();

        $(withText("Autotest_issue")).should(Condition.exist);
    }
}
