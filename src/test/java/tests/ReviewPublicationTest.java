package tests;

import api.client.AuthClient;
import api.steps.MovieSteps;
import io.qameta.allure.*;
import junit.UITest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.FilmCatalogPage;
import pages.FilmPage;

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
        filmPage.setTextReview(reviewText);
        filmPage.selectGrade("4");
        filmPage.submitReview();

        String newReviewText = filmPage.getTextReview();

        Allure.step("Проверяем текст", () -> {
            assertThat(newReviewText).isEqualTo(reviewText);
        });

        Integer id = Integer.parseInt(filmPage.getMovieId());
        String token = AuthClient.getAuthToken();

        MovieSteps.deleteReview(id, token);
    }
}
