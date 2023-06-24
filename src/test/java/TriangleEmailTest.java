import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class TriangleEmailTest {
    @BeforeEach
    void setUp() {
        open("https://playground.learnqa.ru/puzzle/triangle");
    }

    @Test
    @DisplayName("28. Подписка на рассылку")
    public void newsletterSubscription() {
        $x("//*[@class=\"sp-form-control \"]").setValue("vlad.ezhkov.96@mail.ru");
        $x("//*[@class=\"sp-button\"]").click();
        $x("//*[@id=\"sp-form-159970\"]/div/div[1]/p[2]").shouldBe(visible, Duration.ofSeconds(11))
                .shouldHave(exactText("На указанный вами электронный адрес vlad.ezhkov.96@mail.ru было выслано письмо со ссылкой для подтверждения подписки."));
    }

    @Test
    @DisplayName("29. Оставление поля ввода email пустым")
    public void leavingTheEmailInputFieldEmpty() {
        $x("//*[@class=\"sp-button\"]").click();
        $x("//*[@class=\"sp-tip sp-invalid\"]").shouldBe(visible, Duration.ofSeconds(11))
                .shouldHave(exactText("Обязательное поле"));
    }

    @Test
    @DisplayName("30. Ввод невалидного email")
    public void enteringInvalidEmail() {
        $x("//*[@class=\"sp-form-control \"]").setValue("12345");
        $x("//*[@class=\"sp-button\"]").click();
        $x("//*[@class=\"sp-tip sp-invalid\"]").shouldBe(visible, Duration.ofSeconds(11))
                .shouldHave(exactText("Неверный email-адрес"));
    }
}
