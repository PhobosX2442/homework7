package tests;

import junit.UITest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.FilmCatalogPage;
import pages.FilmPage;
import io.qameta.allure.*;

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

        filmCatalogPage.selectFilm("Титаник");
        filmPage.setReviewText("Какой-то невнятный отзыв");
        filmPage.selectGrade("4");
        filmPage.submitReview();

        String newReviewText = filmPage.getReviewText();

        //проверка на нахождения нужного отзыва
        assertThat(newReviewText).isEqualTo("Какой-то невнятный отзыв");
        //удаление отзыва
        filmPage.clickReviewDelete();
    }
}
