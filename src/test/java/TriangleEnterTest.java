import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class TriangleEnterTest {
    @BeforeEach
    void setUp() {
        open("https://playground.learnqa.ru/puzzle/triangle");
    }

    @Test
    @DisplayName("1. Ввод нулевых значений сторон треугольника")
    public void enteringZeroValuesForTheSidesOfATriangle() {
        $x("//*[@class=\"js_a\"]").setValue("0");
        $x("//*[@class=\"js_b\"]").setValue("0");
        $x("//*[@class=\"js_c\"]").setValue("0");
        $x("//*[@class=\"btn btn-submit\"]").click();
        $x("//*[@class=\"info logg\"]").shouldBe(visible, Duration.ofSeconds(11))
                .shouldHave(exactText("Это равносторонний треугольник.\n" +
                        "Вы ввели:\n" +
                        "A: 0; B: 0; C: 0"));
        // Обнаружен баг. Ссылка: https://github.com/Vladislav0306/triangles/issues/1
    }

    @Test
    @DisplayName("2. Ввод вещественных значений сторон треугольника")
    public void enteringRealValuesOfTheSidesOfATriangle() {
        $x("//*[@class=\"js_a\"]").setValue("1.1");
        $x("//*[@class=\"js_b\"]").setValue("1.1");
        $x("//*[@class=\"js_c\"]").setValue("1.1");
        $x("//*[@class=\"btn btn-submit\"]").click();
        $x("//*[@class=\"info logg error\"]").shouldBe(visible, Duration.ofSeconds(11))
                .shouldHave(exactText("Это НЕ треугольник.\n" +
                        "Вы ввели:\n" +
                        "A: 1.1; B: 1.1; C: 1.1"));
        // Обнаружен баг. Ссылка: https://github.com/Vladislav0306/triangles/issues/2
    }

    @Test
    @DisplayName("3. Оставление поля \"Сторона A\" при вводе значений сторон треугольника пустой")
    public void leavingTheSideAFieldWhenEnteringValuesForTheSidesOfATriangleBlank() {
        $x("//*[@class=\"js_b\"]").setValue("5");
        $x("//*[@class=\"js_c\"]").setValue("5");
        $x("//*[@class=\"btn btn-submit\"]").click();
        $x("//*[@class=\"info logg error\"]").shouldBe(visible, Duration.ofSeconds(11))
                .shouldHave(exactText("Задайте все стороны."));
    }

    @Test
    @DisplayName("4. Оставление поля \"Сторона B\" при вводе значений сторон треугольника пустой")
    public void leavingTheSideBFieldWhenEnteringValuesForTheSidesOfATriangleBlank() {
        $x("//*[@class=\"js_a\"]").setValue("5");
        $x("//*[@class=\"js_c\"]").setValue("5");
        $x("//*[@class=\"btn btn-submit\"]").click();
        $x("//*[@class=\"info logg error\"]").shouldBe(visible, Duration.ofSeconds(11))
                .shouldHave(exactText("Задайте все стороны."));
    }

    @Test
    @DisplayName("5. Оставление поля \"Сторона C\" при вводе значений сторон треугольника пустой")
    public void leavingTheSideCFieldWhenEnteringValuesForTheSidesOfATriangleBlank() {
        $x("//*[@class=\"js_a\"]").setValue("5");
        $x("//*[@class=\"js_b\"]").setValue("5");
        $x("//*[@class=\"btn btn-submit\"]").click();
        $x("//*[@class=\"info logg error\"]").shouldBe(visible, Duration.ofSeconds(11))
                .shouldHave(exactText("Это НЕ треугольник.\n" +
                        "Вы ввели:\n" +
                        "A: 5; B: 5; C:"));
        // Обнаружен баг. Ссылка: https://github.com/Vladislav0306/triangles/issues/3
    }

    @Test
    @DisplayName("6. Оставление всех полей при вводе значений сторон треугольника пустыми")
    public void leavingAllFieldsEmptyWhenEnteringTriangleSideValues() {
        $x("//*[@class=\"btn btn-submit\"]").click();
        $x("//*[@class=\"info logg error\"]").shouldBe(visible, Duration.ofSeconds(11))
                .shouldHave(exactText("Задайте все стороны."));
    }

    @Test
    @DisplayName("7. Ввод отрицательных значений сторон треугольника")
    public void enteringNegativeSidesOfATriangle() {
        $x("//*[@class=\"js_a\"]").setValue("-1");
        $x("//*[@class=\"js_b\"]").setValue("-1");
        $x("//*[@class=\"js_c\"]").setValue("-1");
        $x("//*[@class=\"btn btn-submit\"]").click();
        $x("//*[@class=\"info logg error\"]").shouldBe(visible, Duration.ofSeconds(11))
                .shouldHave(exactText("Это НЕ треугольник.\n" +
                        "Вы ввели:\n" +
                        "A: -1; B: -1; C: -1"));
    }

    @Test
    @DisplayName("8. Ввод буквенных значений сторон треугольника")
    public void enteringLiteralValuesForTheSidesOfATriangle() {
        $x("//*[@class=\"js_a\"]").setValue("A");
        $x("//*[@class=\"js_b\"]").setValue("B");
        $x("//*[@class=\"js_c\"]").setValue("C");
        $x("//*[@class=\"btn btn-submit\"]").click();
        $x("//*[@class=\"info logg error\"]").shouldBe(visible, Duration.ofSeconds(11))
                .shouldHave(exactText("Это НЕ треугольник.\n" +
                        "Вы ввели:\n" +
                        "A: A; B: B; C: C"));
    }

    @Test
    @DisplayName("9. Ввод спецсимвольных значений сторон треугольника")
    public void enteringSpecialCharactersForTheSidesOfATriangle() {
        $x("//*[@class=\"js_a\"]").setValue("+");
        $x("//*[@class=\"js_b\"]").setValue("@");
        $x("//*[@class=\"js_c\"]").setValue("!");
        $x("//*[@class=\"btn btn-submit\"]").click();
        $x("//*[@class=\"info logg error\"]").shouldBe(visible, Duration.ofSeconds(11))
                .shouldHave(exactText("Это НЕ треугольник.\n" +
                        "Вы ввели:\n" +
                        "A: +; B: @; C: !"));
    }

    @Test
    @DisplayName("10. Ввод XSS-инъекции <script> в поле \"Сторона A\"")
    public void enteringXSSInjectionscriptInSideAField() {
        $x("//*[@class=\"js_a\"]").setValue("<script>");
        $x("//*[@class=\"js_b\"]").setValue("2");
        $x("//*[@class=\"js_c\"]").setValue("2");
        $x("//*[@class=\"btn btn-submit\"]").click();
        $x("//*[@class=\"info logg error\"]").shouldBe(visible, Duration.ofSeconds(11))
                .shouldHave(exactText("XSS это плохо! Так не получится. :)"));
    }

    @Test
    @DisplayName("11. Ввод XSS-инъекции <SCRIPT> в поле \"Сторона A\"")
    public void enteringXSSInjectionSCRIPTInSideAField() {
        $x("//*[@class=\"js_a\"]").setValue("<SCRIPT>");
        $x("//*[@class=\"js_b\"]").setValue("2");
        $x("//*[@class=\"js_c\"]").setValue("2");
        $x("//*[@class=\"btn btn-submit\"]").click();
        $x("//*[@class=\"info logg error\"]").shouldBe(visible, Duration.ofSeconds(11))
                .shouldHave(exactText("Это НЕ треугольник.\n" +
                        "Вы ввели:\n" +
                        "A:"));
        // Обнаружен баг. Ссылка: https://github.com/Vladislav0306/triangles/issues/4
    }

    @Test
    @DisplayName("12. Ввод SQL-инъекции в поле \"Сторона A\"")
    public void enteringSQLInjectionInSideAField() {
        $x("//*[@class=\"js_a\"]").setValue("1 or sleep(5)#");
        $x("//*[@class=\"js_b\"]").setValue("2");
        $x("//*[@class=\"js_c\"]").setValue("2");
        $x("//*[@class=\"btn btn-submit\"]").click();
        $x("//*[@class=\"info logg error\"]").shouldBe(visible, Duration.ofSeconds(11))
                .shouldHave(exactText("SQL-инъекции это плохо! Так не получится. :)"));
    }

    @Test
    @DisplayName("19. Ввод больших значений сторон треугольника")
    public void enteringLargeTriangleSideValues() {
        $x("//*[@class=\"js_a\"]").setValue("100000000");
        $x("//*[@class=\"js_b\"]").setValue("100000000");
        $x("//*[@class=\"js_c\"]").setValue("100000000");
        $x("//*[@class=\"btn btn-submit\"]").click();
        $x("//*[@class=\"info logg error\"]").shouldBe(visible, Duration.ofSeconds(11))
                .shouldHave(exactText("Числа слишком большие.\n" +
                        "Вы ввели:\n" +
                        "A: 100000000; B: 100000000; C: 100000000"));
    }

    @Test
    @DisplayName("20. Ввод длинных строк в полях значений сторон треугольника")
    public void enteringLongStringsInTriangleSideValueFields() {
        $x("//*[@class=\"js_a\"]").setValue("1000000000000000000000000000000000000000000");
        $x("//*[@class=\"js_b\"]").setValue("1000000000000000000000000000000000000000000");
        $x("//*[@class=\"js_c\"]").setValue("1000000000000000000000000000000000000000000");
        $x("//*[@class=\"btn btn-submit\"]").click();
        $x("//*[@class=\"info logg error\"]").shouldBe(visible, Duration.ofSeconds(11))
                .shouldHave(exactText("Строки слишком длинные"));
    }
}