import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class TriangleLearnQATest {
    @BeforeEach
    void setUp() {
        open("https://playground.learnqa.ru/puzzle/triangle");
    }

    @Test
    @DisplayName("31. Переход на главную страницу learnqa.ru")
    public void hidingTextAtTheTopOfThePage() {
        $x("//*[@id=\"logo\"]/a").click();
        switchTo().window(1);
        $x("//*[@id=\"recorddiv123836764\"]/div[3]/div/div/div/div[1]/div[1]/div/h1").shouldBe(visible, Duration.ofSeconds(11))
                .shouldHave(exactText("LearnQA - обучение тестировщиков онлайн"));
    }
}
