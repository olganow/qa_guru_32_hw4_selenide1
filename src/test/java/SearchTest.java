import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SearchTest {

    @BeforeEach
    void beforeEach() {
        open("https://github.com/");
    }

    @Test
    void successfulSearchJUnit5WithCssTest() {
        $("button[aria-label=\"Search or jump to…\"]").pressEnter();
        $("#query-builder-test").setValue("selenide").pressEnter();
        $("a[href=\"/selenide/selenide\"]").click();
        $("span[data-content=\"Wiki\"]").click();
        $("a[class=\"internal present\"][href=\"/selenide/selenide/wiki/SoftAssertions\"]").shouldHave(text("Soft assertions"));
        $("a[class=\"internal present\"][href=\"/selenide/selenide/wiki/SoftAssertions\"]").click();
        $("ul +div + div + ul ~div>h4[class=\"heading-element\"]").shouldHave(text("Using JUnit5 extend test class:"));
        $("#wiki-body").shouldHave(text("@ExtendWith({SoftAssertsExtension.class})\n" +
                "class Tests {\n" +
                "  @Test\n" +
                "  void test() {\n" +
                "    Configuration.assertionMode = SOFT;\n" +
                "    open(\"page.html\");\n" +
                "\n" +
                "    $(\"#first\").should(visible).click();\n" +
                "    $(\"#second\").should(visible).click();\n" +
                "  }\n" +
                "}"));
    }

    @Test
    void successfulSearchJUnit5WithXpathTest() {
        $x("//button[@aria-label=\"Search or jump to…\"]").pressEnter();
        $x("//input[@id=\"query-builder-test\"]").setValue("selenide").pressEnter();
        $x("//a[@href=\"/selenide/selenide\"]").click();
        $x("//span[@data-content='Wiki']").click();
        $x("//a[contains(text(),'Soft assertions')]").shouldHave(text("Soft assertions"));
        $x("//a[contains(text(),'Soft assertions')]").click();
        $x("//h4[contains(text(),'Using JUnit5 extend test class:')]").shouldHave(text("Using JUnit5 extend test class:"));
        $x("//h4[contains(text(),'Using JUnit5 extend test class:')]").shouldHave(text("Using JUnit5 extend test class:"));
        $x("//*[@id=\"wiki-body\"]").shouldHave(text("@ExtendWith({SoftAssertsExtension.class})\n" +
                "class Tests {\n" +
                "  @Test\n" +
                "  void test() {\n" +
                "    Configuration.assertionMode = SOFT;\n" +
                "    open(\"page.html\");\n" +
                "\n" +
                "    $(\"#first\").should(visible).click();\n" +
                "    $(\"#second\").should(visible).click();\n" +
                "  }\n" +
                "}"));
    }
}
