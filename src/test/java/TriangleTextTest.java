import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;

public class TriangleTextTest {
    @BeforeEach
    void setUp() {
        open("https://playground.learnqa.ru/puzzle/triangle");
    }

    @Test
    @DisplayName("26. Скрытие текста вверху страницы")
    public void hidingTextAtTheTopOfThePage() {
        $x("//*[@id=\"puzzle\"]/div[1]/p[5]/button").click();
        $x("//*[@id=\"puzzle\"]/div[1]/p[5]/button").shouldBe(visible, Duration.ofSeconds(11))
                .shouldHave(exactText("Показать текст выше"));
    }

    @Test
    @DisplayName("27. Показ текста вверху страницы")
    public void showTextAtTheTopOfThePage() {
        $x("//*[@id=\"puzzle\"]/div[1]/p[5]/button").click();
        $x("//*[@id=\"puzzle\"]/div[1]/p[5]/button").click();
        $x("//*[@id=\"puzzle\"]/div[1]/p[1]").shouldBe(visible, Duration.ofSeconds(11))
                .shouldHave(exactText("На собеседованиях начинающим тестировщикам часто дают задание на проверку работы формы. Одно из наиболее популярных – тестирование программы, которая определяет тип треугольника по трем его сторонам. Каждая из сторон задается в отдельном текстовом поле."));
    }
}
