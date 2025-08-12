package pages;

import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class FilmPage {

    private SelenideElement reviewArea = $("textarea[data-qa-id='movie_review_input']");
    private SelenideElement btnReviewSubmit = $("button[data-qa-id='movie_review_submit_button']");
    private SelenideElement btnGradeReview = $x("//button[@dir='ltr']");
    private SelenideElement reviewText = $(".whitespace-pre-line:first-of-type");
    private SelenideElement btnReviewMenu = $(".lucide-ellipsis-vertical");
    private SelenideElement reviewDeleteOption = $("div[data-qa-id*='delete']");
    private SelenideElement btnBuyTicket = $x("//p[contains(text(), \"Купить билет\")]\n");
    private SelenideElement filmGenre = $("p[class$='mt-5']");

    public SelenideElement getReviewArea() {
        return reviewArea;
    }
    public void setReviewText(String reviewText) {
        reviewArea.setValue(reviewText);
    }

    public void selectGrade(String score) {
        btnGradeReview.scrollTo();
        btnGradeReview.click();
        $x("//*[text() = '" + score + "']/parent::*[@role]").click();
    }

    public void clickBuyTicket() {
        btnBuyTicket.click();
    }
    public void submitReview() {
        btnReviewSubmit.click();
        getReviewArea().shouldNotBe(visible, Duration.ofSeconds(3));

    }

    public String getReviewText() {
        //Получение первого отзыва, так как именно он стабильно наш (если есть)
        return reviewText.getText();
    }

    public void clickReviewDelete() {
        btnReviewMenu.click();
        reviewDeleteOption.click();
    }

    public String getGenreText() {
        return filmGenre.getText();
    }
}
