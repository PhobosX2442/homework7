package tests;

import com.codeborne.selenide.Selenide;
import junit.UITest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.ReviewPage;
import pages.TicketPage;
import io.qameta.allure.*;


import static org.assertj.core.api.Assertions.assertThat;

@Feature("Публикация отзыва")
@Epic("Домашка 7")
@Tag("Отзыв")
@Severity(SeverityLevel.NORMAL)
@UITest
public class ReviewPublicationTest {

    public ReviewPage reviewPage = new ReviewPage();
    public TicketPage ticketPage = new TicketPage();

    @Story("Публикация отзыва (тест)")
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
