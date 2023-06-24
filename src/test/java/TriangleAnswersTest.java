import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class TriangleAnswersTest {
    @BeforeEach
    void setUp() {
        open("https://playground.learnqa.ru/puzzle/triangle");
    }

    @Test
    @DisplayName("23. Просмотр ответов")
    public void viewResponses() {
        $x("//*[@class=\"btn btn-anws\"]").click();
        $x("//*[@href=\"https://www.learnqa.ru/triangles_answers\"]").click();
        switchTo().window(1);
        $x("//*[@class=\"t-btn t400__submit t-btn_md\"]").click();
        $x("//*[@id=\"rec124074656\"]/div/div/div/div").shouldBe(visible, Duration.ofSeconds(11))
                .shouldHave(exactText("В тренажере было два типа задач: проверить 12 тест-кейсов из тех, что мы задумали, и найти 4 спрятанных бага.\n" +
                        "\n" +
                        "Как это обычно и бывает, багов оказалось больше, и многие их нашли и прислали репорты. Спасибо вам! Но обо всем по порядку."));
    }

    @Test
    @DisplayName("24. Скрытие ответов")
    public void hidingAnswers() {
        $x("//*[@id=\"show_answ\"]").click();
        $x("//*[@id=\"hide_answ\"]").click();
        $x("//*[@id=\"show_answ\"]").shouldBe(visible, Duration.ofSeconds(11))
                .shouldHave(exactText("Я сдаюсь"));
    }
}
