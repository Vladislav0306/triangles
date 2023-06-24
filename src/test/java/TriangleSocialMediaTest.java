import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;

public class TriangleSocialMediaTest {
    @BeforeEach
    void setUp() {
        open("https://playground.learnqa.ru/puzzle/triangle");
    }

    @Test
    @DisplayName("32. Переход по ссылке ВКонтакте")
    public void followTheLinkVKontakte() {
        $x("//*[@href=\"https://vk.com/learnqa\"]").click();
        switchTo().window(1);
        $x("//*[@class=\"page_name\"]").shouldBe(visible, Duration.ofSeconds(11))
                .shouldHave(exactText("LearnQA: Обучение тестировщиков онлайн"));
    }

    @Test
    @DisplayName("33. Переход по ссылке YouTube")
    public void followTheLinkYouTube() {
        $x("//*[@href=\"https://youtube.com/user/comolder/learnqa\"]").click();
        switchTo().window(1);
        $x("//*[@class=\"style-scope ytd-channel-name\"]").shouldBe(visible, Duration.ofSeconds(11))
                .shouldHave(exactText("LearnQA: Онлайн обучение тестировщиков"));
    }

    @Test
    @DisplayName("34. Переход по ссылке Telegram")
    public void followTheLinkTelegram() {
        $x("//*[@href=\"https://t.me/learnqa\"]").click();
        switchTo().window(1);
        $x("//*[@class=\"tgme_page_title\"]").shouldBe(visible, Duration.ofSeconds(11))
                .shouldHave(exactText("LearnQA: обучение тестировщиков онлайн"));
    }
}
