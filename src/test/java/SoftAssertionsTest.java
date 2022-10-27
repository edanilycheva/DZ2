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
        $("[data-test-selector=\"nav-search-input\"]").setValue("selenide").pressEnter();
        $$("ul.repo-list li").first().$("a").click();

//        - Перейдите в раздел Wiki проекта
        $("#wiki-tab").click();
        sleep(5000);

//        - Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
        $("#wiki-pages-box ul").scrollTo();
        $("#wiki-pages-box ul li button").click();
        $("#wiki-pages-box").shouldHave(text("SoftAssertions"));
//        - Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5
        $$("#wiki-pages-box ul li").findBy(text("SoftAssertions")).click();
        $("#wiki-content").shouldHave(text("Using JUnit5 extend test class"));
    }
}
