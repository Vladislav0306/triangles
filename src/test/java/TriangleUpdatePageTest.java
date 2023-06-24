import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class TriangleUpdatePageTest {
    @BeforeEach
    void setUp() {
        open("https://playground.learnqa.ru/puzzle/triangle");
    }

    @Test
    @DisplayName("25. Обновление страницы после найденных ошибок и кейсов")
    public void updatingThePageAfterFoundErrorsAndCases() {
        $x("//*[@class=\"js_a\"]").setValue("1.1");
        $x("//*[@class=\"js_b\"]").setValue("1.1");
        $x("//*[@class=\"js_c\"]").setValue("1.1");
        $x("//*[@class=\"btn btn-submit\"]").click();
        refresh();
        $x("//*[@class=\"counter logg\"]").shouldBe(visible, Duration.ofSeconds(11))
                .shouldHave(exactText("Вы нашли 0 / 4 ошибок\n" +
                        "Попробовали 0 / 12 кейсов"));
        $x("//*[@id=\"puzzle\"]/div[2]/div[1]/div[2]/p[1]").shouldBe(visible, Duration.ofSeconds(11))
                .shouldHave(exactText("Баг - ??? ?? ???"));
        $x("//*[@id=\"puzzle\"]/div[2]/div[1]/div[3]/p[1]").shouldBe(visible, Duration.ofSeconds(11))
                .shouldHave(exactText("Кейс - ??? ?? ???"));
    }
}
