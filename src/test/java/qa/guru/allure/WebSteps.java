package qa.guru.allure;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class WebSteps {

    @Step("Открываем главную страницу")
    public void openMainPage() {
        open("https://github.com/");
    }

    @Step("Поиск репозитория {repo}")
    public void searchForRepository(String repo) {
        $(".HeaderSearch-module__trigger__zsF9q").click();
        $(".prc-components-Input-IwWrt").sendKeys(repo);
        $(".prc-components-Input-IwWrt").pressEnter();
    }

    @Step("Клик по ссылке на репозиторий {repo}")
    public void clickOnRepositoryLink(String repo) {
        $(linkText(repo)).click();
    }

    @Step("Открываем раздел Issues")
    public void openIssuesTab() {
        $("#issues-tab").click();
    }

    @Step("Проверяем наличие Issue с названием {issue}")
    public void shouldSeeIssueWithName(String issue) {
        $(withText(issue)).should(Condition.exist);
    }
}
