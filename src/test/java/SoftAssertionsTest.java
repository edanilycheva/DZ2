import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SoftAssertionsTest {
    @BeforeSuite
    static void BeforeSuite() {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void SoftAssertions(){

//        - Откройте страницу Selenide в Github
        open("https://github.com/");
        $("[data-test-selector='nav-search-input']").setValue("selenide").pressEnter();
        $$(".repo-list-item").findBy(text("selenide/selenide")).$("a").click();

//        - Перейдите в раздел Wiki проекта
        $("#wiki-tab").click();

//        - Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
        $(".Box-row.wiki-more-pages-link button").click();

//        - Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5
        $$(".Box-row.wiki-more-pages").findBy(text("SoftAssertions")).click();
        $$("h4").findBy(text("Using JUnit5 extend test class")).sibling(0).shouldHave(text("SoftAssertsExtension"));

    }
}
