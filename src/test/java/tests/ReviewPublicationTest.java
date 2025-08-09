package tests;

import com.codeborne.selenide.Selenide;
import junit.UITest;
import org.junit.jupiter.api.Test;
import pages.ReviewPage;
import pages.TicketPage;
import io.qameta.allure.*;


import static org.assertj.core.api.Assertions.assertThat;

@Epic("Домашка 7")
@UITest
public class ReviewPublicationTest {

    public ReviewPage reviewPage = new ReviewPage();
    public TicketPage ticketPage = new TicketPage();

    @Feature("Публикация отзыва")
    @Test
    public void publicationReview() {

        ticketPage.clickMovie("Титаник");
        reviewPage.clickReviewArea("Какой-то невнятный отзыв");
        reviewPage.writeScore("4");
        reviewPage.submitReview();

        String newReviewText = reviewPage.getReviewText();

        //проверка на нахождения нужного отзыва
        assertThat(newReviewText).isEqualTo("Какой-то невнятный отзыв");
        //удаление отзыва
        reviewPage.clickReviewDelete();
        Selenide.closeWebDriver();
    }
}
