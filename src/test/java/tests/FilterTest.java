package tests;

import io.qameta.allure.*;
import junit.UITest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.FilmCatalogPage;
import pages.FilmPage;

import static org.assertj.core.api.Assertions.assertThat;

@Epic("Домашка 7")
@Feature("Настройка фильтров")
@Tag("smoke")
@Severity(SeverityLevel.CRITICAL)
@UITest
public class FilterTest  {
   private FilmPage filmPage = new FilmPage();

    @Story("Настройка фильтров (тест)")
    @DisplayName("Настройка фильтров")
    @Test

    public void useFilters() {

        String setGenre = "Мюзикл";

        new FilmCatalogPage()
                .clickFilterPage()
                .setCityFilter("MSK")
                .setSortFilter("Старые")
                .setGenreFilter(setGenre)

        .clickFilm(1);

        String genre = filmPage.getGenreText();

        Allure.step("Проверяем нахождение на странице с фильтрами", () -> {
            assertThat(genre).isEqualTo("Жанр: " + setGenre);
        });

    }
}

