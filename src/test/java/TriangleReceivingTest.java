import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.Duration;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class TriangleReceivingTest {
    @BeforeEach
    void setUp() {
        open("https://playground.learnqa.ru/puzzle/triangle");
    }

    @Test
    @DisplayName("13. Получение равностороннего треугольника")
    public void gettingAnEquilateralTriangle() {
        $x("//*[@class=\"js_a\"]").setValue("1");
        $x("//*[@class=\"js_b\"]").setValue("1");
        $x("//*[@class=\"js_c\"]").setValue("1");
        $x("//*[@class=\"btn btn-submit\"]").click();
        $x("//*[@class=\"info logg\"]").shouldBe(visible, Duration.ofSeconds(11))
                .shouldHave(exactText("Это равносторонний треугольник.\n" +
                        "Вы ввели:\n" +
                        "A: 1; B: 1; C: 1"));
    }

    @Test
    @DisplayName("14. Получение равнобедренного треугольника")
    public void gettingAnIsoscelesTriangle() {
        $x("//*[@class=\"js_a\"]").setValue("3");
        $x("//*[@class=\"js_b\"]").setValue("2");
        $x("//*[@class=\"js_c\"]").setValue("2");
        $x("//*[@class=\"btn btn-submit\"]").click();
        $x("//*[@class=\"info logg\"]").shouldBe(visible, Duration.ofSeconds(11))
                .shouldHave(exactText("Это равнобедренный треугольник.\n" +
                        "Вы ввели:\n" +
                        "A: 3; B: 2; C: 2"));
    }

    @Test
    @DisplayName("15. Невыполнение условий треугольника")
    public void failureToMeetTheConditionsOfTheTriangle() {
        $x("//*[@class=\"js_a\"]").setValue("5");
        $x("//*[@class=\"js_b\"]").setValue("2");
        $x("//*[@class=\"js_c\"]").setValue("2");
        $x("//*[@class=\"btn btn-submit\"]").click();
        $x("//*[@class=\"info logg error\"]").shouldBe(visible, Duration.ofSeconds(11))
                .shouldHave(exactText("Одна сторона больше суммы двух других или равна ей.\n" +
                        "Вы ввели:\n" +
                        "A: 5; B: 2; C: 2"));
    }

    @Test
    @DisplayName("16. Получение тупоугольного треугольника")
    public void gettingAnObtuseTriangle() {
        $x("//*[@class=\"js_a\"]").setValue("10");
        $x("//*[@class=\"js_b\"]").setValue("9");
        $x("//*[@class=\"js_c\"]").setValue("2");
        $x("//*[@class=\"btn btn-submit\"]").click();
        $x("//*[@class=\"info logg\"]").shouldBe(visible, Duration.ofSeconds(11))
                .shouldHave(exactText("Это тупоугольный треугольник.\n" +
                        "Вы ввели:\n" +
                        "A: 10; B: 9; C: 2"));
    }

    @Test
    @DisplayName("17. Получение остроугольного треугольника")
    public void obtainingAnAcuteTriangle() {
        $x("//*[@class=\"js_a\"]").setValue("10");
        $x("//*[@class=\"js_b\"]").setValue("9");
        $x("//*[@class=\"js_c\"]").setValue("5");
        $x("//*[@class=\"btn btn-submit\"]").click();
        $x("//*[@class=\"info logg\"]").shouldBe(visible, Duration.ofSeconds(11))
                .shouldHave(exactText("Это остроугольный треугольник.\n" +
                        "Вы ввели:\n" +
                        "A: 10; B: 9; C: 5"));
    }

    @Test
    @DisplayName("18. Получение прямоугольного треугольника")
    public void gettingARightTriangle() {
        $x("//*[@class=\"js_a\"]").setValue("3");
        $x("//*[@class=\"js_b\"]").setValue("4");
        $x("//*[@class=\"js_c\"]").setValue("5");
        $x("//*[@class=\"btn btn-submit\"]").click();
        $x("//*[@class=\"info logg\"]").shouldBe(visible, Duration.ofSeconds(11))
                .shouldHave(exactText("Это прямоугольный треугольник.\n" +
                        "Вы ввели:\n" +
                        "A: 3; B: 4; C: 5"));
    }
}