package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ReviewPage {

    private SelenideElement reviewArea = $("textarea[data-qa-id='movie_review_input']");
    private SelenideElement btnReviewSubmit = $("button[data-qa-id='movie_review_submit_button']");
    private SelenideElement scrollScore = $x("//button[@dir='ltr']");
    private SelenideElement newReviewText = $x("//*[@id=\"root\"]/div[1]/main/div/div[1]/div/div/div[2]/p");
    private SelenideElement btnReview = $(".lucide-ellipsis-vertical");
    private SelenideElement btnReviewDelete = $("div[data-qa-id*='delete']");

    public void clickReviewArea(String reviewText) {
        reviewArea.setValue(reviewText);
    }

    public SelenideElement getScore(String score) {
        return $x("//*[text() = '" + score + "']/parent::*[@role]");
    }

    public void writeScore(String score) {
        scrollScore.scrollTo();
        scrollScore.click();
        getScore(score).click();
    }

    public void submitReview() {
        btnReviewSubmit.click();
    }

    public String getReviewText() {
        return newReviewText.getText();
    }

    public void clickReviewDelete() {
        btnReview.click();
        btnReviewDelete.click();
    }
}
