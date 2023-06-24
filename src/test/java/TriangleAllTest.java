import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.Duration;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class TriangleAllTest {
    @BeforeEach
    void setUp() {
        open("https://playground.learnqa.ru/puzzle/triangle");
    }

    @Test
    @DisplayName("21. Нахождение всех ошибок")
    public void findingAllErrors() {
        $x("//*[@class=\"js_a\"]").setValue("0");
        $x("//*[@class=\"js_b\"]").setValue("0");
        $x("//*[@class=\"js_c\"]").setValue("0");
        $x("//*[@class=\"btn btn-submit\"]").click();
        $x("//*[@class=\"counter logg\"]").shouldBe(visible, Duration.ofSeconds(11))
                .shouldHave(exactText("Вы нашли 1 / 4 ошибок\n" +
                        "Попробовали 0 / 12 кейсов"));
        $x("//*[@id=\"puzzle\"]/div[2]/div[1]/div[2]/p[1]").shouldBe(visible, Duration.ofSeconds(11))
                .shouldHave(exactText("Баг - Все нули - не равносторонний треугольник."));
        $x("//*[@class=\"js_a\"]").setValue("1.1");
        $x("//*[@class=\"js_b\"]").setValue("1.1");
        $x("//*[@class=\"js_c\"]").setValue("1.1");
        $x("//*[@class=\"btn btn-submit\"]").click();
        $x("//*[@class=\"counter logg\"]").shouldBe(visible, Duration.ofSeconds(11))
                .shouldHave(exactText("Вы нашли 2 / 4 ошибок\n" +
                        "Попробовали 1 / 12 кейсов"));
        $x("//*[@id=\"puzzle\"]/div[2]/div[1]/div[2]/p[2]").shouldBe(visible, Duration.ofSeconds(11))
                .shouldHave(exactText("Баг - Форма неправильно работает с нецелыми числами."));
        $x("//*[@class=\"js_c\"]").setValue("");
        $x("//*[@class=\"btn btn-submit\"]").click();
        $x("//*[@class=\"counter logg\"]").shouldBe(visible, Duration.ofSeconds(11))
                .shouldHave(exactText("Вы нашли 3 / 4 ошибок\n" +
                        "Попробовали 1 / 12 кейсов"));
        $x("//*[@id=\"puzzle\"]/div[2]/div[1]/div[2]/p[3]").shouldBe(visible, Duration.ofSeconds(11))
                .shouldHave(exactText("Баг - Форма не валидирует поле C."));
        $x("//*[@class=\"js_a\"]").setValue("<SCRIPT>");
        $x("//*[@class=\"btn btn-submit\"]").click();
        $x("//*[@class=\"counter logg\"]").shouldBe(visible, Duration.ofSeconds(11))
                .shouldHave(exactText("Вы нашли 4 / 4 ошибок\n" +
                        "Попробовали 2 / 12 кейсов"));
        $x("//*[@id=\"puzzle\"]/div[2]/div[1]/div[2]/p[4]").shouldBe(visible, Duration.ofSeconds(11))
                .shouldHave(exactText("Баг - Вы нашли XSS."));
        $x("//*[@class=\"ww logg\"]").shouldBe(visible, Duration.ofSeconds(11))
                .shouldHave(exactText("Поздравляю! Вы нашли все баги, что было явно непросто! Как и обещали, даем вам сюрприз побольше: промокод на 10% на любой из курсов с нашего сайта learnqa.ru: lqatrbgs"));
    }

    @Test
    @DisplayName("22. Пробование всех кейсов")
    public void tryingAllCases() {
        $x("//*[@class=\"btn btn-submit\"]").click();
        $x("//*[@class=\"counter logg\"]").shouldBe(visible, Duration.ofSeconds(11))
                .shouldHave(exactText("Вы нашли 0 / 4 ошибок\n" +
                        "Попробовали 1 / 12 кейсов"));
        $x("//*[@id=\"puzzle\"]/div[2]/div[1]/div[3]/p[1]").shouldBe(visible, Duration.ofSeconds(11))
                .shouldHave(exactText("Кейс - Все поля пустые"));
        $x("//*[@class=\"js_a\"]").setValue("6");
        $x("//*[@class=\"btn btn-submit\"]").click();
        $x("//*[@class=\"counter logg\"]").shouldBe(visible, Duration.ofSeconds(11))
                .shouldHave(exactText("Вы нашли 0 / 4 ошибок\n" +
                        "Попробовали 2 / 12 кейсов"));
        $x("//*[@id=\"puzzle\"]/div[2]/div[1]/div[3]/p[2]").shouldBe(visible, Duration.ofSeconds(11))
                .shouldHave(exactText("Кейс - Не все поля заданы"));
        $x("//*[@class=\"js_a\"]").setValue("100000000");
        $x("//*[@class=\"js_b\"]").setValue("100000000");
        $x("//*[@class=\"js_c\"]").setValue("100000000");
        $x("//*[@class=\"btn btn-submit\"]").click();
        $x("//*[@class=\"counter logg\"]").shouldBe(visible, Duration.ofSeconds(11))
                .shouldHave(exactText("Вы нашли 0 / 4 ошибок\n" +
                        "Попробовали 3 / 12 кейсов"));
        $x("//*[@id=\"puzzle\"]/div[2]/div[1]/div[3]/p[3]").shouldBe(visible, Duration.ofSeconds(11))
                .shouldHave(exactText("Кейс - Попробовали большие числа"));
        $x("//*[@class=\"js_a\"]").setValue("1");
        $x("//*[@class=\"js_b\"]").setValue("1");
        $x("//*[@class=\"js_c\"]").setValue("1");
        $x("//*[@class=\"btn btn-submit\"]").click();
        $x("//*[@class=\"counter logg\"]").shouldBe(visible, Duration.ofSeconds(11))
                .shouldHave(exactText("Вы нашли 0 / 4 ошибок\n" +
                        "Попробовали 4 / 12 кейсов"));
        $x("//*[@id=\"puzzle\"]/div[2]/div[1]/div[3]/p[4]").shouldBe(visible, Duration.ofSeconds(11))
                .shouldHave(exactText("Кейс - Равносторонний треугольник"));
        $x("//*[@class=\"js_a\"]").setValue("3");
        $x("//*[@class=\"js_b\"]").setValue("2");
        $x("//*[@class=\"js_c\"]").setValue("2");
        $x("//*[@class=\"btn btn-submit\"]").click();
        $x("//*[@class=\"counter logg\"]").shouldBe(visible, Duration.ofSeconds(11))
                .shouldHave(exactText("Вы нашли 0 / 4 ошибок\n" +
                        "Попробовали 5 / 12 кейсов"));
        $x("//*[@id=\"puzzle\"]/div[2]/div[1]/div[3]/p[5]").shouldBe(visible, Duration.ofSeconds(11))
                .shouldHave(exactText("Кейс - Равнобедренный треугольник"));
        $x("//*[@class=\"js_b\"]").setValue("4");
        $x("//*[@class=\"js_c\"]").setValue("5");
        $x("//*[@class=\"btn btn-submit\"]").click();
        $x("//*[@class=\"counter logg\"]").shouldBe(visible, Duration.ofSeconds(11))
                .shouldHave(exactText("Вы нашли 0 / 4 ошибок\n" +
                        "Попробовали 6 / 12 кейсов"));
        $x("//*[@id=\"puzzle\"]/div[2]/div[1]/div[3]/p[6]").shouldBe(visible, Duration.ofSeconds(11))
                .shouldHave(exactText("Кейс - Прямоугольный треугольник"));
        $x("//*[@class=\"js_a\"]").setValue("10");
        $x("//*[@class=\"js_b\"]").setValue("9");
        $x("//*[@class=\"btn btn-submit\"]").click();
        $x("//*[@class=\"counter logg\"]").shouldBe(visible, Duration.ofSeconds(11))
                .shouldHave(exactText("Вы нашли 0 / 4 ошибок\n" +
                        "Попробовали 7 / 12 кейсов"));
        $x("//*[@id=\"puzzle\"]/div[2]/div[1]/div[3]/p[7]").shouldBe(visible, Duration.ofSeconds(11))
                .shouldHave(exactText("Кейс - Остроугольный треугольник"));
        $x("//*[@class=\"js_c\"]").setValue("2");
        $x("//*[@class=\"btn btn-submit\"]").click();
        $x("//*[@class=\"counter logg\"]").shouldBe(visible, Duration.ofSeconds(11))
                .shouldHave(exactText("Вы нашли 0 / 4 ошибок\n" +
                        "Попробовали 8 / 12 кейсов"));
        $x("//*[@id=\"puzzle\"]/div[2]/div[1]/div[3]/p[8]").shouldBe(visible, Duration.ofSeconds(11))
                .shouldHave(exactText("Кейс - Тупоугольный треугольник"));
        $x("//*[@class=\"js_c\"]").setValue("1");
        $x("//*[@class=\"btn btn-submit\"]").click();
        $x("//*[@class=\"counter logg\"]").shouldBe(visible, Duration.ofSeconds(11))
                .shouldHave(exactText("Вы нашли 0 / 4 ошибок\n" +
                        "Попробовали 9 / 12 кейсов"));
        $x("//*[@id=\"puzzle\"]/div[2]/div[1]/div[3]/p[9]").shouldBe(visible, Duration.ofSeconds(11))
                .shouldHave(exactText("Кейс - Не выполнились условия треугольника"));
        $x("//*[@class=\"js_a\"]").setValue("-1");
        $x("//*[@class=\"js_b\"]").setValue("-1");
        $x("//*[@class=\"js_c\"]").setValue("-1");
        $x("//*[@class=\"btn btn-submit\"]").click();
        $x("//*[@class=\"counter logg\"]").shouldBe(visible, Duration.ofSeconds(11))
                .shouldHave(exactText("Вы нашли 0 / 4 ошибок\n" +
                        "Попробовали 10 / 12 кейсов"));
        $x("//*[@id=\"puzzle\"]/div[2]/div[1]/div[3]/p[10]").shouldBe(visible, Duration.ofSeconds(11))
                .shouldHave(exactText("Кейс - Это не треугольник"));
        $x("//*[@class=\"js_a\"]").setValue("<script>");
        $x("//*[@class=\"btn btn-submit\"]").click();
        $x("//*[@class=\"counter logg\"]").shouldBe(visible, Duration.ofSeconds(11))
                .shouldHave(exactText("Вы нашли 0 / 4 ошибок\n" +
                        "Попробовали 11 / 12 кейсов"));
        $x("//*[@id=\"puzzle\"]/div[2]/div[1]/div[3]/p[11]").shouldBe(visible, Duration.ofSeconds(11))
                .shouldHave(exactText("Кейс - Попробовали XSS"));
        $x("//*[@class=\"js_a\"]").setValue("1 or sleep(5)#");
        $x("//*[@class=\"btn btn-submit\"]").click();
        $x("//*[@class=\"counter logg\"]").shouldBe(visible, Duration.ofSeconds(11))
                .shouldHave(exactText("Вы нашли 0 / 4 ошибок\n" +
                        "Попробовали 12 / 12 кейсов"));
        $x("//*[@id=\"puzzle\"]/div[2]/div[1]/div[3]/p[12]").shouldBe(visible, Duration.ofSeconds(11))
                .shouldHave(exactText("Кейс - Попробовали SQL-инъекцию"));
        $x("//*[@class=\"ww logg\"]").shouldBe(visible, Duration.ofSeconds(11))
                .shouldHave(exactText("Ура! Все кейсы найдены! В качестве обещанного сюрприза мы дарим вам промокод на скидку в 5% на любой из курсов с сайта learnqa.ru: lqatrcs"));
    }
}