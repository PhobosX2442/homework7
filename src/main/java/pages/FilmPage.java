package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class FilmPage {

    private SelenideElement reviewArea = $("textarea[data-qa-id='movie_review_input']");
    private SelenideElement btnReviewSubmit = $("button[data-qa-id='movie_review_submit_button']");
    private SelenideElement btnGradeReview = $x("//button[@dir='ltr']");
    private SelenideElement lastReview = $x("//*[@id=\"root\"]/div[1]/main/div/div[1]/div/div/div[2]/p");
    private SelenideElement btnReviewMenu = $(".lucide-ellipsis-vertical");
    private SelenideElement reviewDeleteOption = $("div[data-qa-id*='delete']");
    private SelenideElement btnBuyTicket = $x("//p[contains(text(), \"Купить билет\")]\n");

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
    }

    public String getReviewText() {
        return lastReview.getText();
    }

    public void clickReviewDelete() {
        btnReviewMenu.click();
        reviewDeleteOption.click();
    }
}
