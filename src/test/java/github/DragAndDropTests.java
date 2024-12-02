package github;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.DragAndDropOptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDropTests {
    @BeforeAll
    static void beforeAll() {
        baseUrl = "https://the-internet.herokuapp.com/drag_and_drop";
        Configuration.pageLoadStrategy = "eager";
    }

    @BeforeEach
    void beforeEach() {
        open(baseUrl);
    }

    @Test
    void actionsTest() {
        $("#column-a").shouldHave(text("A"));
        $("#column-b").shouldHave(text("B"));
        actions().moveToElement($("#column-a")).clickAndHold().moveByOffset(225, 0).release().perform();
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }

    @Test
    void dragAndDropTest() {
        $("#column-a").shouldHave(text("A"));
        $("#column-b").shouldHave(text("B"));
        $("#column-a").dragAndDrop(DragAndDropOptions.to($("#column-b")));
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }
}
