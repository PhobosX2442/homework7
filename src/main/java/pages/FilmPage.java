package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class FilmPage {

    private SelenideElement areaReview = $("textarea[data-qa-id='movie_review_input']");
    private SelenideElement btnReviewSubmit = $("button[data-qa-id='movie_review_submit_button']");
    private SelenideElement btnReviewGrade = $x("//button[@dir='ltr']");
    private SelenideElement textReview = $(".whitespace-pre-line:first-of-type");
    private SelenideElement btnReviewMenu = $(".lucide-ellipsis-vertical");
    private SelenideElement optionReviewDelete = $("div[data-qa-id*='delete']");
    private SelenideElement btnBuyTicket = $x("//p[contains(text(), \"Купить билет\")]\n");
    private SelenideElement textFilmGenre = $("p[class$='mt-5']");


    @Step("Находим поле заполнения отзыва")
    public SelenideElement getAreaReview() {
        return areaReview;
    }

    @Step("Заполняем текст с отзывом")
    public void setTextReview(String textReview) {
        areaReview.setValue(textReview);
    }

    @Step("Выбираем оценку")
    public void selectGrade(String score) {
        btnReviewGrade.scrollTo();
        btnReviewGrade.click();
        $x("//*[text() = '" + score + "']/parent::*[@role]").click();
    }

    @Step("Нажимаем по кнопке покупки билета")
    public void clickBuyTicket() {
        btnBuyTicket.click();
    }

    @Step("Нажимаем по кнопке отправки отзыва")
    public void submitReview() {
        btnReviewSubmit.click();
        getAreaReview().shouldNotBe(visible, Duration.ofSeconds(3));
    }

    @Step("Получаем текст отзыва")
    public String getTextReview() {
        return textReview.getText();
    }

    public String getMovieId() {
        String url = WebDriverRunner.url();
        if (url.contains("/movies/")) {
            return url.replaceFirst("^https?://[^/]+/movies/", "");
        }
        return null;
    }

    @Step("Удаляем оставленный отзыв")
    public void clickDeleteReview() {
        btnReviewMenu.click();
        optionReviewDelete.click();
    }

    @Step("Получаем текст жанра")
    public String getGenreText() {
        return textFilmGenre.getText();
    }
}
