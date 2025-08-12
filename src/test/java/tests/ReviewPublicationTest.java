package tests;

import junit.UITest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.FilmCatalogPage;
import pages.FilmPage;
import io.qameta.allure.*;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static org.assertj.core.api.Assertions.assertThat;

@Feature("Публикация отзыва")
@Epic("Домашка 7")
@Tag("smoke")
@Severity(SeverityLevel.NORMAL)
@UITest
public class ReviewPublicationTest {

    private FilmPage filmPage = new FilmPage();
    private FilmCatalogPage filmCatalogPage = new FilmCatalogPage();

    @Story("Публикация отзыва (тест)")
    @DisplayName("Публикация отзыва")
    @Test
    public void publicationReview() {

        String reviewText = "Какой-то невнятный отзыв";

        filmCatalogPage.selectFilm("Титаник");
        filmPage.setReviewText(reviewText);
        filmPage.selectGrade("4");
        filmPage.submitReview();
        filmPage.getReviewArea().shouldNotBe(visible, Duration.ofSeconds(3));

        String newReviewText = filmPage.getReviewText();

        //проверка на нахождения нужного отзыва
        assertThat(newReviewText).isEqualTo(reviewText);
        //удаление отзыва
        filmPage.clickReviewDelete();
    }
}
